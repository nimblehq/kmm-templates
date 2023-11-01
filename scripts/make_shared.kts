import java.io.File
import java.util.Properties

object NewProject {

    private const val DELIMITER_ARGUMENT = "="

    private const val KEY_APP_NAME = "app-name"
    private const val KEY_DESTINATION = "destination"
    private const val KEY_PACKAGE_NAME = "package-name"

    private const val PATTERN_APP = "^([A-Z][a-zA-Z0-9\\s]*)|([a-z][a-z0-9-]*)$"
    private const val PATTERN_PACKAGE = "^[a-z]+(\\.[a-z][a-z0-9]*)+$"

    private const val SCRIPTS_FOLDER_NAME = "scripts"
    private const val SEPARATOR_DOT = "."
    private const val SEPARATOR_MINUS = "-"
    private const val SEPARATOR_SPACE = " "

    private const val TEMPLATE_APP_NAME = "Template Compose"
    private const val TEMPLATE_PACKAGE_NAME = "co.nimblehq.template.compose"

    private val modules = listOf("shared")

    private val fileSeparator = File.separator

    private var appName: String = ""
        set(value) {
            field = if (value.contains(SEPARATOR_MINUS)) {
                projectFolderName = value
                value.replace(SEPARATOR_MINUS, SEPARATOR_SPACE).uppercaseEveryFirstCharacter()
            } else {
                value.uppercaseEveryFirstCharacter().also {
                    projectFolderName = it.getStringWithoutSpace()
                }
            }
        }

    private var packageName = ""

    private var destination = rootPath

    private var projectFolderName: String = ""

    private val projectPath: String
        get() = destination + projectFolderName

    private val rootPath: String
        get() = System.getProperty("user.dir").let { userDir ->
            if (userDir.endsWith("$fileSeparator$SCRIPTS_FOLDER_NAME")) {
                userDir.substring(0, userDir.lastIndexOf(SCRIPTS_FOLDER_NAME))
            } else {
                "$userDir$fileSeparator"
            }
        }

    private val templatePackageName
        get() = TEMPLATE_PACKAGE_NAME

    private val templateAppName
        get() = TEMPLATE_APP_NAME

    fun generate(args: Array<String>) {
        initializeNewProjectFolder()
        renamePackageNameFolders()
        renamePackageNameWithinFiles()
        renameAppName()
    }

    private fun handleArguments(args: Array<String>) {
        args.forEach { arg ->
            when {
                arg.startsWith("$KEY_APP_NAME$DELIMITER_ARGUMENT") -> {
                    val (key, value) = arg.split(DELIMITER_ARGUMENT)
                    appName = value.trim()
                }
                arg.startsWith("$KEY_PACKAGE_NAME$DELIMITER_ARGUMENT") -> {
                    val (key, value) = arg.split(DELIMITER_ARGUMENT)
                    packageName = value.trim()
                }
            }
        }
    }

    private fun initializeNewProjectFolder() {
        showMessage("=> 🐢 Initializing new project...")
        copyFiles(fromPath = rootPath + "shared", toPath = projectPath)
        // Set gradlew file as executable, because copying files from one folder to another doesn't copy file permissions correctly (= read, write & execute).
        File(projectPath + fileSeparator + "gradlew")?.setExecutable(true)
    }

    private fun renamePackageNameFolders() {
        showMessage("=> 🔎 Renaming the package folders...")
        modules.forEach { module ->
            val srcPath = projectPath + fileSeparator + module + fileSeparator + "src"
            File(srcPath)
                .walk()
                .maxDepth(2)
                .filter { it.isDirectory && it.name == "java" }
                .forEach { javaDirectory ->
                    val oldDirectory = File(
                        javaDirectory, templatePackageName.replace(
                            oldValue = SEPARATOR_DOT,
                            newValue = fileSeparator
                        )
                    )
                    val newDirectory = File(
                        javaDirectory, packageName.replace(
                            oldValue = SEPARATOR_DOT,
                            newValue = fileSeparator
                        )
                    )

                    val tempDirectory = File(javaDirectory, "temp_directory")
                    copyFiles(
                        fromPath = oldDirectory.absolutePath,
                        toPath = tempDirectory.absolutePath
                    )
                    oldDirectory.parentFile?.parentFile?.deleteRecursively()
                    newDirectory.mkdirs()
                    copyFiles(
                        fromPath = tempDirectory.absolutePath,
                        toPath = newDirectory.absolutePath
                    )
                    tempDirectory.deleteRecursively()
                }
        }
    }

    private fun renamePackageNameWithinFiles() {
        showMessage("=> 🔎 Renaming package name within files...")
        File(projectPath)
            .walk()
            .filter { it.name.endsWithAny(".kt", ".xml", ".gradle.kts") }
            .forEach { filePath ->
                replace(
                    sourcePath = filePath.toString(),
                    oldValue = templatePackageName,
                    newValue = packageName
                )
            }
    }

    private fun copyFiles(fromPath: String, toPath: String) {
        val targetFolder = File(toPath)
        val sourceFolder = File(fromPath)
        sourceFolder.copyRecursively(targetFolder, true) { file, exception ->
            showMessage(
                message = "${exception?.message ?: "Error copying files"}",
                isError = true,
            )
            return@copyRecursively OnErrorAction.TERMINATE
        }
    }

    private fun renameAppName() {
        showMessage("=> 🔎 Renaming app name...")
        File(projectPath)
            .walk()
            .filter { it.name == "strings.xml" }
            .forEach { filePath ->
                replace(
                    sourcePath = filePath.toString(),
                    oldValue = templateAppName,
                    newValue = appName
                )
            }
        File(projectPath)
            .walk()
            .filter { it.name == "settings.gradle.kts" }
            .forEach { filePath ->
                replace(
                    sourcePath = filePath.toString(),
                    oldValue = templateAppName,
                    newValue = appName
                )
            }
    }

    private fun replace(sourcePath: String, oldValue: String, newValue: String) {
        val sourceFile = File(sourcePath)
        var sourceText = sourceFile.readText()
        sourceText = sourceText.replace(oldValue, newValue)
        sourceFile.writeText(sourceText)
    }

    private fun showMessage(
        message: String,
        exitAfterMessage: Boolean = false,
        exitValue: Int = 0,
        isError: Boolean = false,
    ) {
        println("\n${if (isError) "❌ " else ""}${message}\n")
        if (exitAfterMessage) {
            if (isError) {
                exitWithError(exitValue)
            } else {
                System.exit(exitValue)
            }
        }
    }

    private fun exitWithError(exitValue: Int = 0) {
        if (projectFolderName.isNotBlank()) {
            val file = File(projectPath)
            if (file.exists()) {
                file.deleteRecursively()
            }
        }
        System.exit(exitValue)
    }

    private fun String.uppercaseEveryFirstCharacter(): String {
        return this.split(SEPARATOR_SPACE).joinToString(separator = SEPARATOR_SPACE) { string ->
            string.replaceFirstChar { it.uppercase() }
        }
    }

    private fun String.getStringWithoutSpace(): String {
        return this.replace(SEPARATOR_SPACE, "")
    }

    private fun String.endsWithAny(vararg suffixes: String): Boolean {
        return suffixes.any { endsWith(it) }
    }
}

NewProject.generate(args)

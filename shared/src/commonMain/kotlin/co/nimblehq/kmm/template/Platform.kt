package co.nimblehq.kmm.template

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
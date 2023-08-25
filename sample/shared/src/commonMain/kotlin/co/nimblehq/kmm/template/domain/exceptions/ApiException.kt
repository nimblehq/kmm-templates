package co.nimblehq.kmm.template.domain.exceptions

data class ApiException(
    val code: String?,
    override val message: String?,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)

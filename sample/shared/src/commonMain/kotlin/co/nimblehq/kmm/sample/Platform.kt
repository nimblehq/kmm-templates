package co.nimblehq.kmm.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

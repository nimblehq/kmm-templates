package co.nimblehq.kmm.template

import dev.icerock.moko.resources.StringResource

expect class Strings {
    fun get(id: StringResource, args: List<Any> = emptyList()): String
}

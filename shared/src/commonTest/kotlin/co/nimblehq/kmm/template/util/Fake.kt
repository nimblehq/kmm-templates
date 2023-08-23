package co.nimblehq.kmm.template.util

import co.nimblehq.kmm.template.domain.model.UserModel

object Fake {

    private val user = UserModel(id = 0)

    val users = listOf(user)
}

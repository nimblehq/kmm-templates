package co.nimblehq.kmm.template.extensions

import app.cash.turbine.test
import co.nimblehq.kmm.template.data.extensions.flowTransform
import co.nimblehq.kmm.template.domain.model.UserModel
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class ResponseMappingTest {

    @Test
    fun `When mapping API request flow failed with Exception - it returns Exception error`() = runTest {
        flowTransform<UserModel> {
            throw Exception()
        }.test {
            awaitError() shouldBe Exception()
        }
    }

    @Test
    fun `When mapping API request flow failed with a generic error - it returns that error`() = runTest {
        val error = IOException("no internet")
        flowTransform<UserModel> {
            throw error
        }.test {
            awaitError() shouldBe error
        }
    }
}

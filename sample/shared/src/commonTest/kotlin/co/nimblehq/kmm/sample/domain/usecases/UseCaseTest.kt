package co.nimblehq.kmm.sample.domain.usecases

import app.cash.turbine.test
import co.nimblehq.kmm.sample.domain.repositories.Repository
import co.nimblehq.kmm.sample.util.Fake.model
import io.kotest.matchers.shouldBe
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class UseCaseTest {

    @Mock
    private val mockRepository: Repository = mock(Repository::class)

    private lateinit var useCase: UseCase

    @BeforeTest
    fun setUp() {
        useCase = UseCaseImpl(mockRepository)
    }

    @Test
    fun `When calling successfully - it returns users`() = runTest {
        given(mockRepository)
            .function(mockRepository::getUsers)
            .whenInvoked()
            .thenReturn(flowOf(listOf(model)))

        useCase().test {
            awaitItem() shouldBe listOf(model)
            awaitComplete()
        }
    }

    @Test
    fun `when calling fails - it throws the corresponding error`() = runTest {
        val throwable = Throwable()
        given(mockRepository)
            .function(mockRepository::getUsers)
            .whenInvoked()
            .thenReturn(
                flow { throw throwable }
            )

        useCase().test {
            awaitError() shouldBe throwable
        }
    }
}

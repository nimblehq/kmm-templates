package co.nimblehq.kmm.template.domain.usecases

import app.cash.turbine.test
import co.nimblehq.kmm.template.domain.repositories.Repository
import co.nimblehq.kmm.template.util.Fake.user
import io.kotest.matchers.shouldBe
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class GetUsersUseCaseTest {

    @Mock
    private val mockRepository: Repository = mock(Repository::class)

    private lateinit var useCase: GetUsersUseCase

    @BeforeTest
    fun setUp() {
        useCase = GetUsersUseCaseImpl(mockRepository)
    }

    @Test
    fun `When calling getUsers successfully - it returns users`() = runTest {
        given(mockRepository)
            .function(mockRepository::getUsers)
            .whenInvoked()
            .thenReturn(flowOf(listOf(user)))

        useCase().test {
            awaitItem() shouldBe listOf(user)
            awaitComplete()
        }
    }

    @Test
    fun `when calling getUsers fails - it throws the corresponding error`() = runTest {
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

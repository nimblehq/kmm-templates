package co.nimblehq.kmm.template.domain.usecase

import app.cash.turbine.test
import co.nimblehq.kmm.template.domain.repository.Repository
import co.nimblehq.kmm.template.util.TestUtil.users
import io.kotest.matchers.shouldBe
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    fun setup() {
        useCase = GetUsersUseCaseImpl(mockRepository)
    }

    @Test
    fun `When calling getUsersUseCase successfully - it returns users`() = runTest {
        given(mockRepository)
            .function(mockRepository::getUsers)
            .whenInvoked()
            .thenReturn(flowOf(users))

        useCase().test {
            awaitItem() shouldBe users
            awaitComplete()
        }
    }
}

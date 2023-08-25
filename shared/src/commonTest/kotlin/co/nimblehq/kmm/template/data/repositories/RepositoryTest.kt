package co.nimblehq.kmm.template.data.repositories

import app.cash.turbine.test
import co.nimblehq.kmm.template.data.remote.datasources.UserRemoteDataSource
import co.nimblehq.kmm.template.domain.repositories.Repository
import co.nimblehq.kmm.template.util.Fake.user
import co.nimblehq.kmm.template.util.Fake.userResponse
import io.kotest.matchers.shouldBe
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class RepositoryTest {

    @Mock
    private val mockUserRemoteDataSource = mock(UserRemoteDataSource::class)

    private lateinit var repository: Repository

    @BeforeTest
    fun setup() {
        repository = RepositoryImpl(mockUserRemoteDataSource)
    }

    @Test
    fun `when calling getUsers successfully - it returns users`() = runTest {
        given(mockUserRemoteDataSource)
            .suspendFunction(mockUserRemoteDataSource::getUsers)
            .whenInvoked()
            .thenReturn(listOf(userResponse))

        repository.getUsers().test {
            awaitItem() shouldBe listOf(user)
            awaitComplete()
        }
    }

    @Test
    fun `when calling getUsers fails - it throws the corresponding error`() = runTest {
        val throwable = Throwable()
        given(mockUserRemoteDataSource)
            .suspendFunction(mockUserRemoteDataSource::getUsers)
            .whenInvoked()
            .thenThrow(throwable)

        repository.getUsers().test {
            awaitError() shouldBe throwable
        }
    }
}

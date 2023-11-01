package co.nimblehq.kmm.sample.data.repositories

import app.cash.turbine.test
import co.nimblehq.kmm.sample.data.remote.datasources.RemoteDataSource
import co.nimblehq.kmm.sample.domain.repositories.Repository
import co.nimblehq.kmm.sample.util.Fake.model
import co.nimblehq.kmm.sample.util.Fake.response
import io.kotest.matchers.shouldBe
import io.mockative.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test

@ExperimentalCoroutinesApi
class RepositoryTest {

    @Mock
    private val mockRemoteDataSource = mock(RemoteDataSource::class)

    private lateinit var repository: Repository

    @BeforeTest
    fun setup() {
        repository = RepositoryImpl(mockRemoteDataSource)
    }

    @Test
    fun `when calling getUsers successfully - it returns users`() = runTest {
        given(mockRemoteDataSource)
            .suspendFunction(mockRemoteDataSource::getUsers)
            .whenInvoked()
            .thenReturn(listOf(response))

        repository.getUsers().test {
            awaitItem() shouldBe listOf(model)
            awaitComplete()
        }
    }

    @Test
    fun `when calling getUsers fails - it throws the corresponding error`() = runTest {
        val throwable = Throwable()
        given(mockRemoteDataSource)
            .suspendFunction(mockRemoteDataSource::getUsers)
            .whenInvoked()
            .thenThrow(throwable)

        repository.getUsers().test {
            awaitError() shouldBe throwable
        }
    }
}

package co.nimblehq.kmm.template.ui.screens

import co.nimblehq.kmm.template.test.CoroutineTestRule
import kotlinx.coroutines.test.StandardTestDispatcher

abstract class BaseScreenTest {

    protected val coroutinesRule = CoroutineTestRule()

    protected fun setStandardTestDispatcher() {
        coroutinesRule.testDispatcher = StandardTestDispatcher()
    }

    protected fun advanceUntilIdle() {
        coroutinesRule.testDispatcher.scheduler.advanceUntilIdle()
    }
}

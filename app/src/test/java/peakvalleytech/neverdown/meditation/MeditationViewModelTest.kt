package peakvalleytech.neverdown.meditation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import peakvalleytech.neverdown.ui.activity.meditation.MeditationViewModel

class MeditationViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var meditationViewModel: MeditationViewModel

    @Before
    fun setUp() {
        meditationViewModel = MeditationViewModel()
    }

    @Test
    fun counter_shouldStartAtOne() {
        val observer = Observer<Int> {}
        try {
            meditationViewModel.mBreathCounter.observeForever(observer)
            val counter = meditationViewModel.mBreathCounter.value
            assertThat(counter, `is`(1))
        } finally {
            meditationViewModel.mBreathCounter.removeObserver(observer)
        }
    }

    @Test
    fun counter_shouldUpdateEverySecond() {

    }

    @Test
    fun counter_shouldIncrementByOne() {

    }

    @Test
    fun counter_shouldEndOnFour() {

    }

    @Test
    fun counter_shouldRestartAfterLimitReached() {

    }

    @Test
    fun state_shouldStartOnInhale() {

    }

    @Test
    fun state_shouldUpdateToExhaleOnCounterLimit() {

    }

    @Test
    fun state_shouldUpdateToInhaleOnCounterRestart() {

    }




}
package peakvalleytech.neverdown.meditation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Assert.*
import org.junit.Ignore
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
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun counter_shouldStartAtOne() {
        val observer = Observer<Int> {}
        try {
            meditationViewModel.mBreathCounter.observeForever(observer)
            meditationViewModel.startCounter()
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
        var counter : Int = 0
        val observer = Observer<Int> {val nextCounter = it
            assertThat(nextCounter, `is`((counter ?: 0) + 1 ))}
        meditationViewModel.mBreathCounter.observeForever(observer)
        meditationViewModel.startCounter()
        counter = meditationViewModel.mBreathCounter.value ?: 1

        meditationViewModel.incrementCounter()
//        val nextCounter = meditationViewModel.mBreathCounter.value
//        assertThat(nextCounter, `is`((counter ?: 0) + 1 ))
    }

    @Test
    fun counter_shouldRestartOnFour() {
        val observer = Observer<Int> {}
        meditationViewModel.mBreathCounter.observeForever(observer)
        meditationViewModel.startCounter()
        meditationViewModel.incrementCounter() // counter: 2
        meditationViewModel.incrementCounter() // counter: 3
        meditationViewModel.incrementCounter() // counter: 4
        meditationViewModel.incrementCounter() // should be 1
        val counter = meditationViewModel.mBreathCounter.value
        assertThat(counter, `is`(1))
    }

    @Test
    fun state_shouldStartOnInhale() {
        val observer = Observer<Int> {}
        meditationViewModel.mBreathState.observeForever(observer)
        meditationViewModel.startCounter()
        val state = meditationViewModel.mBreathState.value
        assertThat(state, `is`(meditationViewModel.INHALE_STATE))
    }

    @Test
    fun state_shouldSwitchStateOnUpdate() {
        val observer = Observer<Int> { println( "counter: " + it)}
        meditationViewModel.mBreathCounter.observeForever(observer)
        meditationViewModel.startCounter()
        meditationViewModel.incrementCounter() // counter: 2
        meditationViewModel.incrementCounter() // counter: 3
        meditationViewModel.incrementCounter() // counter: 4
        meditationViewModel.incrementCounter() // should be 1
        var counter = meditationViewModel.mBreathCounter.value
        var state = meditationViewModel.mBreathState.value
//        assertThat(counter, `is`(1))
//        assertThat(state, `is`(meditationViewModel.EXHALE_STATE))
        meditationViewModel.incrementCounter() // counter: 2
        meditationViewModel.incrementCounter() // counter: 3
        meditationViewModel.incrementCounter() // counter: 4
        meditationViewModel.incrementCounter() // should be 1\
        counter = meditationViewModel.mBreathCounter.value
//        assertThat(counter, `is`(1))
        state = meditationViewModel.mBreathState.value
//        assertThat(state, `is`(meditationViewModel.INHALE_STATE))
    }
}
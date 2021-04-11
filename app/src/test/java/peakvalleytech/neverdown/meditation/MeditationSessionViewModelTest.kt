package peakvalleytech.neverdown.meditation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Assert.*
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import peakvalleytech.neverdown.ui.activity.meditation.session.MeditationSessionViewModel


@RunWith(JUnit4::class)
class MeditationSessionViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var meditationSessionViewModel: MeditationSessionViewModel

    @Before
    fun setUp() {
        meditationSessionViewModel = MeditationSessionViewModel()
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun counter_shouldStartAtOne() {
        val observer = Observer<Int> {}
        try {
            meditationSessionViewModel.mBreathCounter.observeForever(observer)
            meditationSessionViewModel.startCounter()
            val counter = meditationSessionViewModel.mBreathCounter.value
            assertThat(counter, `is`(1))
        } finally {
            meditationSessionViewModel.mBreathCounter.removeObserver(observer)
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
        meditationSessionViewModel.mBreathCounter.observeForever(observer)
        meditationSessionViewModel.startCounter()
        counter = meditationSessionViewModel.mBreathCounter.value ?: 1

        meditationSessionViewModel.incrementCounter()
//        val nextCounter = meditationSessionViewModel.mBreathCounter.value
//        assertThat(nextCounter, `is`((counter ?: 0) + 1 ))
    }

    @Test
    fun counter_shouldRestartOnFour() {
        val observer = Observer<Int> {}
        meditationSessionViewModel.mBreathCounter.observeForever(observer)
        meditationSessionViewModel.startCounter()
        meditationSessionViewModel.incrementCounter() // counter: 2
        meditationSessionViewModel.incrementCounter() // counter: 3
        meditationSessionViewModel.incrementCounter() // counter: 4
        meditationSessionViewModel.incrementCounter() // should be 1
        val counter = meditationSessionViewModel.mBreathCounter.value
        assertThat(counter, `is`(1))
    }

    @Test
    fun state_shouldStartOnInhale() {
        val observer = Observer<Int> {}
        meditationSessionViewModel.mBreathState.observeForever(observer)
        meditationSessionViewModel.startCounter()
        val state = meditationSessionViewModel.mBreathState.value
        assertThat(state, `is`(meditationSessionViewModel.INHALE_STATE))
    }

    @Test
    fun state_shouldSwitchStateOnUpdate() {
        val observer = Observer<Int> { println( "counter: " + it)}
        meditationSessionViewModel.mBreathCounter.observeForever(observer)
        meditationSessionViewModel.startCounter()
        meditationSessionViewModel.incrementCounter() // counter: 2
        meditationSessionViewModel.incrementCounter() // counter: 3
        meditationSessionViewModel.incrementCounter() // counter: 4
        meditationSessionViewModel.incrementCounter() // should be 1
        var counter = meditationSessionViewModel.mBreathCounter.value
        var state = meditationSessionViewModel.mBreathState.value
//        assertThat(counter, `is`(1))
//        assertThat(state, `is`(meditationSessionViewModel.EXHALE_STATE))
        meditationSessionViewModel.incrementCounter() // counter: 2
        meditationSessionViewModel.incrementCounter() // counter: 3
        meditationSessionViewModel.incrementCounter() // counter: 4
        meditationSessionViewModel.incrementCounter() // should be 1\
        counter = meditationSessionViewModel.mBreathCounter.value
//        assertThat(counter, `is`(1))
        state = meditationSessionViewModel.mBreathState.value
//        assertThat(state, `is`(meditationSessionViewModel.INHALE_STATE))
    }
}
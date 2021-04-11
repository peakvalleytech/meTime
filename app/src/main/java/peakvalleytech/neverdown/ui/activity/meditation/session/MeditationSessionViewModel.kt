package peakvalleytech.neverdown.ui.activity.meditation.session

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MeditationSessionViewModel: ViewModel() {

    /**
     * The counter for the breathing during the meditation
     */
    private val _mBreathCounter = MutableLiveData<Int>()
    val mBreathCounter: LiveData<Int> = _mBreathCounter

    /**
     * Keep track of whether we are in the inhale or exhale state
     */
    private val _mBreathState = MutableLiveData<Int>()
    var mBreathState = _mBreathState

    /**
     * Start the counter
     */
    fun startCounter() {
        _mBreathCounter.value = 1
        _mBreathState.value = INHALE_STATE

    }

    /**
     * Increment the counter
     */
    fun incrementCounter() {
        viewModelScope.launch{
            println("incrementing counter")
            delay(1100)
            var counter = _mBreathCounter.value
            if (counter != null) {
                if (counter == 4) {
                    counter = 1
                    var nextState =
                        if (_mBreathState.value == INHALE_STATE) EXHALE_STATE else INHALE_STATE
                    _mBreathState.value = nextState
                } else {
                    ++counter
                }
                _mBreathCounter.value = counter
            }
        }
    }

    val INHALE_STATE = 1
    val EXHALE_STATE = 2
}

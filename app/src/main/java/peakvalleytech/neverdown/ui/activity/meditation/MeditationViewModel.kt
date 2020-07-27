package peakvalleytech.neverdown.ui.activity.meditation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MeditationViewModel : ViewModel() {

    /**
     * The counter for the breathing during the meditation
     */
    private val _mBreathCounter = MutableLiveData<Int>()
    var mBreathCounter = _mBreathCounter

    /**
     * Keep track of whether we are in the inhale or exhale state
     */
    var _mBreathState = MutableLiveData<Int>()
    var mBreathState = _mBreathState

    /**
     * Set the counter
     */
    fun setCounter() {

    }

    /**
     * Increment the counter
     */
    fun incrementCounter() {

    }

    /**
     * Restart the counter
     */
    fun restartCounter() {

    }



    val INHALE_STATE = 1
    val EXHALE_STATE = 2
}

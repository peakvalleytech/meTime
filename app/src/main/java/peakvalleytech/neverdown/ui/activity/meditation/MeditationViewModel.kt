package peakvalleytech.neverdown.ui.activity.meditation

import androidx.lifecycle.ViewModel

class MeditationViewModel : ViewModel() {

    /**
     * The counter for breating during the meditation
     */
    var mBreathCounter = 1

    /**
     * Keep track of whether we are in the inhale or exahle state
     */
    var mState = 1

    private val INHALE_STATE = 1
    private val EXHALE_STATE = 2
}

package peakvalleytech.neverdown.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import peakvalleytech.neverdown.data.repo.GratitudeRepository

/**
 * A ViewModel used to provide pondering feature for an activity
 * It can keep track of how long user should wait before allow to continue to next item.
 * the the view
 */
@ExperimentalCoroutinesApi
abstract class PonderViewModel /*@ViewModelInject constructor(private val gratitudeRepository : GratitudeRepository)*/
    : ViewModel() {
    // TODO: Implement the ViewModel

    /**
     * Determines if user can go to next item in activity
     * True if yes, otherwise false
     *
     * This is a feature of all activities to force user to ponder over items rather than
     * quickly passing over
     */
    val _mPonderDone : MutableLiveData<Boolean> = MutableLiveData()
    val mPonderDone = _mPonderDone

    protected fun testPonderState(test : () -> Boolean) {
        if(test()) {
            _mPonderDone.value = true
        }
    }

    fun resetPonderState() {
        _mPonderDone.value = false
    }
}
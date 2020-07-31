package peakvalleytech.neverdown.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import peakvalleytech.neverdown.data.repo.GratitudeRepository

@ExperimentalCoroutinesApi
class BaseActivityViewModel /*@ViewModelInject constructor(private val gratitudeRepository : GratitudeRepository)*/
    : ViewModel() {
    // TODO: Implement the ViewModel

    /**
     * Determines if user can go to next item in activity
     * True if yes, otherwise false
     *
     * This is a feature of all activities to force user to ponder over items rather than
     * quickly passing over
     */
    val _mCanGetNext : MutableLiveData<Boolean> = MutableLiveData()
    val mCanGetNext = _mCanGetNext


    protected fun testNextCondition(test : () -> Boolean) {
        if(test()) {
            _mCanGetNext.value = true
        }
    }
}
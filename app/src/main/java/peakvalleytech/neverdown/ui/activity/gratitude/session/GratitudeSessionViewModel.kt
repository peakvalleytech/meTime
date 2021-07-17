package peakvalleytech.neverdown.ui.activity.gratitude.session

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import java.util.*
import javax.inject.Inject
import kotlin.random.Random
@HiltViewModel
class GratitudeSessionViewModel @Inject constructor(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {
    /**
     * The gratitude items that the app selects from
     */
    private var _mItems = MutableLiveData<List<GratitudeItem>>()
    val mItems: LiveData<List<GratitudeItem>> = _mItems
//    var items: List<GratitudeItem> by mutableStateOf(gratitudeRepository.getItems())
//        private set
//
    /**
     * Indciates whether the user is grateful for the currently shown item
     */
//    private val _mIsGrateful = MutableLiveData<Boolean>()
//    val mIsGrateful = _mIsGrateful

    /**
     * The currently displayed item
     */
    private val _mItem = MutableLiveData<GratitudeItem>()
    val mItem : LiveData<GratitudeItem> = _mItem

    /**
     *  The current value of timer in milliseconds
     */
//    private val _mTimer = MutableLiveData<Float>()
//    val mTimer: LiveData<Float> = _mTimer
//
//    private var _mTimerLength: Int = 0
//    private var _mStartMillis: Long = 0


    /**
     * Keep track of which items have already been shown to avoid showing the same item
     * twice per session
     */
    private var seenItems : MutableList<GratitudeItem> = mutableListOf()

    fun loadInitialItem() {
        viewModelScope.launch {
            _mItems.postValue(gratitudeRepository.getItems())
//            _mItem.value = mItems.get(0)
//            println("items : " + mItems)
        }
    }

    /**
     * Select a new item from the items list and set it to current item
     */
    fun updateCurrentItem() {
//        val items = items
//        var index = rand(0, items?.size as Int)
//        _mItem.value = items.get(index)
    }

    fun startTimer(millis: Int) {
//        _mStartMillis = Calendar.getInstance().timeInMillis
//        _mTimerLength = millis
//        _mTimer.value = 0F

    }

    fun updateTimer() {
        val currentMillis = Calendar.getInstance().timeInMillis;
//        _mTimer.value = (currentMillis - _mStartMillis) / _mTimerLength as Float

    }
    fun isGrateful(boolean: Boolean) {
//        _mIsGrateful.value = boolean
    }

    private val random = Random

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun loadItems() {
//        TODO("Not yet implemented")'


    }
}

//@Suppress("UNCHECKED_CAST")
//class GratitudeViewModelFactory (
//    private val gratitudeRepository: GratitudeRepository
//): ViewModelProvider.NewInstanceFactory() {
//    override fun <T : ViewModel> create(modelClass: Class<T>) =
//        (GratitudeSessionViewModel(gratitudeRepository) as T)
//}

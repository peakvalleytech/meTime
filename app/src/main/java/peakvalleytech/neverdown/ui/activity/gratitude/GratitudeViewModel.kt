package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import peakvalleytech.neverdown.data.repo.DefaultGratitudeRepository
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import kotlin.random.Random

class GratitudeViewModel(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {
    /**
     * The gratitude items that the app selects from
     */
    private lateinit var _mItems: List<GratitudeItem>
    lateinit var mItems: List<GratitudeItem>

    /**
     * Indciates whether the user is grateful for the currently shown item
     */
    private val _mIsGrateful = MutableLiveData<Boolean>()
    val mIsGrateful = _mIsGrateful

    /**
     * The currently displayed item
     */
    private val _mItem = MutableLiveData<GratitudeItem>()
    val mItem : LiveData<GratitudeItem> = _mItem

    /**
     * Keep track of which items have already been shown to avoid showing the same item
     * twice per session
     */
    private var seenItems : MutableList<GratitudeItem> = mutableListOf()

    fun loadInitialItem() {
        viewModelScope.launch {
            _mItems = gratitudeRepository.getItems()
            mItems = _mItems
            _mItem.value = mItems.get(0)
            println("items : " + mItems)
        }
    }

    val isLoading = (gratitudeRepository as DefaultGratitudeRepository).mIsLoading
    /**
     * Select a new item from the items list and set it to current item
     */
    fun updateCurrentItem() {
        val items = mItems
        var index = rand(0, items?.size)
        _mItem.value = mItems.get(index)
    }
    fun isGrateful(boolean: Boolean) {
        _mIsGrateful.value = boolean
    }

    private val random = Random

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }
}

@Suppress("UNCHECKED_CAST")
class GratitudeViewModelFactory (
    private val gratitudeRepository: GratitudeRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (GratitudeViewModel(gratitudeRepository) as T)
}

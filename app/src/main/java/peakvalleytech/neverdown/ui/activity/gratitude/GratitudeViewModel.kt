package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import kotlin.random.Random

class GratitudeViewModel(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {
    /**
     * The gratitude items that the app selects from
     */
    private val _mItems: LiveData<List<GratitudeItem>> = gratitudeRepository.observeItems()
    val mItems: LiveData<List<GratitudeItem>> = _mItems

    /**
     * Indciates whether the user is grateful for the currently shown item
     */
    private val _mIsGrateful = MutableLiveData<Boolean>()
    val mIsGrateful = _mIsGrateful

    /**
     * The currently displayed item
     */
    private val _mItem = MutableLiveData<GratitudeItem>()
    val mItem = _mItem

    /**
     * Keep track of which items have already been shown to avoid showing the same item
     * twice per session
     */
    private var seenItems : MutableList<GratitudeItem> = mutableListOf()

    /**
     * Select a new item from the items list and set it to current item
     */
    fun updateCurrentItem() {
//        val items = mItems.value
//        var index = items?.size ?: 0
//        index = Random()
//        val item : GratitudeItem? = mItems.value.get()
    }
    fun isGrateful(boolean: Boolean) {
        _mIsGrateful.value = boolean
    }
}

@Suppress("UNCHECKED_CAST")
class GratitudeViewModelFactory (
    private val gratitudeRepository: GratitudeRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (GratitudeViewModel(gratitudeRepository) as T)
}
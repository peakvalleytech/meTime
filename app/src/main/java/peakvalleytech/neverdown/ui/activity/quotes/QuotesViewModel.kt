package peakvalleytech.neverdown.ui.activity.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote
import kotlin.random.Random

class QuotesViewModel(
    private val quotesRepository : QuotesRepository
) : ViewModel() {
    /**
     * The gratitude items that the app selects from
     */
    private var _mItems = quotesRepository.getItems()
    val mItems: LiveData<List<Quote>> = _mItems

    /**
     * Indciates whether the user is grateful for the currently shown item
     */
    private val _mIsGrateful = MutableLiveData<Boolean>()
    val mIsGrateful = _mIsGrateful

    /**
     * The currently displayed item
     */
    private val _mQuote = MutableLiveData<Quote>()
    val mItem : LiveData<Quote> = _mQuote

    /**
     * Keep track of which items have already been shown to avoid showing the same item
     * twice per session
     */
    private var seenItems : MutableList<GratitudeItem> = mutableListOf()

    fun loadInitialItem() {
//        viewModelScope.launch {
//            _mItems = quotesRepository.getItems()
//            mItems = _mItems
//            _mItem.value = mItems.get(0)
//            println("items : " + mItems)
//        }
    }

    /**
     * Select a new item from the items list and set it to current item
     */
    fun updateCurrentItem() {
        val items = mItems.value
        var index = rand(0, items?.size as Int)
        _mQuote.value = items.get(index)
    }
    fun isGrateful(boolean: Boolean) {
        _mIsGrateful.value = boolean
    }

    private val random = Random

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun loadItems() {
//        TODO("Not yet implemented")'


    }
}

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory (
    private val quotesRepository: QuotesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (QuotesViewModel(quotesRepository) as T)
}

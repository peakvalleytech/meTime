package peakvalleytech.neverdown.ui.activity.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote
import peakvalleytech.neverdown.ui.base.PonderViewModel
import kotlin.random.Random

class QuotesViewModel(
    private val quotesRepository : QuotesRepository
) : PonderViewModel() {
    /**
     * The gratitude items that the app selects from
     */
    private var _mQuotes = quotesRepository.getQuotes()
    val mQuotes: LiveData<List<Quote>> = _mQuotes

    /**
     * The currently displayed quote
     */
    private val _mQuote = MutableLiveData<Quote>()
    val mQuote : LiveData<Quote> = _mQuote

    /**
     * Keep track of which items have already been shown to avoid showing the same item
     * twice per session
     */
    private var seenQuotes : MutableList<Quote> = mutableListOf()

    /**
     * Select a new item from the items list and set it to current item
     */
    fun updateCurrentQuote() {
        val quotes = mQuotes.value
        var index = rand(0, quotes?.size as Int)
        _mQuote.value = quotes.get(index)
    }

    private val random = Random

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from
    }

    fun startPondering() {
        resetPonderState()
        testPonderState {true}
    }
}

@Suppress("UNCHECKED_CAST")
class QuotesViewModelFactory (
    private val quotesRepository: QuotesRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (QuotesViewModel(quotesRepository) as T)
}

package peakvalleytech.neverdown.quotes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import peakvalleytech.neverdown.data.source.FakeGratitudeRepository
import peakvalleytech.neverdown.data.source.FakeQuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModel
import peakvalleytech.neverdown.ui.activity.words.QuotesViewModel

class QuotesViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var quotesViewModel: QuotesViewModel
    private lateinit var quotesRepository: FakeQuotesRepository
    @Before
    fun setUp() {
        quotesRepository = FakeQuotesRepository()
        val quote1 = Quote(1, "Quote 1", "Author 1")
        val quote2 = Quote(2, "Quote 2", "Author 2")
        val quote3 = Quote(3, "Quote 3", "Author 3")

        quotesRepository.addQuotes(quote1, quote2, quote3)
        quotesViewModel = QuotesViewModel(quotesRepository)
    }

    /**
     * Call observeItems
     * Should return list of items from repository
     */
    @Test
    fun observeItems_shouldGetAllItems() {
        val observer = Observer<List<Quote>> {}
        try {
            quotesViewModel.mQuotes.observeForever(observer)
            val quotes = quotesViewModel.mQuotes.value
            assertThat(quotes?.size , `is`(3))
        } finally {
            quotesViewModel.mQuotes.removeObserver(observer)
        }
    }

    @Test
    fun observeItems_shouldNotGetLessThanAll() {
        val observer = Observer<List<Quote>> {}
        try {
            quotesViewModel.mQuotes.observeForever(observer)
            val quotes = quotesViewModel.mQuotes.value
            assertThat(quotes?.size , not(`is`(1)))
        } finally {
            quotesViewModel.mQuotes.removeObserver(observer)
        }
    }
}
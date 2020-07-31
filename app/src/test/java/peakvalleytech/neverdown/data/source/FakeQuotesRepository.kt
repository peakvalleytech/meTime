package peakvalleytech.neverdown.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote

class FakeQuotesRepository : QuotesRepository {
    private var itemsServiceData: MutableList<Quote> = mutableListOf()
    override fun getQuotes(): LiveData<List<Quote>> {
        TODO("Not yet implemented")
    }

    fun addQuotes(vararg quotes: Quote) {
        for(quote in quotes) {
            itemsServiceData.add(quote)
        }
    }

}
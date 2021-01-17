package peakvalleytech.neverdown.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.quotes.Quote

class FakeQuotesRepository : QuotesRepository {
    private var itemsServiceData: MutableList<Quote> = mutableListOf()
    override fun getQuotes(): LiveData<List<Quote>> {
        return MutableLiveData<List<Quote>>(itemsServiceData.toList())
    }

    fun addQuotes(vararg quotes: Quote) {
        for(quote in quotes) {
            itemsServiceData.add(quote)
        }
    }

}
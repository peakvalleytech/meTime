package peakvalleytech.neverdown.ui.activity.quotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote

class FakeAndroidQuotesRepository : QuotesRepository {
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
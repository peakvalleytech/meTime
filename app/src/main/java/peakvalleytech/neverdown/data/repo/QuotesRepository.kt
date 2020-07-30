package peakvalleytech.neverdown.data.repo

import androidx.lifecycle.LiveData
import peakvalleytech.neverdown.model.quotes.Quote

interface QuotesRepository {
    /**
     * Get all items in repository
     * @return the list of all items
     */
    fun getQuotes(): LiveData<List<Quote>>
}

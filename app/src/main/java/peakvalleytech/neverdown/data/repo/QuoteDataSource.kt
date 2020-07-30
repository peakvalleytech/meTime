package peakvalleytech.neverdown.data.repo

import androidx.lifecycle.LiveData
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote

interface QuoteDataSource {
    suspend fun getAllQuotes(): List<Quote>
    suspend fun  insertQuotes(quotes : List<Quote>)
}
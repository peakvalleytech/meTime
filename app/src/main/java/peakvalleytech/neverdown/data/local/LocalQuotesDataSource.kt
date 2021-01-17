package peakvalleytech.neverdown.data.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import peakvalleytech.neverdown.data.repo.QuoteDataSource
import peakvalleytech.neverdown.model.quotes.Quote

class LocalQuotesDataSource internal constructor(
    private val quoteDao: QuoteDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : QuoteDataSource{
    override suspend fun getAllQuotes(): List<Quote> {
        TODO("Not yet implemented")
    }

    override suspend fun insertQuotes(quotes: List<Quote>) {
        TODO("Not yet implemented")
    }
}
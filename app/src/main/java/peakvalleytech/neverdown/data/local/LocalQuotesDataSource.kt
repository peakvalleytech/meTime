package peakvalleytech.neverdown.data.local

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import peakvalleytech.neverdown.data.repo.GratitudeDataSource
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class LocalQuotesDataSource internal constructor(
    private val gratitudeItemDao: GratitudeDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GratitudeDataSource{
    override suspend fun getAllItems(): List<GratitudeItem> = withContext(ioDispatcher){
        gratitudeItemDao.getAllItems()
    }

    override suspend fun insertItems(items: List<GratitudeItem>)  = withContext(ioDispatcher){
        gratitudeItemDao.insertItems(items)
    }
}
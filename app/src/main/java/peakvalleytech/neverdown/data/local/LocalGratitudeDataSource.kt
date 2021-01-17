package peakvalleytech.neverdown.data.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeDataSource
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class LocalGratitudeDataSource internal constructor(
    private val gratitudeItemDao: GratitudeDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GratitudeDataSource {
    override suspend fun getAllItems(): List<GratitudeItem> = withContext(ioDispatcher){
        gratitudeItemDao.getAllItems()
    }

    override suspend fun insertItems(items: List<GratitudeItem>)  = withContext(ioDispatcher){
        gratitudeItemDao.insertItems(items)
    }
}
package peakvalleytech.neverdown.data.local

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import peakvalleytech.neverdown.data.repo.GratitudeDataSource
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class LocalGratitudeDataSource internal constructor(
    private val gratitudeItemDao: GratitudeItemDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : GratitudeDataSource{
    override suspend fun getAllItems(): List<GratitudeItem> = withContext(ioDispatcher){
//        TODO("Not yet implemented")
        gratitudeItemDao.getAllItems()
    }
}
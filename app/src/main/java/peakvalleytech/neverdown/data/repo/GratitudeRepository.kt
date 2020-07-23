package peakvalleytech.neverdown.data.repo

import androidx.lifecycle.LiveData
import peakvalleytech.neverdown.data.local.GratitudeItemDao
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import javax.inject.Singleton

/**
 * Repository for fetching from local file and storing it in database
 */
@Singleton
interface GratitudeRepository  {
    fun observeItems(): LiveData<List<GratitudeItem>>
}
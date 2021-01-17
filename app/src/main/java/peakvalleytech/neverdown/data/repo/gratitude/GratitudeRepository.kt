package peakvalleytech.neverdown.data.repo.gratitude

import androidx.lifecycle.LiveData
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
//import javax.inject.Singleton

/**
 * Repository for fetching items from database
 */
//@Singleton
interface GratitudeRepository {
    /**
     * Get all items in repository
     * @return the list of all items
     */
    fun getItems(): LiveData<List<GratitudeItem>>
}
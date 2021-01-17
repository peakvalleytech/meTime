package peakvalleytech.neverdown.data.repo.gratitude

import androidx.lifecycle.LiveData
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

interface GratitudeDataSource {
    suspend fun getAllItems(): List<GratitudeItem>
    suspend fun  insertItems(items : List<GratitudeItem>)
}
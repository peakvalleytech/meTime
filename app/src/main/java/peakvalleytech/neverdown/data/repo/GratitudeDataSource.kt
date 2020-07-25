package peakvalleytech.neverdown.data.repo

import peakvalleytech.neverdown.model.gratitude.GratitudeItem

interface GratitudeDataSource {
    suspend fun getAllItems(): List<GratitudeItem>
}
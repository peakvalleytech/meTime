package peakvalleytech.neverdown.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

@Database(entities = [GratitudeItem::class], version = 2, exportSchema = false)
abstract class Database : RoomDatabase()
{
    abstract fun gratitudeItemDao(): GratitudeItemDao
}


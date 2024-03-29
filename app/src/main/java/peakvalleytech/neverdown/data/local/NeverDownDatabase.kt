package peakvalleytech.neverdown.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote

@Database(entities = [GratitudeItem::class, Quote::class], version = 5, exportSchema = true)
abstract class NeverDownDatabase : RoomDatabase()
{
    abstract fun gratitudeItemDao(): GratitudeDao
    abstract fun quoteDao(): QuoteDao

}


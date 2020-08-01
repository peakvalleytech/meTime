package peakvalleytech.neverdown.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote

@Dao
interface QuoteDao {
    /**
     * Select all items from table
     * @return all quotes
     */
    @Query("select * from quotes")
    suspend  fun getAllQuotes() : List<Quote>

    /**
     * Insert items in the database
     * @param items the items to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotes(quotes : List<Quote>)

    /**
     * Delete all items in the database
     * @return the number of items deleted
     */
    @Query("delete from quotes")
    suspend fun deleteAllQuotes()
}

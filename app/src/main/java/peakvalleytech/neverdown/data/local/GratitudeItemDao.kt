package peakvalleytech.neverdown.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

@Dao
interface GratitudeItemDao {
    /**
     * Select all items from table
     * @return all items
     */
    @Query("select * from gratitude")
    suspend fun getAllItems() : List<GratitudeItem>

    /**
     * Insert items in the database
     * @param items the items to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items : List<GratitudeItem>)

    /**
     * Delete all items in the database
     * @return the number of items deleted
     */
    @Query("delete from gratitude")
    suspend fun deleteAllItems()
}

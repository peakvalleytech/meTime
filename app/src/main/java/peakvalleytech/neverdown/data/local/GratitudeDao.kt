package peakvalleytech.neverdown.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

@Dao
interface GratitudeDao {
    /**
     * Select all items from table
     * @return all items
     */
    @Query("select * from gratitude")
    suspend  fun getAllItems() : List<GratitudeItem>

    /**
     * Insert items in the database
     * @param items the items to be inserted
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items : List<GratitudeItem>)

    @Insert
    suspend fun insertItem(item: GratitudeItem)

    @Delete
    suspend fun deleteItem(item: GratitudeItem)

    /**
     * Delete all items in the database
     * @return the number of items deleted
     */
    @Query("delete from gratitude")
    suspend fun deleteAllItems()
}

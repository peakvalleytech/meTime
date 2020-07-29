package peakvalleytech.neverdown.model.quotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "quotes")
data class Quote(
    @PrimaryKey
    @ColumnInfo
    val id : Int,
    @ColumnInfo
    val quote : String,
    @ColumnInfo
    val author: String
) {
}
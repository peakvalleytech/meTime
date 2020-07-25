package peakvalleytech.neverdown.model.gratitude

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gratitude")
data class GratitudeItem(
    @PrimaryKey
    @ColumnInfo
    var id: Int? = 0,
    @ColumnInfo(name ="name")
    var name: String? = null
)
package peakvalleytech.neverdown.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class FakeGratitudeRepository :
    GratitudeRepository {
    private var itemsServiceData: MutableList<GratitudeItem> = mutableListOf()
    override suspend fun getItems(): LiveData<List<GratitudeItem>> {
        return MutableLiveData(itemsServiceData)
    }

    override suspend fun addItem(item: GratitudeItem) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: GratitudeItem) {
        TODO("Not yet implemented")
    }

    fun addItems(vararg itemNames: String) {
//        val itemNames = listOf("Place to sleep", "Food", "Water", "Clothes", "Computer")
        var id = 1
        for(itemName in itemNames) {
            val item = GratitudeItem(id++, itemName)
            itemsServiceData.add(item)
        }
    }

}
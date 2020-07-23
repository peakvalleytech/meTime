package peakvalleytech.neverdown.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class FakeGratitudeRepository : GratitudeRepository {
    private var itemsServiceData: MutableList<GratitudeItem> = mutableListOf()
    override fun observeItems(): LiveData<List<GratitudeItem>> {
        return MutableLiveData<List<GratitudeItem>>().also {
            it.value = itemsServiceData
        }
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
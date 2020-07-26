package peakvalleytech.neverdown.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class DefaultGratitudeRepository(
    private val gratitudeDataSource: GratitudeDataSource
) : GratitudeRepository {
    override  fun getItems(): LiveData<List<GratitudeItem>> {
        val data = MutableLiveData<List<GratitudeItem>>()
        var items: List<GratitudeItem>? = null
        runBlocking {
           items = gratitudeDataSource.getAllItems()
            if (items?.size == 0) {
                runBlocking {
                    loadData()
                    println("after data")
                    items = gratitudeDataSource.getAllItems();
                }

                println("after items: ${items}")
                println("after mld")
            }
        }
        data.value = items
        return data
    }

    private suspend fun loadData() {
        val itemNames = listOf("Place to sleep", "Food", "A job", "Water", "Clothes", "Computer")
        val items: MutableList<GratitudeItem> = mutableListOf()
        var id = 1
        for (itemName in itemNames) {
            val item = GratitudeItem(id++, itemName)
            items.add(item)
        }
            gratitudeDataSource.insertItems(items)
    }
}

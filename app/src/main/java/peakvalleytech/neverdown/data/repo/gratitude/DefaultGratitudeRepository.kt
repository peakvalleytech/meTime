package peakvalleytech.neverdown.data.repo.gratitude

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import java.io.IOException
import java.util.*

class DefaultGratitudeRepository(
    private val gratitudeDataSource: GratitudeDataSource,
    private val context: Context
) : GratitudeRepository {
    override  fun getItems(): LiveData<List<GratitudeItem>> {
        val data = MutableLiveData<List<GratitudeItem>>()
        var items: List<GratitudeItem>? = null
        runBlocking {
           items = gratitudeDataSource.getAllItems()
            if (items?.size == 0) {
                runBlocking {
                    loadData()
                }
                joinAll()
                    items = gratitudeDataSource.getAllItems();

                     println("items: ${items}")
                println("after mld")
            }
            print("end of rb")
        print("Setting mld")
        data.value = items
        }
        return data
    }

    override suspend fun addItem(item: GratitudeItem) {
        gratitudeDataSource.addItem(item)
    }

    override suspend fun deleteItem(item: GratitudeItem) {
        gratitudeDataSource.deleteItem(item)
    }

    private suspend fun loadData() {
        try {
            println("Start loadData")
            val items: MutableList<GratitudeItem> = mutableListOf()
            var id = 1
            val inputStream = context.resources.assets.open("gratitudeList.txt")
            val scanner : Scanner = Scanner(inputStream)
            while(scanner.hasNextLine()) {
                val item = scanner.nextLine()
                items.add(GratitudeItem(id++, item))
            }
            gratitudeDataSource.insertItems(items)
            println("End loadData")
        } catch(e: IOException) {
            e.printStackTrace()
        }

    }
}

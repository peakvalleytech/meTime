package peakvalleytech.neverdown.data.repo

import android.content.Context
import android.content.res.AssetManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.model.quotes.Quote
import java.io.IOException
import java.io.InputStream
import java.util.*

class DefaultQuotesRepository(
    private val quotesDataSource: QuoteDataSource,
    private val context: Context
) : QuotesRepository {
    override  fun getQuotes(): LiveData<List<Quote>> {
        val data = MutableLiveData<List<Quote>>()
        var items: List<GratitudeItem>? = null
        runBlocking {
//           items = gratitudeDataSource.getAllItems()
//            if (items?.size == 0) {
//                runBlocking {
//                    loadData()
//                }
//                joinAll()
//                    items = gratitudeDataSource.getAllItems();
//
//                     println("items: ${items}")
//                println("after mld")
//            }
//            print("end of rb")
//        print("Setting mld")
//        data.value = items
        }
        return data
    }

    private suspend fun loadData() {
        try {
            println("Start loadData")
//            val items: MutableList<GratitudeItem> = mutableListOf()
//            var id = 1
//            val inputStream = context.resources.assets.open("gratitudeList.txt")
//            val scanner : Scanner = Scanner(inputStream)
//            while(scanner.hasNextLine()) {
//                val item = scanner.nextLine()
//                items.add(GratitudeItem(id++, item))
//            }
//            gratitudeDataSource.insertItems(items)
            println("End loadData")
        } catch(e: IOException) {
            e.printStackTrace()
        }

    }
}

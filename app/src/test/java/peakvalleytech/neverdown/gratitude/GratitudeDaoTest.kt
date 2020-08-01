package peakvalleytech.neverdown.gratitude

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import peakvalleytech.neverdown.data.local.NeverDownDatabase
import peakvalleytech.neverdown.model.gratitude.GratitudeItem


@RunWith(AndroidJUnit4::class)
class GratitudeDaoTest {
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var mDatabase: NeverDownDatabase

    @Before
    fun init() {
        mDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NeverDownDatabase::class.java
        ).build()
    }

    @Test
    fun insertAndSelectItems() {
        val gratitudeDao = mDatabase.gratitudeItemDao()
        val itemNames = listOf("Place to sleep", "Food", "A job", "Water", "Clothes", "Computer")
        val items: MutableList<GratitudeItem> = mutableListOf()
        var id = 1
        for (itemName in itemNames) {
            val item = GratitudeItem(id++, itemName)
            items.add(item)
        }
        val observer = Observer<List<GratitudeItem>> {}

        try {
//            gratitudeDao.getAllItems()
        } finally {

        }
    }
}
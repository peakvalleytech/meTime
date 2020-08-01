package peakvalleytech.neverdown.quotes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import peakvalleytech.neverdown.data.local.NeverDownDatabase
import peakvalleytech.neverdown.model.quotes.Quote


@RunWith(AndroidJUnit4::class)
class QuotesDaoTest {
    @get:Rule
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
    fun insertAndSelectQuotes() {
        val quoteDao = mDatabase.quoteDao()
        val quote1 = Quote(1, "Quote 1", "Author 1")
        val quote2 = Quote(2, "Quote 2", "Author 2")
        val quote3 = Quote(3, "Quote 3", "Author 3")

//        GlobalScope.launch {
//            quoteDao.insertQuotes(listOf(quote1, quote2, quote3))
//        }
        GlobalScope.launch {
            quoteDao.insertQuotes(listOf(quote1, quote2, quote3))
            val quotes = quoteDao.getAllQuotes()

            assertThat(quotes.size.toString(), equals(3))
            assertThat(quotes.get(0).quote, equals(quote1.quote))
            assertThat(quotes.get(1).quote, equals(quote2.quote))
            assertThat(quotes.get(2).quote, equals(quote3.quote))
        }
    }
}
package peakvalleytech.neverdown.ui.activity.quotes

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.ServiceLocator
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.quotes.Quote
import peakvalleytech.neverdown.ui.activity.words.WordsFragment

@MediumTest
@RunWith(AndroidJUnit4::class)
class WordsFragmentTest {
    private lateinit var repository: QuotesRepository
    @Before
    fun initRepository() {
        repository = FakeAndroidQuotesRepository()
            val quote1 = Quote(1, "Quote 1", "Author 1")
            val quote2 = Quote(2, "Quote 2", "Author 2")
            val quote3 = Quote(3, "Quote 3", "Author 3")
        (repository as FakeAndroidQuotesRepository).addQuotes(quote1, quote2, quote3)
        ServiceLocator.quotesRepository = repository
    }

//    @After
//    fun cleanupDb() = runBlockingTest {
//        ServiceLocator.resetRepository()
//    }

    @Test
    fun testUI() = runBlockingTest {
        launchFragmentInContainer<WordsFragment>(Bundle(), R.style.AppTheme)
        delay(3000)
        var uniqueItemNames : MutableSet<String> = mutableSetOf()
        Thread.sleep(1000)
        for(count in 1..5) {
            onView(withId(R.id.nextButton)).perform(click())
            onView(withId(R.id.quoteText)).check(ViewAssertion { view, noViewFoundException ->
                val quoteText = (view as TextView).text
                uniqueItemNames.add(quoteText as String)
            })
            Thread.sleep(1000)
        }

        assertTrue(uniqueItemNames.size > 1)
    }
}
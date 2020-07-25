package peakvalleytech.neverdown.ui.activity.gratitude

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
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import peakvalleytech.neverdown.R

@MediumTest
@RunWith(AndroidJUnit4::class)
class GratitudeFragmentTest {
    @Before
    fun initRepository() {
//        repository = FakeAdnroidTestRepository()
//        ServiceLocator.gratitudeRepository = repository
    }

//    @After
//    fun cleanupDb() = runBlockingTest {
//        ServiceLocator.resetRepository()
//    }

    @Test
    fun testUI() = runBlockingTest {
//        val bundle = GratitudeF
        launchFragmentInContainer<GratitudeFragment>(Bundle(), R.style.AppTheme)
//        delay(3000)
        var itemNames : List<String> = listOf<String>("Place to sleep", "Food", "Water", "Clothes", "Computer")
        var uniqueItemNames : MutableSet<String> = mutableSetOf()
        Thread.sleep(1000)
        for(count in 1..5) {
            onView(withId(R.id.gratefulButton)).perform(click())
            onView(withId(R.id.gratitudeItemText)).check(ViewAssertion { view, noViewFoundException ->
                val itemName = (view as TextView).text
                assertTrue(itemNames.contains(itemName as String))
                uniqueItemNames.add(itemName)
            })
            Thread.sleep(1000)
        }
        for(count in 1..5) {
            onView(withId(R.id.notGratefulButton)).perform(click())
            onView(withId(R.id.gratitudeItemText)).check(ViewAssertion { view, noViewFoundException ->
                val itemName = (view as TextView).text
                assertTrue(itemNames.contains(itemName as String))
                uniqueItemNames.add(itemName)
            })
            Thread.sleep(1000)
        }
        assertTrue(uniqueItemNames.size > 1)
    }
}
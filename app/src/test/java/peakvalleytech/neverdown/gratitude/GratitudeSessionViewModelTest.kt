package peakvalleytech.neverdown.gratitude

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import peakvalleytech.neverdown.data.source.FakeGratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionViewModel

class GratitudeSessionViewModelTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var gratitudeSessionViewModel: GratitudeSessionViewModel
    private lateinit var gratitudeRepository: FakeGratitudeRepository
    @Before
    fun setUp() {
        gratitudeRepository = FakeGratitudeRepository()
        gratitudeRepository.addItems("Place to sleep", "Food", "Water", "Clothes", "Computer")
        gratitudeSessionViewModel = GratitudeSessionViewModel(gratitudeRepository)
    }

    /**
     * Call observeItems
     * Should return list of items from repository
     */
    @Test
    fun observeItems_shouldGetAllItems() {
        val observer = Observer<List<GratitudeItem>> {}
        try {
            gratitudeSessionViewModel.mItems.observeForever(observer)
            val items = gratitudeSessionViewModel.mItems.value
            assertThat(items?.size , `is`(5))
        } finally {
            gratitudeSessionViewModel.mItems.removeObserver(observer)
        }
    }

    @Test
    fun observeItems_shouldNotGetLessThanAll() {
        val observer = Observer<List<GratitudeItem>> {}
        try {
            gratitudeSessionViewModel.mItems.observeForever(observer)
            val items = gratitudeSessionViewModel.mItems.value
            assertThat(items?.size , not(`is`(3)))
        } finally {
            gratitudeSessionViewModel.mItems.removeObserver(observer)
        }
    }

    /**
     * Call isGrateful with true
     * Should: set observable  to true
     */
    @Test
    fun setIsGrateful_toTrue() {

    }
    /**
     * Call isGrateful with false
     * Should: set observable  to false
     */

    @Test
    fun setIsGrateful_toFalse() {

    }

    /**
     * Calling updateCurrentItem should set item observable to new item
     */
    @Test
    fun updateCurrentItem_Should_setObservable() {

    }
}
package peakvalleytech.neverdown.ui.activity.gratitude.list

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import peakvalleytech.neverdown.Event
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionFragment
import kotlin.random.Random

class GratitudeListViewModel(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {

    private var _listLiveData: MutableLiveData<List<GratitudeItem>> = MutableLiveData()
    var listLiveData: LiveData<List<GratitudeItem>> = _listLiveData

    val mutableLiveData: MutableLiveData<Event<Class<out Fragment>>> = MutableLiveData()

    fun deleteItem(item: GratitudeItem) {

    }

    fun addItem(item: GratitudeItem) {

    }


}

@Suppress("UNCHECKED_CAST")
class GratitudeListViewModelFactory (
    private val gratitudeRepository: GratitudeRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (GratitudeListViewModel(gratitudeRepository) as T)
}

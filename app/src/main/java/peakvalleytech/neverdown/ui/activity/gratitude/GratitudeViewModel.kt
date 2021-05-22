package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import peakvalleytech.neverdown.Event
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository

class GratitudeViewModel(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {

    val mutableLiveData: MutableLiveData<Event<Class<out Fragment>>> = MutableLiveData()

}

@Suppress("UNCHECKED_CAST")
class GratitudeViewModelFactory (
    private val gratitudeRepository: GratitudeRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (GratitudeViewModel(gratitudeRepository) as T)
}

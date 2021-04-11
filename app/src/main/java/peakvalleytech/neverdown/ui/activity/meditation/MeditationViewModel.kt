package peakvalleytech.neverdown.ui.activity.meditation

import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MeditationViewModel : ViewModel() {

}

@Suppress("UNCHECKED_CAST")
class MediationViewModelFactory (
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (MeditationViewModel() as T)
}
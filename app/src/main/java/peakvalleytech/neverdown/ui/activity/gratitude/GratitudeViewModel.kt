package peakvalleytech.neverdown.ui.activity.gratitude

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionFragment
import kotlin.random.Random

class GratitudeViewModel(
    private val gratitudeRepository : GratitudeRepository
) : ViewModel() {

    val mutableLiveData: MutableLiveData<Class<out Fragment>> = MutableLiveData()
    fun luanchSessionFragment() {
        viewModelScope.launch {
            mutableLiveData.postValue(GratitudeSessionFragment::class.java as Class<out Fragment>)
        }
    }



}

@Suppress("UNCHECKED_CAST")
class GratitudeViewModelFactory (
    private val gratitudeRepository: GratitudeRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        (GratitudeViewModel(gratitudeRepository) as T)
}

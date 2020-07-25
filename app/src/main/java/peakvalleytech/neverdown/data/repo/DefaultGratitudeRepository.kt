package peakvalleytech.neverdown.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

class DefaultGratitudeRepository(
    private val gratitudeDataSource: GratitudeDataSource
) : GratitudeRepository {
    override suspend fun getItems(): List<GratitudeItem> {
        return gratitudeDataSource.getAllItems()
    }

    private val _mIsLoading : MutableLiveData<Boolean> = MutableLiveData(false)
    val mIsLoading = _mIsLoading
}

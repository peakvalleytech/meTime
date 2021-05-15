package peakvalleytech.neverdown.ui.activity.gratitude.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.meditation.session.text

@Composable
fun GratitudeListScreen(viewModel: GratitudeListViewModel?) {
    val list = viewModel?.listLiveData?.observeAsState()
     Column() {
         list?.value?.forEach() {
            Row {
                it.name?.let { it1 -> text(text = it1) }
            }
         }
    }


}
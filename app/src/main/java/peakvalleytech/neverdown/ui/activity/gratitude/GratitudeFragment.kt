package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.ui.activities.ActivitiesViewModel

class GratitudeFragment : Fragment() {


    private lateinit var viewModel: ActivitiesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_gratitude, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActivitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
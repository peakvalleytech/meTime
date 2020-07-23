package peakvalleytech.neverdown.ui.activities.activitylist

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.ui.activities.ActivitiesViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeFragment

class ActivitiesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            ActivitiesListFragment()
    }

    private lateinit var viewModel: ActivitiesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.activities_fragment, container, false).also {
            val gratitudeButton = it.findViewById<Button>(R.id.gratitudeButton)
            gratitudeButton.setOnClickListener { v ->
                val fgm =  it@parentFragmentManager
                val fragment = GratitudeFragment()
                val fragTrans = fgm.beginTransaction()
                fragTrans.addToBackStack(null)
                fragTrans.replace(R.id.container, fragment)
                fragTrans.commit()

            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ActivitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
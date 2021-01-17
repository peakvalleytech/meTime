package peakvalleytech.neverdown.ui.activitylist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.ui.ActivitiesViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeFragment
import peakvalleytech.neverdown.ui.activity.meditation.MeditationFragment
import peakvalleytech.neverdown.ui.activity.quotes.QuotesFragment

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
            val meditationButton = it.findViewById<Button>(R.id.meditationButton)
            val quotesButton = it.findViewById<Button>(R.id.quotesButton)
            gratitudeButton.setOnClickListener { v ->
                val fgm =  it@parentFragmentManager
                val fragment = GratitudeFragment()
                val fragTrans = fgm.beginTransaction()
                fragTrans.addToBackStack(null)
                fragTrans.replace(R.id.fragment_host, fragment)
                fragTrans.commit()
            }
            meditationButton.setOnClickListener { v ->
                val fgm = it@parentFragmentManager
                val fragment = MeditationFragment()
                val fragTrans = fgm.beginTransaction()
                fragTrans.addToBackStack(null)
                fragTrans.replace(R.id.container, fragment)
                fragTrans.commit()
            }
            quotesButton.setOnClickListener { v ->
                val fgm = it@parentFragmentManager
                val fragment = QuotesFragment()
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
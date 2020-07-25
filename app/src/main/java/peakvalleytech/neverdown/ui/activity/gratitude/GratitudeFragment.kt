package peakvalleytech.neverdown.ui.activity.gratitude

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders.*
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.data.repo.DefaultGratitudeRepository
import peakvalleytech.neverdown.databinding.FragmentGratitudeBinding
import peakvalleytech.neverdown.ui.activities.ActivitiesViewModel

class GratitudeFragment : Fragment() {


    private val viewModel by viewModels<GratitudeViewModel> {
        GratitudeViewModelFactory((requireContext().applicationContext as NeverDownApplication).gratitudeRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = inflate<FragmentGratitudeBinding>(inflater, R.layout.fragment_gratitude, container, false)
        binding.gratitudeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.isLoading.observe(viewLifecycleOwner, Observer{ if(!it) viewModel.loadInitialItem()})
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(ActivitiesViewModel::class.java)
        // TODO: Use the ViewModel

    }

}
package peakvalleytech.neverdown.ui.activity.meditation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.FragmentMeditationBinding


class MeditationFragment: Fragment() {
    private val viewModel: MeditationViewModel by viewModels<MeditationViewModel> {
        MediationViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
        val binding = inflate<FragmentMeditationBinding>(
            inflater,
            R.layout.fragment_meditation,
            container,
            false
        )
//        binding.meditationViewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.startCounter()
//        viewModel.mBreathCounter.observe(viewLifecycleOwner, Observer {
//            viewModel.incrementCounter()
//        })
//
//        viewModel.mBreathState.observe(viewLifecycleOwner, Observer {
//            if(it == viewModel.INHALE_STATE) {
//                binding.showInhaleText = View.VISIBLE
//                binding.showExhaleText = View.INVISIBLE
//            } else if(it == viewModel.EXHALE_STATE) {
//                binding.showInhaleText = View.INVISIBLE
//                binding.showExhaleText = View.VISIBLE
//            }
//        })
        return binding.root
    }
}
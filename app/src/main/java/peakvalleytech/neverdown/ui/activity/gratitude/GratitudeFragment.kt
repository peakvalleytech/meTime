package peakvalleytech.neverdown.ui.activity.gratitude

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.FragmentGratitudeBinding

class GratitudeFragment : Fragment() {
    private val viewModel by viewModels<GratitudeViewModel> {
        GratitudeViewModelFactory((requireContext().applicationContext as NeverDownApplication).gratitudeRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflate<FragmentGratitudeBinding>(
            inflater,
            R.layout.fragment_gratitude,
            container,
            false
        )
        binding.gratitudeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.mItems.observe(viewLifecycleOwner, Observer {
            viewModel.updateCurrentItem()
        })

        return binding.root
    }
}
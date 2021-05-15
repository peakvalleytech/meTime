package peakvalleytech.neverdown.ui.activity.pictures

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
import peakvalleytech.neverdown.databinding.FragmentPicturesBinding

class PicturesFragment : Fragment() {
    private val viewModel = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflate<FragmentPicturesBinding>(
            inflater,
            R.layout.fragment_pictures,
            container,
            false
        )
        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.mItems.observe(viewLifecycleOwner, Observer {
//            viewModel.updateCurrentItem()
//        })

        return binding.root
    }
}
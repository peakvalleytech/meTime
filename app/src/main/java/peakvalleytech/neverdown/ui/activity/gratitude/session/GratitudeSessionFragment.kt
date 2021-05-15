package peakvalleytech.neverdown.ui.activity.gratitude.session

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
import peakvalleytech.neverdown.databinding.FragmentGratitudeSessionBinding
import peakvalleytech.neverdown.ui.activity.SessionFragment
import javax.inject.Inject

class GratitudeSessionFragment : Fragment() {

    @Inject
    lateinit var  viewModel: GratitudeSessionViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflate<FragmentGratitudeSessionBinding>(
            inflater,
            R.layout.fragment_gratitude_session,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
//        viewModel.mItems.observe(viewLifecycleOwner, Observer {
//            viewModel.updateCurrentItem()
//        })

        val lengthIntMillis = activity?.intent?.getIntExtra("timerLengthMillis", 60000)
        if (lengthIntMillis != null) {
            viewModel.startTimer(lengthIntMillis)
        }

//        viewModel.mTimer.observe(viewLifecycleOwner, Observer {
//            viewModel.updateTimer()
//        })

        return binding.root
    }
}
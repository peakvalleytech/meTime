package peakvalleytech.neverdown.ui.activity.words

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.FragmentGratitudeBinding
import peakvalleytech.neverdown.databinding.FragmentQuotesBinding

class WordsFragment : Fragment() {
    private val viewModel by viewModels<QuotesViewModel> {
        QuotesViewModelFactory((requireContext().applicationContext as NeverDownApplication).quotesRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflate<FragmentQuotesBinding>(
            inflater,
            R.layout.fragment_quotes,
            container,
            false
        )
        binding.quotesViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel.mQuotes.observe(viewLifecycleOwner, Observer {
            viewModel.updateCurrentQuote()
            viewModel.startPondering()
        })
//        viewModel.mPonderDone.observe(viewLifecycleOwner, Observer<Boolean> {
//            if(it) {
//                binding.nextButton.isEnabled = true
//            } else {
//                binding.nextButton.isEnabled = false
//            }
//        })

        return binding.root
    }
}
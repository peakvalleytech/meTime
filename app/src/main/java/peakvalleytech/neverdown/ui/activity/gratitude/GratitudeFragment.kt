package peakvalleytech.neverdown.ui.activity.gratitude

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.FragmentGratitudeBinding

class GratitudeFragment : Fragment() {
    private val viewModel = null

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
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//
//
//        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
//            val fragment: Class<out Fragment>? = it.getContentIfNotHandled()
//            if(fragment != null) {
//                var transaction = parentFragmentManager.beginTransaction()
////            parentFragmentManager.primaryNavigationFragment
//                transaction.setPrimaryNavigationFragment(this)
//                transaction.addToBackStack(null)
//                transaction.replace(R.id.fragment_host, fragment.newInstance())
//                transaction.commit()
////
////                transaction = parentFragmentManager.beginTransaction()
//////            parentFragmentManager.primaryNavigationFragment
//////                transaction.setPrimaryNavigationFragment(this)
//////                transaction.addToBackStack(null)
////                transaction.replace(R.id.fragment_session_timer, SessionFragment(), "timer")
////                transaction.commit()
//            }
//
//        })
        binding.composeView.setContent {
            // You're in Compose world!
            MaterialTheme {
//                GratitudeScreen(navController)
            }
        }

        return binding.root


    }


}
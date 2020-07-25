package peakvalleytech.neverdown.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import peakvalleytech.neverdown.R

class IntroFragment : Fragment() {
    companion object {
        fun newInstance() =
            IntroFragment()
    }

    private lateinit var viewModel: IntroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.intro_fragment, container, false)
    }
}
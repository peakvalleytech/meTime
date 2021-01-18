package peakvalleytech.neverdown.ui.activity.gratitude.list

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.FragmentGratitudeBinding
import peakvalleytech.neverdown.databinding.FragmentGratitudeListBinding
import peakvalleytech.neverdown.model.gratitude.GratitudeItem
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModel
import peakvalleytech.neverdown.ui.activity.gratitude.GratitudeViewModelFactory
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionFragment

class GratitudeListFragment : Fragment() {
    private val viewModel by viewModels<GratitudeListViewModel> {
        GratitudeListViewModelFactory(
            (requireContext().applicationContext as NeverDownApplication).gratitudeRepository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = inflate<FragmentGratitudeListBinding>(
            inflater,
            R.layout.fragment_gratitude_list,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.mutableLiveData.observe(viewLifecycleOwner, Observer {
            val fragment: Class<out Fragment>? = it.getContentIfNotHandled()
            if(fragment != null) {
                val transaction = parentFragmentManager.beginTransaction()
//            parentFragmentManager.primaryNavigationFragment
                transaction.setPrimaryNavigationFragment(this)
                transaction.addToBackStack(null)
                transaction.replace(R.id.fragment_host, GratitudeSessionFragment())
                transaction.commit()
            }

        })

        return binding.root
    }

    class MyListAdapter(val items: List<GratitudeItem>) : RecyclerView.Adapter<MyListAdapter.ListViewHolder>() {

        class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            TODO("Not yet implemented")
        }

    }
}
package peakvalleytech.neverdown.ui.activity.gratitude.list

import android.graphics.Canvas
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
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
    private val TAG = "GratitudeListFragment"
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

        val recyclerView: RecyclerView = binding.recycler
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        viewModel.listLiveData.observe(viewLifecycleOwner, Observer {

            recyclerView.adapter = MyListAdapter(it as MutableList<GratitudeItem>, viewModel)
            val itemTouchHelperCallback = MyItemTouchHelperCallback(recyclerView.adapter as MyListAdapter, ItemTouchHelper.DOWN, ItemTouchHelper.LEFT)
            val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)

        })
        return binding.root
    }

    class MyListAdapter(val items: MutableList<GratitudeItem>, val viewModel: GratitudeListViewModel) : RecyclerView.Adapter<MyListAdapter.ListViewHolder>() {

        class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private lateinit var text: TextView

            fun bind(item: GratitudeItem) {
                text = itemView.findViewById<TextView>(android.R.id.text1)
                text.text = item.name
            }
        }

        fun removeItem(index: Int) {
            val item = items.get(index)
            items.removeAt(index)
            viewModel.deleteItem(item)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
            return ListViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            holder.bind(items[position])
        }

    }

    class MyItemTouchHelperCallback(val myListAdapter: MyListAdapter, dragDirs: Int,
                                    swipeDirs: Int
    ) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
        private val TAG = "MyItemTouchHelper"
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            TODO("Not yet implemented")
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            Log.d(TAG, "Item swiped." )
            myListAdapter.removeItem(viewHolder.layoutPosition)
            myListAdapter.notifyItemRemoved(viewHolder.layoutPosition)
        }

        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

}
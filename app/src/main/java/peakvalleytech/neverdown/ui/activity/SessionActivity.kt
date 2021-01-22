package peakvalleytech.neverdown.ui.activity

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import peakvalleytech.neverdown.R

open class SessionFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_session, container, false)

//        val dialog: AlertDialog.Builder = AlertDialog.Builder(context)
//        dialog.setMessage("A message")
//        dialog.show()


        return root
    }
}
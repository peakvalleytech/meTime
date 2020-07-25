package peakvalleytech.neverdown.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.databinding.ActivitiesActivityBinding
import peakvalleytech.neverdown.ui.activitylist.ActivitiesListFragment

class ActivitiesActivity : AppCompatActivity() {
    lateinit var  binding: ActivitiesActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activities_activity)
//        binding = DataBindingUtil.setContentView(this, R.layout.activities_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ActivitiesListFragment.newInstance())
                    .commitNow()
        }
    }
}
package peakvalleytech.neverdown.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import peakvalleytech.neverdown.R
import peakvalleytech.neverdown.ui.activities.activitylist.ActivitiesListFragment

class ActivitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activities_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ActivitiesListFragment.newInstance())
                    .commitNow()
        }
    }
}
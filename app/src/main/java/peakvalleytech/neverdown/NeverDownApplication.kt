package peakvalleytech.neverdown

import android.app.Application
import peakvalleytech.neverdown.data.repo.GratitudeRepository

class NeverDownApplication : Application() {
    val gratitudeRepository : GratitudeRepository
        get() = ServiceLocator.provideGratitudeRepository(this)

    override fun onCreate() {
        super.onCreate()
    }
}
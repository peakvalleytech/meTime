package peakvalleytech.neverdown

import android.app.Application
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.data.repo.QuotesRepository

class NeverDownApplication : Application() {
    val gratitudeRepository : GratitudeRepository
        get() = ServiceLocator.provideGratitudeRepository(this)
    val quotesRepository: QuotesRepository
        get() = ServiceLocator.provideQuotesRepository(this)
}
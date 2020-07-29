package peakvalleytech.neverdown

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.data.local.LocalGratitudeDataSource
import peakvalleytech.neverdown.data.local.NeverDownDatabase
import peakvalleytech.neverdown.data.repo.DefaultGratitudeRepository
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.data.repo.QuotesRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

object ServiceLocator {
    private var neverDownDatabase : NeverDownDatabase? = null
    @Volatile
    var gratitudeRepository: GratitudeRepository? = null

    private val lock = Any()

    fun provideGratitudeRepository(context: Context): GratitudeRepository {
        synchronized(this) {
            return gratitudeRepository ?: createGratitudeRepository(context)
        }
    }

    private fun createGratitudeRepository(context: Context): GratitudeRepository {
        var ndb  = neverDownDatabase ?: createDatabase(context)
        var localGratitudeDataSource = LocalGratitudeDataSource(ndb.gratitudeItemDao())
        return DefaultGratitudeRepository(localGratitudeDataSource, context)
    }

    /** Used for testing only **/
    @VisibleForTesting
    fun resetRepository() {
        synchronized(lock) {
            runBlocking {
                // nothing to do yet repositories are read only for now
            }
        }
    }


    fun provideQuotesRepository(neverDownApplication: NeverDownApplication): QuotesRepository {
        return null
    }

    private fun createDatabase(context: Context): NeverDownDatabase {
        val result = Room.databaseBuilder(
            context.applicationContext,
            NeverDownDatabase::class.java,
            "Neverdown.db").build()

        neverDownDatabase = result
        return result
    }
}

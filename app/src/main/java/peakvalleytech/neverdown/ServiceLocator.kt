package peakvalleytech.neverdown

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.runBlocking
import peakvalleytech.neverdown.data.local.LocalGratitudeDataSource
import peakvalleytech.neverdown.data.local.Database
import peakvalleytech.neverdown.data.repo.DefaultGratitudeRepository
import peakvalleytech.neverdown.data.repo.GratitudeRepository
import peakvalleytech.neverdown.model.gratitude.GratitudeItem

object ServiceLocator {
    private var database : Database? = null
    @Volatile
    var gratitudeRepository: GratitudeRepository? = null

    private val lock = Any()

    fun provideGratitudeRepository(context: Context): GratitudeRepository {
        synchronized(this) {
            return gratitudeRepository ?: createGratitudeRepository(context)
        }
    }

    private fun createGratitudeRepository(context: Context): GratitudeRepository {
        var ndb  = database ?: createDatabase(context)
        var localGratitudeDataSource = LocalGratitudeDataSource(ndb.gratitudeItemDao())
        return DefaultGratitudeRepository(localGratitudeDataSource)
    }

    private fun createDatabase(context: Context): Database {
        val result = Room.databaseBuilder(
            context.applicationContext,
            Database::class.java,
            "Neverdown.db")
        .addCallback(object : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
//                (gratitudeRepository as DefaultGratitudeRepository).mIsLoading.value = false
            }

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                suspend {
                    (gratitudeRepository as DefaultGratitudeRepository).mIsLoading.value = true
                    val neverDownDatabase = db as Database
                    val gratitudeItemDao = neverDownDatabase.gratitudeItemDao()
                    val itemNames = listOf("Place to sleep", "Food", "A job", "Water", "Clothes", "Computer")
                    val items: MutableList<GratitudeItem> = mutableListOf()
                    var id = 1
                    for (itemName in itemNames) {
                        val item = GratitudeItem(id++, itemName)
                        items.add(item)
                    }
                    gratitudeItemDao.insertItems(items)
                    (gratitudeRepository as DefaultGratitudeRepository).mIsLoading.value = false
                }
            }
        }).build()

        database = result
        return result
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
}
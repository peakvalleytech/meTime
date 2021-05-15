package peakvalleytech.neverdown.di

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import peakvalleytech.neverdown.NeverDownApplication
import peakvalleytech.neverdown.data.local.GratitudeDao
import peakvalleytech.neverdown.data.local.LocalGratitudeDataSource
import peakvalleytech.neverdown.data.local.NeverDownDatabase
import peakvalleytech.neverdown.data.repo.gratitude.DefaultGratitudeRepository
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionViewModel
//import peakvalleytech.neverdown.data.local.Database
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : NeverDownDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NeverDownDatabase::class.java,
            "Neverdown.db").fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideGratitudeDao(database: NeverDownDatabase) : GratitudeDao = database.gratitudeItemDao()

    @Singleton
    @Provides
    fun provideLocalGratitudeDataSource(gratitudeDao: GratitudeDao): LocalGratitudeDataSource {
        return LocalGratitudeDataSource(gratitudeDao)
    }
    @Singleton
    @Provides
    fun provideGratitudeRepository(localDataSource: LocalGratitudeDataSource, @ApplicationContext context: Context): GratitudeRepository {
        return DefaultGratitudeRepository(localDataSource, context)
    }
//    @Singleton
//    @Provides
//    fun provideGratitudeSessionViewModel(gratitudeRepository: GratitudeRepository): GratitudeSessionViewModel {
//        return GratitudeSessionViewModel(gratitudeRepository = gratitudeRepository)
//    }

}
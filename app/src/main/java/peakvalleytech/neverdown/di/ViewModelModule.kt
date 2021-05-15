package peakvalleytech.neverdown.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import peakvalleytech.neverdown.data.local.LocalGratitudeDataSource
import peakvalleytech.neverdown.data.repo.gratitude.DefaultGratitudeRepository
import peakvalleytech.neverdown.data.repo.gratitude.GratitudeRepository
import peakvalleytech.neverdown.ui.activity.gratitude.session.GratitudeSessionViewModel
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ViewModelModule {
    @Singleton
    @Provides
    fun provideGratitudeSessionViewModel(gratitudeRepository: GratitudeRepository): GratitudeSessionViewModel {
        return GratitudeSessionViewModel(gratitudeRepository = gratitudeRepository)
    }

}
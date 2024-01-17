package com.example.newsapp.di

import android.app.Application
import com.example.newsapp.data.manager.LocalUserManagerImpl
import com.example.newsapp.data.remote.NewsApi
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.repository.NewsRepository
import com.example.newsapp.domain.useCases.appEntry.AppEntryUseCases
import com.example.newsapp.domain.useCases.appEntry.ReadAppEntry
import com.example.newsapp.domain.useCases.appEntry.SaveAppEntry
import com.example.newsapp.domain.useCases.news.GetNews
import com.example.newsapp.domain.useCases.news.NewsUseCases
import com.example.newsapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi): NewsRepository {
        return NewsRepositoryImpl(newsApi = newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository = newsRepository)
        )
    }
}
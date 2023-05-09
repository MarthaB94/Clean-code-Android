package com.barryzea.cleancodeapp.di

import com.barryzea.cleancodeapp.common.Constants
import com.barryzea.cleancodeapp.data.RepositoryImpl
import com.barryzea.cleancodeapp.data.remoteDatasource.ApiClient
import com.barryzea.cleancodeapp.data.Repository
import com.barryzea.cleancodeapp.domain.ImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun retrofitBuilderProvides(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun apiClientProvides(retrofit: Retrofit):ApiClient=retrofit.create(ApiClient::class.java)

    @Provides
    fun repositoryProvides(api:ApiClient): Repository = RepositoryImpl(api)

    @Provides
    fun useCaseProvides(repository: Repository):ImagesUseCase= ImagesUseCase(repository)
}
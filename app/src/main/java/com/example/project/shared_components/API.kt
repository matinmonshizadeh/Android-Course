package com.example.project.shared_components

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class API {
    companion object {

        private val myAppClient: OkHttpClient
            get() = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .readTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .connectTimeout(Constants.connectionTime, TimeUnit.SECONDS)
                .build()

        private val apiBuilder: Retrofit.Builder
            get() = Retrofit.Builder()
                .client(myAppClient)
                .addConverterFactory(GsonConverterFactory.create(gson))

        val HomeService: HomeAPIService by lazy {
            apiBuilder
                .baseUrl(Constants.baseURL)
                .build()
                .create(HomeAPIService::class.java)
        }

        val SignUpService: SignUpAPIService by lazy {
            apiBuilder
                .baseUrl(Constants.baseURL)
                .build()
                .create(SignUpAPIService::class.java)
        }

        val DetailsService: MovieDetailsAPIService by lazy {
            apiBuilder
                .baseUrl(Constants.baseURL)
                .build()
                .create(MovieDetailsAPIService::class.java)
        }

        val SearchService: SearchAPIService by lazy {
            apiBuilder
                .baseUrl(Constants.baseURL)
                .build()
                .create(SearchAPIService::class.java)
        }

        private val gson: Gson get() = GsonBuilder().setLenient().create()

        private val interceptor: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor()
                .apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }

        private object Constants {
            const val baseURL = "https://api.cseshirazu307.ir/"
            const val connectionTime: Long = 60
        }

    }

}
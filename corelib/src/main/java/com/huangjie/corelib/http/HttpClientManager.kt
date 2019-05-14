package com.huangjie.corelib.http

import com.huangjie.corelib.global.BaseApplication
import com.huangjie.corelib.http.intercept.HttpIntercept
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by huangjie on 2019/3/13.
 */
object HttpClientManager {

    private const val cacheSize: Long = 10 * 1024 * 1024
    private val cacheFile: File = File(BaseApplication.getContext().cacheDir, "cache")
    private val cache: Cache = Cache(cacheFile, cacheSize)

    private val okHttpclient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpIntercept())
            .cache(cache)
            .connectTimeout(17, TimeUnit.MINUTES)
            .readTimeout(17, TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://gank.io/api/")
            .client(okHttpclient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val httpclient: HttpInterface = retrofit.create(HttpInterface::class.java)
}
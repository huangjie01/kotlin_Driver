package com.huangjie.corelib.http

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by huangjie on 2019/2/27.
 */

interface HttpInterface {

    @GET("feeds/world")
    fun loadGifData(@Query("d") d: String, @Query("t") t: String, @Query("u") u: String):Observable<String>
}
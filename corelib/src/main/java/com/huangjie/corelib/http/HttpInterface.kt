package com.huangjie.corelib.http

import com.huangjie.corelib.bean.WelfareResponseBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by huangjie on 2019/2/27.
 */

interface HttpInterface {

    @GET("feeds/world")
    fun loadGifData(@Query("d") d: String, @Query("t") t: String, @Query("u") u: String): Observable<String>

    @GET("data/福利/10/{page}")
    fun loadWelfareData(@Path("page") page: Int): Observable<WelfareResponseBean>
}
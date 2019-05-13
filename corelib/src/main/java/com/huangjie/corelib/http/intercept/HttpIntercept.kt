package com.huangjie.corelib.http.intercept

import com.huangjie.corelib.http.TokenManager
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by huangjie on 2019/3/13.
 */

class HttpIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {

        val request = chain?.request()
        if (request?.header("Authorization") != null) {
            autoAddToken(request, chain)
        }
        return chain?.proceed(request)!!
    }

    /**
     * 自动注入Token
     */
    private fun autoAddToken(request: Request, chain: Interceptor.Chain): Response {

        val requestBuilder = request.newBuilder()
                .addHeader("Authorization", TokenManager.token)
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}
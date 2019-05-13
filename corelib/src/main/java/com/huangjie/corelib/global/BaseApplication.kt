package com.huangjie.corelib.global

import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV


class BaseApplication : Application() {

    companion object {
        private lateinit var context: Context

        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        MMKV.initialize(context)
    }



}
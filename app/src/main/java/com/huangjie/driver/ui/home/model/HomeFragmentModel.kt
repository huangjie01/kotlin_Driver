package com.huangjie.driver.ui.home.model

import com.huangjie.corelib.base.BaseModel
import com.huangjie.corelib.http.HttpClientManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeFragmentModel : BaseModel() {

    /**
     * 加载全部的gif 数据
     */
    fun loadAllGifData() {

        HttpClientManager.httpclient.loadGifData("","","")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                })

    }
}
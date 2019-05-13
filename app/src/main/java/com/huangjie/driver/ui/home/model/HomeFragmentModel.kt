package com.huangjie.driver.ui.home.model

import com.huangjie.corelib.base.BaseModel
import com.huangjie.corelib.http.HttpManager
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class HomeFragmentModel : BaseModel() {

    /**
     * 加载全部的gif 数据
     */
    fun loadAllGifData() {

        HttpManager.httpclient.loadGifData("","","")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                })

    }
}
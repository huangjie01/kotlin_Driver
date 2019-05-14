package com.huangjie.driver.ui.welfare.presenter

import android.util.Log
import com.huangjie.corelib.base.BasePresenter
import com.huangjie.corelib.bean.WelfareResponseBean
import com.huangjie.driver.ui.welfare.WelfareContact
import com.huangjie.driver.ui.welfare.model.WelfareModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class WelfarePresenter(view: WelfareContact.View)
    : BasePresenter<WelfareContact.View>(view), WelfareContact.presenter {

    private val model: WelfareModel = WelfareModel()

    init {

    }

    override fun loadWelfareData(page: Int) {

        mBindView?.showLoading()
        model.loadWelfareData(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<WelfareResponseBean> {

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                        mBindView?.hideLoading()
                    }

                    override fun onError(e: Throwable) {
                        mBindView?.hideLoading()
                        mBindView?.loadWelfareDataFail()
                    }

                    override fun onNext(respnse: WelfareResponseBean) {
                        mBindView?.loadWelfareDataSuccess(respnse)
                    }

                })
    }

}
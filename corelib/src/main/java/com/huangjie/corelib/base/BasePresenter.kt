package com.huangjie.corelib.base

/**
 * Created by huangjie on 2019/3/6.
 */
open class BasePresenter<M, T> constructor(model: M, bindView: T) : IPresenter {


    var mBindView: T? = null
    var mModel: M? = null

    init {
        this.mModel = model
        this.mBindView = bindView
    }


    override fun detachView() {
        mBindView = null
    }
}
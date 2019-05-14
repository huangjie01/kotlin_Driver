package com.huangjie.corelib.base

/**
 * Created by huangjie on 2019/3/6.
 */
open class BasePresenter< T> constructor( bindView: T) : IPresenter {


    var mBindView: T? = null

    init {
        this.mBindView = bindView
    }


    override fun detachView() {
        mBindView = null

    }
}
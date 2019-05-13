package com.huangjie.corelib.base

import rx.Subscription

/**
 * Created by huangjie on 2019/3/13.
 */

interface IModel{

    /**
     * 取消订阅
     */
    fun unSubscription()

    /**
     * 添加订阅
     */
    fun addSubscription(subscription: Subscription)
}
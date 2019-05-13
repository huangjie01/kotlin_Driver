package com.huangjie.corelib.base

import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by huangjie on 2019/3/13.
 */
open class BaseModel : IModel {

    lateinit var mSubscription: CompositeSubscription

    override fun unSubscription() {

        if (mSubscription.hasSubscriptions()) {
            mSubscription.unsubscribe()
        }
    }

    override fun addSubscription(subscription: Subscription) {

        mSubscription.add(subscription)
    }
}
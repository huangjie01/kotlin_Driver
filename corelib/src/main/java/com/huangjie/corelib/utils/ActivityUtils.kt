package com.huangjie.corelib.utils

import android.app.Activity
import java.lang.ref.WeakReference

/**
 * Created by huangjie on 2019/2/25.
 */
object ActivityUtils {

    /**
     * 存储所有的Activity
     */
    private val activityList = ArrayList<WeakReference<Activity>>()


    /**
     *
     */
    fun size(): Int {
        return activityList.size
    }

    fun add(activity: WeakReference<Activity>) {
        activityList.add(activity)
    }

    /**
     * 退出所有的Activity
     */
    fun finishAll() {
        if (activityList.isNotEmpty()) {
            for (activityRef in activityList) {
                val activity = activityRef.get()
                if (activity != null && !activity.isFinishing) {
                    activity.finish()
                }
            }
            activityList.clear()
        }
    }

}
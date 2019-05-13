package com.huangjie.corelib.base

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.huangjie.corelib.utils.ActivityUtils
import java.lang.ref.WeakReference

/**
 * Created by huangjie on 2019/2/25.
 */
open class BaseActivity : AppCompatActivity() {

    /**
     * 显示加载失败ViewStub
     */
    private var loadErrorView: View? = null

    /**
     * 显示网络错误ViewStub
     */
    private var netErrorView: View? = null


    protected var toolbar: Toolbar? = null

    private var weakReference: WeakReference<Activity>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weakReference = WeakReference(this)
        ActivityUtils.add(weakReference)

    }

    /**
     * 根据drawable id 获取图片
     */
    fun loadDrawable(drawableID: Int): Drawable {
        return resources.getDrawable(drawableID)
    }

    /**
     * 根据stringID 获取String
     */
    fun loadString(stringID: Int): String {
        return resources.getString(stringID)
    }

    /**
     * 加载颜色资源
     */
    fun loadColor(colorID: Int): Int {
        return resources.getColor(colorID)
    }
}
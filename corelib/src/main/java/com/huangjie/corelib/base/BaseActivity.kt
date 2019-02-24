package com.huangjie.corelib.base

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View

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


}
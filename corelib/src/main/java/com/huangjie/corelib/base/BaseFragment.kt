package com.huangjie.corelib.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.huangjie.corelib.R
import org.greenrobot.eventbus.EventBus

/**
 * Created by huangjie on 2019/3/5.
 */
abstract class BaseFragment : Fragment(), IBaseView {

    private var mRootView: ViewGroup? = null
    private var mIsVisible: Boolean = false
    private var mHasPrepared: Boolean = false
    private var mHasInit: Boolean = false
    private lateinit var loading: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (javaClass.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().register(this)
        }
        if (mRootView == null) {
            mRootView = inflater?.inflate(setContentView(), container, false) as ViewGroup
        }
        return mRootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHasPrepared = true
        lazyLoad()
    }

    /**
     * 设置根布局
     */
    abstract fun setContentView(): Int


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            mIsVisible = true
            onVisible()
        } else {
            mIsVisible = false
            onInvisible()
        }
    }

    override fun showLoading() {
        if (!this::loading.isInitialized) {
            loading = ProgressDialog(context)
            loading.setContentView(R.layout.progress_dialog)
            loading.setCancelable(false)
        }
        loading.show()
    }

    override fun hideLoading() {
        if (this::loading.isInitialized) {
            loading.dismiss()
        }
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()

        if (this::loading.isInitialized && loading.isShowing) {
            loading.dismiss()
        }
    }

    /**
     * 试图不可见
     */
    private fun onInvisible() {
    }

    /***
     * 实图可见
     */
    private fun onVisible() {
        lazyLoad()
    }

    private fun lazyLoad() {
        if (mIsVisible && mHasPrepared && !mHasInit) {
            mHasInit = true
            loadData()
        }
    }

    /**
     * 加载数据
     */
    abstract fun loadData()

    override fun onDestroyView() {
        if (javaClass.isAnnotationPresent(BindEventBus::class.java)) {
            EventBus.getDefault().unregister(this)
        }
        super.onDestroyView()
    }
}
package com.huangjie.driver.ui.welfare.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.huangjie.corelib.base.BaseFragment
import com.huangjie.corelib.bean.WelfareResponseBean
import com.huangjie.driver.R
import com.huangjie.driver.ui.welfare.WelfareContact
import com.huangjie.driver.ui.welfare.presenter.WelfarePresenter
import kotlinx.android.synthetic.main.fragment_welfare.*
import java.util.*

/**
 * Created by huangjie on 2019/3/6.
 */
class WelfareFragmemt : BaseFragment(), WelfareContact.View {
    private lateinit var presenter: WelfarePresenter
    private val currentPage: Int = 1
    lateinit var date: Date

    override fun loadData() {
        presenter = WelfarePresenter(this)
        presenter.loadWelfareData(currentPage)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRecyWelfare.layoutManager = LinearLayoutManager(context)

    }


    override fun setContentView(): Int {
        return R.layout.fragment_welfare
    }


    override fun loadWelfareDataSuccess(responseBean: WelfareResponseBean) {
        showToast(responseBean.toString())
    }


    override fun loadWelfareDataFail() {
        showToast("加载福利数据失败")
    }


}
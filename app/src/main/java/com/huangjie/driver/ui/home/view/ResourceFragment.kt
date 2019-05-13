package com.huangjie.driver.ui.home.view

import android.os.Bundle
import android.view.View
import com.huangjie.corelib.base.BaseFragment
import com.huangjie.driver.R

/**
 * Created by huangjie on 2019/3/5.
 */
class ResourceFragment :BaseFragment(){



    override fun setContentView(): Int {
        return R.layout.fragment_resource
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun loadData() {
    }
}
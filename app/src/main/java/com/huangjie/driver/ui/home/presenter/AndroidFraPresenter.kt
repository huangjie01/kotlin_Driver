package com.huangjie.driver.ui.home.presenter

import com.huangjie.corelib.base.BasePresenter
import com.huangjie.driver.ui.home.view.IAndroidFragment

class AndroidFraPresenter( view: IAndroidFragment)
    : BasePresenter<IAndroidFragment>(view), IAndroidFraPresenter {


    override fun loadAndroidData(refresh: Boolean) {
    }


}
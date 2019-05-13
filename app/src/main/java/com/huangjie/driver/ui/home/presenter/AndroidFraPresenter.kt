package com.huangjie.driver.ui.home.presenter

import com.huangjie.corelib.base.BasePresenter
import com.huangjie.driver.ui.home.model.IAndroidModel
import com.huangjie.driver.ui.home.view.IAndroidFragment

class AndroidFraPresenter(model: IAndroidModel, view: IAndroidFragment)
    : BasePresenter<IAndroidModel, IAndroidFragment>(model, view), IAndroidFraPresenter {


    override fun loadAndroidData(refresh: Boolean) {
    }


}
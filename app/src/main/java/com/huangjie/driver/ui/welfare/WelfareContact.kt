package com.huangjie.driver.ui.welfare

import com.huangjie.corelib.base.IBaseView
import com.huangjie.corelib.bean.WelfareResponseBean
import io.reactivex.Observable

interface WelfareContact {

    interface View : IBaseView {
        fun loadWelfareDataSuccess( responseBean: WelfareResponseBean)
        fun loadWelfareDataFail()
    }

    interface model {
        fun loadWelfareData(page: Int): Observable<WelfareResponseBean>
    }

    interface presenter {

        fun loadWelfareData(page: Int)
    }
}
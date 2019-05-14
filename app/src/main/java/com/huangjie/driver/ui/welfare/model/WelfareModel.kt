package com.huangjie.driver.ui.welfare.model

import com.huangjie.corelib.base.BaseModel
import com.huangjie.corelib.bean.WelfareResponseBean
import com.huangjie.corelib.http.HttpClientManager
import com.huangjie.driver.ui.welfare.WelfareContact
import io.reactivex.Observable

class WelfareModel : BaseModel(), WelfareContact.model {

    /**
     * 加载福利数据
     */
    override fun loadWelfareData(page: Int): Observable<WelfareResponseBean> {

        return HttpClientManager.httpclient.loadWelfareData(page)
    }


}
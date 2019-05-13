package com.huangjie.corelib.http

import com.huangjie.corelib.cache.MMKVUtils


object TokenManager {
    var token: String = MMKVUtils.loadToken()

}
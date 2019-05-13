package com.huangjie.corelib.cache

import com.tencent.mmkv.MMKV

object MMKVUtils {

   private const val SAVE_TOKEN_KEY = "save_token"

  private  val mmkv = MMKV.defaultMMKV()


    fun saveToken(token: String) {
        mmkv.encode(SAVE_TOKEN_KEY, token)
    }

    fun loadToken() = mmkv.decodeString(SAVE_TOKEN_KEY)
}
package com.huangjie.corelib.bean

import com.google.gson.annotations.SerializedName


data class WelfareBean(@SerializedName("_id") val id: String,
                       @SerializedName("url") val url: String)


data class WelfareResponseBean(@SerializedName("error") val error: Boolean,
                               @SerializedName("results") val results: List<WelfareBean>)



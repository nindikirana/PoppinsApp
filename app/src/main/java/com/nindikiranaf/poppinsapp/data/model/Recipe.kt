package com.nindikiranaf.poppinsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe (
    val title:String = "",
    val thumb: String = "",
    val key: String = "",
    val times: String = "",
    val portion: String = "",
    val difficulty: String = ""
) : Parcelable

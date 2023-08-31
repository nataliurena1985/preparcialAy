package com.utn.myapplication.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(
    val name: String, val employeeQty: Int, val logo: String, val description: String
) : Parcelable

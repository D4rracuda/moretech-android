package com.lydone.sharebillandroid.share_bill

import com.google.gson.annotations.SerializedName

data class Bill(
    @SerializedName("internal_id") val internalId: String,
    @SerializedName("organisation_tax_id") val organisationTaxId: String,
    val items: List<BillItem>,
    val datetime: String
)

data class BillItem(
    val title: String,
    val description: String,
    val quantity: Int,
    val price: Int,
    var isSelected: Boolean = false
)
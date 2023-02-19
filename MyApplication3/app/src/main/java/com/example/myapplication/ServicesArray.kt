package com.example.myapplication

import com.google.gson.annotations.SerializedName

class ServicesArray {
    @SerializedName("items")
    private var vkServices: ArrayList<InfoServices> = ArrayList<InfoServices>()

    fun getVkServices(): ArrayList<InfoServices> {
        return vkServices
    }


}

class InfoServices{
    @SerializedName("name")
    private var nameService: String = "Undefined"

    fun getNameService(): String {
        return nameService
    }

    @SerializedName("description")
    private var descriptionService: String = "Undefined"

    fun getDescriptionService(): String {
        return descriptionService
    }

    @SerializedName("icon_url")
    private var iconService: String = "Undefined"

    fun getIconService(): String {
        return iconService
    }

    @SerializedName("service_url")
    private var urlService: String = "Undefined"

    fun getUrlService(): String {
        return urlService
    }
}
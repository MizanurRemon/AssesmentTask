package com.technonext.network.provider

import com.technonext.network.di.RestConfig

class BaseUrlProvider() {
    fun getBaseUrl(): String {
        return RestConfig.BASE_URL
    }
}
package io.github.tuguzt.sql

import tornadofx.App
import tornadofx.Rest
import tornadofx.find

var App.userAccessToken: String?
    get() = config.string("user_access_token")
    set(value) = with(config) {
        set("user_access_token" to value)
        save()
    }

fun App.setupAuth() {
    val token = userAccessToken
    val rest = find(Rest::class)
    if (token == null) {
        with(rest.engine) {
            requestInterceptor = null
            responseInterceptor = null
        }
        return
    }
    with(rest.engine) {
        requestInterceptor = { request ->
            request.addHeader("Authorization", "Bearer $token")
        }
        responseInterceptor = { response ->
            if (response.statusCode == 401 || response.statusCode == 403) {
                userAccessToken = null
                requestInterceptor = null
                responseInterceptor = null
            }
        }
    }
}

package io.github.tuguzt.sql

import tornadofx.App

var App.userAccessToken: String?
    get() = config.string("user_access_token")
    set(value) {
        config.set("user_access_token" to value)
        config.save()
    }

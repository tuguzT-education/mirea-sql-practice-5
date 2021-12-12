package io.github.tuguzt.sql

import tornadofx.App

inline var App.userAccessToken: String?
    get() = config["user_access_token"] as String?
    set(value) {
        config["user_access_token"] = value
        config.save()
    }

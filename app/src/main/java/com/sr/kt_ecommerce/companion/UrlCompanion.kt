package com.sr.kt_ecommerce.companion

class UrlCompanion {
    companion object{
        var REGISTER_TAG = "REGISTER"
        var LOGIN_TAG = "LOGIN"
        var MAIN_URL = "https://8922-2400-1a00-b060-dc16-7512-2daf-c4be-8ec9.ngrok-free.app";
        var REGISTER_URL = "$MAIN_URL/auth/register"
        var LOGIN_URL = "$MAIN_URL/auth/login"
        var PRODUCT_URL = "$MAIN_URL/products/getAllProducts"
        var PRODUCT_TAG = "PRODUCT"

    }
}
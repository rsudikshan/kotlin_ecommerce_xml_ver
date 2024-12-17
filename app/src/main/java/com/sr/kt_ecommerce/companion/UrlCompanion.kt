package com.sr.kt_ecommerce.companion

class UrlCompanion {
    companion object{
        var REGISTER_TAG = "REGISTER"
        var LOGIN_TAG = "LOGIN"
        var MAIN_URL = "https://9ba7-2400-1a00-b060-45bd-5942-5d87-1e72-297d.ngrok-free.app";
        var REGISTER_URL = "$MAIN_URL/auth/register"
        var LOGIN_URL = "$MAIN_URL/auth/login"
        var PRODUCT_URL = "$MAIN_URL/products/getAllProducts"

    }
}
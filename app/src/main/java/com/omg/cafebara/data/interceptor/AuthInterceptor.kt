package com.omg.cafebara.data.interceptor

import com.omg.cafebara.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val authRequest =
            originalRequest.newBuilder().addHeader(ACCESS_TOKEN, BuildConfig.BUILD_TYPE).build()
        // TODO ACCES TOKEN 으로 변경예정
        val response = chain.proceed(authRequest)

        when (response.code) {
            401 -> {
                // TODO 토큰 재발급 api 연동
            }
        }
        return response
    }

    companion object {
        const val ACCESS_TOKEN = "accessToken"
    }
}

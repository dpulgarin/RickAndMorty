package com.dpulgarin.rickandmorty.core

import com.dpulgarin.rickandmorty.application.AppConstants
import kotlinx.coroutines.coroutineScope
import java.net.InetSocketAddress
import java.net.Socket
import kotlin.Exception as Exception1

object InternetCheck {
    suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try {
            val sock = Socket()
            val socketAddress = InetSocketAddress(AppConstants.HOSTNAME, AppConstants.PORT)
            sock.connect(socketAddress, AppConstants.TIMEOUT)
            sock.close()
            true
        } catch (e: Exception1) {
            false
        }
    }
}
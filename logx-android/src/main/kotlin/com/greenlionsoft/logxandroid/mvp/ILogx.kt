package com.greenlionsoft.logxandroid.mvp


interface ILogx {

    fun v(tag: String, message: String)

    fun d(tag: String, message: String)

    fun i(tag: String, message: String)

    fun w(tag: String, message: String)

    fun e(tag: String, message: String)

    fun e(tag: String, message: String, e: Throwable?)


    fun v(message: String)

    fun d(message: String)

    fun i(message: String)

    fun w(message: String)

    fun e(message: String)

    fun e(message: String, e: Throwable?)


    fun areLogsEnabled(): Boolean

    fun reportException(e: Throwable?)

    fun getTag(): String
}
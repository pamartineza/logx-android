package com.greenlionsoft.logxandroid

import android.util.Log
import com.crashlytics.android.Crashlytics
import com.greenlionsoft.logx.ILogx


class AndroidLogs(val areLogsEnabled: Boolean, var defaultTag: String = "LOGX") : ILogx {

    val isCrashlyticsAvailable: Boolean = try {
        Class.forName("com.crashlytics.android.Crashlytics")
        true
    } catch (e: ClassNotFoundException) {
        Log.e(defaultTag, "Crashlytics is not Available to report exceptions")
        false
    }

    override fun v(tag: String, message: String) {
        Log.v(tag, message)
    }

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun w(tag: String, message: String) {
        Log.w(tag, message)
    }

    override fun e(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun e(tag: String, message: String, e: Throwable) {
        Log.e(tag, message, e)
        if (isCrashlyticsAvailable && null != Crashlytics.getInstance()) {
            Crashlytics.logException(e)
        }

    }

    override fun v(message: String) {
        v(defaultTag, message)
    }

    override fun d(message: String) {
        d(defaultTag, message)
    }

    override fun i(message: String) {
        i(defaultTag, message)
    }

    override fun w(message: String) {
        w(defaultTag, message)
    }

    override fun e(message: String) {
        e(defaultTag, message)
    }

    override fun e(message: String, e: Throwable) {
        e(defaultTag, message, e)
        if (isCrashlyticsAvailable && null != Crashlytics.getInstance()) {
            Crashlytics.logException(e)
        }
    }

    override fun areLogsEnabled(): Boolean {
        return areLogsEnabled
    }

    override fun reportException(e: Throwable) {
        if (isCrashlyticsAvailable && null != Crashlytics.getInstance()) {
            Crashlytics.logException(e)
        }
    }
}
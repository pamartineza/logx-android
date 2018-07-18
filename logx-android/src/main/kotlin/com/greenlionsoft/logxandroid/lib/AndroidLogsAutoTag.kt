package com.greenlionsoft.logxandroid.lib

import android.os.Build
import android.util.Log
import com.crashlytics.android.Crashlytics
import com.greenlionsoft.logxandroid.mvp.ILogx
import java.util.regex.Pattern

class AndroidLogsAutoTag(val areLogsEnabled: Boolean) : ILogx {

    private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")
    private val MAX_LOG_LENGTH = 4000
    private val MAX_TAG_LENGTH = 23
    private val CALL_STACK_INDEX = 3

    val explicitTag = ThreadLocal<String>()

    override fun getTag(): String {
        var tag = explicitTag.get()
        if (tag != null) {
            explicitTag.remove()
            return tag
        } else {
            val stackTrace = Throwable().stackTrace
            if (stackTrace.size <= CALL_STACK_INDEX) {
                throw IllegalStateException(
                        "Synthetic stacktrace didn't have enough elements: are you using proguard?")
            }

            var tag2: String = stackTrace[CALL_STACK_INDEX].className
            val m = ANONYMOUS_CLASS.matcher(tag2)
            if (m.find()) {
                tag2 = m.replaceAll("")
            }
            tag2 = tag2.substring(tag2.lastIndexOf('.') + 1)
            // Tag length limit was removed in API 24.
            return if (tag2.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tag2
            } else tag2.substring(0, MAX_TAG_LENGTH)
        }

    }

    val isCrashlyticsAvailable: Boolean = try {
        Class.forName("com.crashlytics.android.Crashlytics")
        true
    } catch (e: ClassNotFoundException) {
        Log.e(getTag(), "Crashlytics is not Available to report exceptions")
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

    override fun e(tag: String, message: String, e: Throwable?) {
        Log.e(tag, message, e)
        reportException(e)

    }

    override fun v(message: String) {
        v(getTag(), message)
    }

    override fun d(message: String) {
        d(getTag(), message)
    }

    override fun i(message: String) {
        i(getTag(), message)
    }

    override fun w(message: String) {
        w(getTag(), message)
    }

    override fun e(message: String) {
        e(getTag(), message)
    }

    override fun e(message: String, e: Throwable?) {
        e(getTag(), message, e)
    }

    override fun areLogsEnabled(): Boolean {
        return areLogsEnabled
    }

    override fun reportException(e: Throwable?) {
        try {
            if (e != null
                    && isCrashlyticsAvailable
                    && null != Crashlytics.getInstance()) {
                Crashlytics.logException(e)
            }
        } catch (error: Exception) {
            //This may happen if Crashlytics is not initialized
            Log.e(getTag(), "Failed to report exception", e)
        }
    }
}
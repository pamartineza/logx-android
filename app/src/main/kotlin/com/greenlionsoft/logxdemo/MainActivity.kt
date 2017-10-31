package com.greenlionsoft.logxdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.greenlionsoft.logx.Logx
import com.greenlionsoft.logxandroid.AndroidLogs
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        Logx.setLogger(AndroidLogs(BuildConfig.DEBUG, "LOGX-DEMO"))
        Logx.v("Hello d")
        Logx.d("Hello d")
        Logx.i("Hello i")
        Logx.w("Hello w")
        Logx.e("Hello e")
        val exception = IllegalArgumentException("Demo exception")
        Logx.e("Hello error", exception)
        val exception2 = IllegalAccessException("Demo exception 2")
        Logx.reportException(exception2)
    }
}

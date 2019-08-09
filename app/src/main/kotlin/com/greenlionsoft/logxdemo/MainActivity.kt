package com.greenlionsoft.logxdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.greenlionsoft.logxandroid.lib.AndroidLogsAutoTag
import com.greenlionsoft.logxandroid.mvp.Logx
import io.fabric.sdk.android.Fabric

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_main)

        //Logx.setLogger(AndroidLogs(BuildConfig.DEBUG, "LOGX-DEMO"))
        Logx.setLogger(AndroidLogsAutoTag(BuildConfig.DEBUG))
        Logx.v("Hello v")
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

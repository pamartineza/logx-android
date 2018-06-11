package com.greenlionsoft.logxandroid.mvp

object Logx {

    private lateinit var logger: ILogx

    fun setLogger(logger: ILogx) {
        this.logger = logger
    }

    //Debug
    fun d(message: String) {
        if (logger.areLogsEnabled()) {
            logger.d(message)
        }
    }

    fun d(tag: String, message: String) {
        if (logger.areLogsEnabled()) {
            logger.d(tag, message)
        }
    }

    fun d(enabledStatusOverride: Boolean, message: String) {
        if (enabledStatusOverride) {
            logger.d(message)
        }
    }


    fun d(enabledStatusOverride: Boolean, tag: String, message: String) {
        if (enabledStatusOverride) {
            logger.d(tag, message)
        }
    }


    //Verbose
    fun v(message: String) {
        if (logger.areLogsEnabled()) {
            logger.v(message)
        }
    }

    fun v(tag: String, message: String) {
        if (logger.areLogsEnabled()) {
            logger.v(tag, message)
        }
    }

    fun v(enabledStatusOverride: Boolean, message: String) {
        if (enabledStatusOverride) {
            logger.v(message)
        }
    }


    fun v(enabledStatusOverride: Boolean, tag: String, message: String) {
        if (enabledStatusOverride) {
            logger.v(tag, message)
        }
    }


    //info
    fun i(message: String) {
        if (logger.areLogsEnabled()) {
            logger.i(message)
        }
    }

    fun i(tag: String, message: String) {
        if (logger.areLogsEnabled()) {
            logger.i(tag, message)
        }
    }

    fun i(enabledStatusOverride: Boolean, message: String) {
        if (enabledStatusOverride) {
            logger.i(message)
        }
    }

    fun i(enabledStatusOverride: Boolean, tag: String, message: String) {
        if (enabledStatusOverride) {
            logger.i(tag, message)
        }
    }


    //warning
    fun w(message: String) {
        if (logger.areLogsEnabled()) {
            logger.w(message)
        }
    }

    fun w(tag: String, message: String) {
        if (logger.areLogsEnabled()) {
            logger.w(tag, message)
        }
    }

    fun w(enabledStatusOverride: Boolean, message: String) {
        if (enabledStatusOverride) {
            logger.w(message)
        }
    }

    fun w(enabledStatusOverride: Boolean, tag: String, message: String) {
        if (enabledStatusOverride) {
            logger.w(tag, message)
        }
    }


    //error
    fun e(message: String) {
        if (logger.areLogsEnabled()) {
            logger.e(message)
        }
    }

    fun e(tag: String, message: String) {
        if (logger.areLogsEnabled()) {
            logger.e(tag, message)
        }
    }

    fun e(message: String, e: Throwable?) {
        if (logger.areLogsEnabled()) {
            logger.e(message, e)
        } else if (e != null) {
            logger.reportException(e)
        }
    }

    fun e(tag: String, message: String, e: Throwable?) {
        if (logger.areLogsEnabled()) {
            logger.e(tag, message, e)
        }
    }

    fun e(enabledStatusOverride: Boolean, message: String, e: Throwable?) {
        if (enabledStatusOverride) {
            logger.e(message, e)
        } else if (e != null) {
            logger.reportException(e)
        }
    }


    fun e(enabledStatusOverride: Boolean, tag: String, message: String, e: Throwable?) {
        if (enabledStatusOverride) {
            logger.e(tag, message, e)
        } else if (e != null) {
            logger.reportException(e)
        }
    }


    fun reportException(e: Throwable?) {
        logger.reportException(e)
    }


}
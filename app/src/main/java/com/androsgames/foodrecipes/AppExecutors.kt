package com.androsgames.foodrecipes

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors {

    companion object {
        private var instance : AppExecutors? = null
        fun get() : AppExecutors {
            if (instance == null) {
                instance = AppExecutors()
            }
            return instance as AppExecutors
        }

        class MainThreadExecutor : Executor {
            override fun execute(command: Runnable) {
                mainThreadHandler.post(command)
            }
            private var mainThreadHandler: Handler = Handler(Looper.getMainLooper())
        }
    }

            private val mDiskIO : Executor = Executors.newSingleThreadExecutor()
            private val mMainThreadExecutor : MainThreadExecutor = MainThreadExecutor()


    fun diskIO() : Executor {
        return mDiskIO
    }

    fun mainThread() : MainThreadExecutor {
        return mMainThreadExecutor
    }




}
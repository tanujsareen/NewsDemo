package `in`.srntech90.doubtnut.ui.common

import android.content.Context
import okhttp3.Cache
import timber.log.Timber
import java.io.File

/**
Created by Tanuj.Sareen on 17,June,2020
 **/
class Util private constructor(){

    companion object CacheUtil {

        private fun provideCache(mContext:Context): Cache? {
            var cache: Cache? = null
            try {
                cache = Cache(
                    File(mContext.cacheDir, "http-cache"),
                    10 * 1024 * 1024
                ) // 10 MB
            } catch (e: Exception) {
                Timber.i( "Could not create Cache!")
            }
            return cache
        }
    }
}
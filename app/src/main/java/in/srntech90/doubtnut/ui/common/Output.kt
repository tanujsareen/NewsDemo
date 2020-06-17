package `in`.srntech90.doubtnut.ui.common

import `in`.srntech90.ashdesigns.repository.network.Errors

sealed class Output<T>{

    data class Progress<T>(var loading: Boolean) : Output<T>()
    data class Success<T>(var data: T) : Output<T>()
    data class Failure<T>(var e: Errors) : Output<T>()

    companion object {

        fun <T> loading(isLoading: Boolean): Output<T> = Progress(isLoading)

        fun <T> success(data: T): Output<T> = Success(data)

        fun <T> failure(e: Errors): Output<T> = Failure(e)

    }
}
package com.technonext.common.util

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val computation: CoroutineDispatcher
    val mainThread: CoroutineDispatcher
    val io: CoroutineDispatcher
}
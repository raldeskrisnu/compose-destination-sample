package com.raldes.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(navArgsDelegate = SendArgNav::class)
@Composable
fun Screen3(navigator: DestinationsNavigator,
            nav: SendArgNav) {
    Log.d("abc",nav.data1.toString())
}

data class SendArgNav(val data1: Int)
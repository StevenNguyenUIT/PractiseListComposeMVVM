package com.nhinhnguyenuit.practiselistcomposemvvm.navigation

sealed class SCREEN (val route: String) {
    object listScreen : SCREEN("itemlist")
    object detailScreen: SCREEN("itemdetail/{itemId}")
}
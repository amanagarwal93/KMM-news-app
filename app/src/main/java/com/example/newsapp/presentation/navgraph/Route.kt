package com.example.newsapp.presentation.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route(route = "onBoardingScreen")
    object BookmarkScreen : Route(route = "bookmarkScreen")
    object SearchScreen : Route(route = "searchScreen")
    object HomeScreen : Route(route = "homeScreen")
    object DetailsScreen : Route(route = "detailsScreen")
    object AppStartNavigation : Route(route = "appStartNavigation")
    object NewsNavigation : Route(route = "newsNavigation")
    object NewsNavigatorScreen : Route(route = "newsNavigatorScreen")
}

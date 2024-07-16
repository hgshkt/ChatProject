package com.hgshkt.chatproject.presentation.screens.main.friends

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hgshkt.chatproject.presentation.screens.main.friends.fragments.friends.FriendsFragment
import com.hgshkt.chatproject.presentation.screens.main.friends.fragments.search.SearchFragment

private val items = listOf(
    Item.Search,
    Item.Friends
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FriendsScreen(modifier: Modifier = Modifier) {

    val controller = rememberNavController()

    Box(modifier = modifier) {
        Column {
            Scaffold(
                topBar = {
                    FriendsScreenTopBar(items = items, controller = controller)
                }
            ) {
                FriendsScreenNavGraph(controller)
            }
        }
    }
}

@Composable
fun FriendsScreenTopBar(
    modifier: Modifier = Modifier,
    items: List<Item>,
    controller: NavController
) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    controller.navigate(item.title)
                },
                icon = {
                    Icon(
                        imageVector =
                        if (selectedItemIndex == index) item.selectedIcon
                        else item.unselectedIcon,
                        contentDescription = "Friend item icon"
                    )
                }
            )
        }
    }
}

@Composable
fun FriendsScreenNavGraph(controller: NavHostController) {
    NavHost(navController = controller, startDestination = Item.Friends.route) {
        composable(route = Item.Friends.route) {
            FriendsFragment()
        }
        composable(route = Item.Search.route) {
            SearchFragment()
        }
    }
}

sealed class Item(
    open val title: String,
    open val route: String,
    open val selectedIcon: ImageVector,
    open val unselectedIcon: ImageVector
) {
    data object Friends : Item(
        title = "Friends",
        route = "friends",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Default.Person
    )

    data object Search : Item(
        title = "Search",
        route = "search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Default.Search
    )
}
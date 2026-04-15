package com.example.memorymultiplatform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.memorymultiplatform.Screens.Screen1
import com.example.memorymultiplatform.Screens.Screen2
import com.example.memorymultiplatform.Screens.Screen3
import com.example.memorymultiplatform.Screens.Screen4

@Composable
fun NavigationWrapper(){
    val backStack = rememberNavBackStack(navConfig, Route.Pantalla1)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.Pantalla1> {
                Screen1(
                    navigateTo2 = { backStack.add(Route.Pantalla2) },
                    navigateTo3 = { backStack.add(Route.Pantalla3) }
                )
            }
            entry<Route.Pantalla2> {
                Screen2(
                    navigateBack = { backStack.add(Route.Pantalla1) },
                    navigateTo4 = { backStack.add(Route.Pantalla4) }

                )
            }
            entry<Route.Pantalla3> {
                Screen3(navigateBack = { backStack.removeLastOrNull() })
            }
            entry<Route.Pantalla4> {
                Screen4(navigateBack = { backStack.removeLastOrNull() })
            }

        }
    )
}

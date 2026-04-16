package com.example.memorymultiplatform.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.memorymultiplatform.ViewModel.Screen1ViewModel
import org.jetbrains.compose.resources.painterResource

import memorymultiplatform.composeapp.generated.resources.Res
import memorymultiplatform.composeapp.generated.resources.*

@Composable
fun Screen1(navigateTo2: () -> Unit, navigateTo3: () -> Unit) {
    val vm: Screen1ViewModel = viewModel { Screen1ViewModel() }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FlipCard(
            modifier = Modifier
                .size(150.dp)
                .padding(2.dp),
            front = {
                Image(
                    painter = painterResource(Res.drawable.backcard),
                    contentDescription = "Front",
                    modifier = Modifier.fillMaxSize()
                )
            },
            back = {
                Image(
                    painter = painterResource(Res.drawable.mio),
                    contentDescription = "Back",
                    modifier = Modifier.fillMaxSize()
                )
            }
        )
    }
}

@Composable
fun FlipCard(
    modifier: Modifier = Modifier,
    front: @Composable () -> Unit,
    back: @Composable () -> Unit
) {
    var flipped by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (flipped) 180f else 0f,
        animationSpec = tween(durationMillis = 600),
        label = "CardRotation"
    )

    Box(
        modifier = modifier
            .clickable { flipped = !flipped }
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12 * density
            },
        contentAlignment = Alignment.Center
    ) {
        if (rotation <= 90f) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                front()
            }
        } else {
            Box(
                Modifier.fillMaxSize().graphicsLayer { rotationY = 180f },
                contentAlignment = Alignment.Center
            ) {
                back()
            }
        }
    }
}
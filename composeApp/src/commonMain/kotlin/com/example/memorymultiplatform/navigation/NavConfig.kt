package com.example.memorymultiplatform.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

val navConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Route.Pantalla1::class, Route.Pantalla1.serializer())
            subclass(Route.Pantalla2::class, Route.Pantalla2.serializer())
            subclass(Route.Pantalla3::class, Route.Pantalla3.serializer())
            subclass(Route.Pantalla4::class, Route.Pantalla4.serializer())
        }
    }
}

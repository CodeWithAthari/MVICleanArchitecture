package com.devatrii.mvicleanarchitecture

sealed class CounterEvents {
    data object Increment:CounterEvents()
    data object Decrement:CounterEvents()
}
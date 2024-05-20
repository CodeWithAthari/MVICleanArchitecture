package com.devatrii.mvicleanarchitecture

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    var state = MutableStateFlow(CounterState())
        private set

    fun onEvent(event: CounterEvents) {
        when (event) {
            CounterEvents.Decrement -> {
                if (state.value.count == 0) {
                    state.update {
                        it.copy(
                            toastText = "Limit Reached"
                        )
                    }
                    return
                }
                state.update {
                    it.copy(
                        count = it.count - 1,
                        toastText = ""
                    )
                }
            }

            CounterEvents.Increment -> state.update {
                it.copy(
                    count = it.count + 1,
                    toastText = ""
                )
            }
        }
    }


}




















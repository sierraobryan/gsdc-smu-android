package com.sierraobryan.networkexample.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierraobryan.networkexample.data.PokemonRepository
import com.sierraobryan.networkexample.data.model.PokemonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailsViewState(
    val isLoading: Boolean = false,
    val details: PokemonDetails? = null
)


@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: PokemonRepository,
): ViewModel() {

    private val _state = MutableStateFlow(DetailsViewState())
    val state: StateFlow<DetailsViewState> = _state

    init {
        val pokemonName: String? = savedStateHandle["name"]
        if (pokemonName != null) {
            getPokemonDetails(pokemonName)
        }
    }

    private fun getPokemonDetails(name: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )
            val details = repository.getPokemonDetails(name)
            _state.value = _state.value.copy(
                details = details,
                isLoading = false
            )
        }
    }
}
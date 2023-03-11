package com.sierraobryan.networkexample.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sierraobryan.networkexample.data.PokemonRepository
import com.sierraobryan.networkexample.data.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FeatureViewState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false
)

@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _state = MutableStateFlow(FeatureViewState())
    val state: StateFlow<FeatureViewState> = _state

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true
            )
            val list = repository.getPokemonList()
            _state.value = _state.value.copy(
                isLoading = false,
                pokemonList = list,
            )
        }
    }

}
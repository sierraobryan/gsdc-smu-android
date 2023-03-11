package com.sierraobryan.networkexample.ui.feature

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FeatureContent(viewModel: FeatureViewModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    LazyColumn {
        items(state.pokemonList) {pokemon ->
            Text(text = pokemon.name)
        }
    }

}
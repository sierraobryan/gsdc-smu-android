package com.sierraobryan.networkexample.ui.feature

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FeatureContent(
    viewModel: FeatureViewModel = viewModel(),
    onClick: (String) -> Unit
) {

    val state by viewModel.state.collectAsState()

    LazyColumn {
        items(state.pokemonList) {pokemon ->
            Text(
                text = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(pokemon.name) }
                    .padding(12.dp)
            )
        }
    }

}
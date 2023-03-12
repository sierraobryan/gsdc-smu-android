package com.sierraobryan.networkexample.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.sierraobryan.networkexample.data.model.PokemonDetails

@Composable
fun DetailsContent(viewModel: DetailsViewModel) {
    val state by viewModel.state.collectAsState()

    if (state.details != null) {
        PokemonDetails(state.details!!)
    }

}

@Composable
private fun PokemonDetails(details: PokemonDetails) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = details.sprites.frontImage,
                contentDescription = "Front image of ${details.name}",
                modifier = Modifier.weight(.5f)
            )
            AsyncImage(
                model = details.sprites.backImage,
                contentDescription = "Back image of ${details.name}",
                modifier = Modifier.weight(.5f)
            )
        }
        Text(text = "Details from network call for ${details.name}")

    }
}
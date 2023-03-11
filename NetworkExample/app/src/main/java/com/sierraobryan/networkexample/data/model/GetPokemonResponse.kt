package com.sierraobryan.networkexample.data.model

data class GetPokemonResponse(
    val results: List<Pokemon>,
    val count: Int,
    val next: String,
)

data class Pokemon(
    val name: String,
    val url: String,
)
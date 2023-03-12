package com.sierraobryan.networkexample.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class GetPokemonResponse(
    val results: List<Pokemon>,
    val count: Int,
    val next: String,
)


@JsonClass(generateAdapter = true)
data class Pokemon(
    val name: String,
    val url: String,
)

@JsonClass(generateAdapter = true)
data class PokemonDetails(
    val name: String,
    val weight: Int,
    val order: Int,
    val sprites: Sprites,
)

@JsonClass(generateAdapter = true)
data class Sprites(
    @Json(name = "back_default") val backImage: String?,
    @Json(name = "front_default") val frontImage: String?
)
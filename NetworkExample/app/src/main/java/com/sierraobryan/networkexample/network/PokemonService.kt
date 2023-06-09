package com.sierraobryan.networkexample.network

import com.sierraobryan.networkexample.data.model.GetPokemonResponse
import com.sierraobryan.networkexample.data.model.PokemonDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    // https://pokeapi.co/api/v2/pokemon
    @GET("pokemon")
    suspend fun getPokemonList(): Response<GetPokemonResponse>

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): Response<PokemonDetails>
}
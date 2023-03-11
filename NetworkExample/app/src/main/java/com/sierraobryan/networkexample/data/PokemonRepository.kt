package com.sierraobryan.networkexample.data

import com.sierraobryan.networkexample.data.model.Pokemon
import com.sierraobryan.networkexample.network.PokemonService
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val service: PokemonService
) {

    suspend fun getPokemonList(): List<Pokemon> {
        val response = service.getPokemonList()
        return if (response.isSuccessful) {
            response.body()?.results ?: emptyList()
        } else {
            emptyList()
        }
    }

}
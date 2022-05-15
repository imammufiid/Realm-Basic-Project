package id.mufiid.realmproject.core.domain.repository

import id.mufiid.realmproject.core.domain.model.Pet
import kotlinx.coroutines.flow.Flow

interface IMainRepository {
    fun getPets(): Flow<List<Pet>>
}
package id.mufiid.realmproject.core.data.repository

import id.mufiid.realmproject.core.data.source.local.PetLocalDataSource
import id.mufiid.realmproject.core.domain.model.Pet
import id.mufiid.realmproject.core.domain.repository.IMainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MainRepository(private val petLocalDataSource: PetLocalDataSource): IMainRepository {
    override fun getPets(): Flow<List<Pet>> {
        return flow {
            emit(petLocalDataSource.retrievePetsToAdopt())
        }.flowOn(IO)
    }
}
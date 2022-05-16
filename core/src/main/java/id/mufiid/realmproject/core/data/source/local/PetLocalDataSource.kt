package id.mufiid.realmproject.core.data.source.local

import id.mufiid.realmproject.core.data.source.local.realm.PetDao
import id.mufiid.realmproject.core.domain.model.Pet
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PetLocalDataSource(private val petDao: PetDao) {

    suspend fun insertPet(pet: Pet) {
        petDao.insertPet(pet)
    }

    fun retrievePetsToAdopt() = flow {
        emit(petDao.retrievePetsToAdopt())
    }.flowOn(IO)

    suspend fun updatePet(petId: String, ownerId: String) {
        petDao.updatePet(petId, ownerId)
    }

    suspend fun removePet(petId: String) {
        petDao.removePet(petId)
    }
}
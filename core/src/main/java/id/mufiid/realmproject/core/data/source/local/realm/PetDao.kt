package id.mufiid.realmproject.core.data.source.local.realm

import id.mufiid.realmproject.core.domain.model.Pet

interface PetDao {
    suspend fun insertPet(pet: Pet)
    suspend fun retrievePetsToAdopt(): List<Pet>
    suspend fun updatePet(petId: String, ownerId: String)
    suspend fun removePet(petId: String)
}
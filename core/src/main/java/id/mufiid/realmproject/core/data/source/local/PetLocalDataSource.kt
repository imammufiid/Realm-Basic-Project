package id.mufiid.realmproject.core.data.source.local

import id.mufiid.realmproject.core.data.source.local.entity.OwnerRealm
import id.mufiid.realmproject.core.data.source.local.entity.PetRealm
import id.mufiid.realmproject.core.data.source.local.entity.toDomain
import id.mufiid.realmproject.core.domain.model.Pet
import id.mufiid.realmproject.core.domain.model.toRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers.IO

class PetLocalDataSource(private val config: RealmConfiguration) {
    private fun getRealm() = Realm.getInstance(config)

    suspend fun insertPet(pet: Pet) {
        getRealm().executeTransactionAwait(IO) { transaction ->
            transaction.insertOrUpdate(pet.toRealm())
        }
    }

    suspend fun retrievePetsToAdopt(): List<Pet> {
        val petsToAdopt = mutableListOf<Pet>()
        getRealm().executeTransactionAwait(IO) { transaction ->
            petsToAdopt.addAll(
                transaction.where(PetRealm::class.java)
                    .equalTo("isAdopted", false)
                    .findAll()
                    .map { it.toDomain() }
            )
        }
        return petsToAdopt
    }

    suspend fun updatePet(petId: String, ownerId: String) {
        getRealm().executeTransactionAwait(IO) { transaction ->
            val pet = transaction.where(PetRealm::class.java)
                .equalTo("id", petId)
                .findFirst()

            val owner = transaction.where(OwnerRealm::class.java)
                .equalTo("id", ownerId)
                .findFirst()

            pet?.isAdopted = true
            owner?.pets?.add(pet)
        }
    }

    suspend fun removePet(petId: String) {
        getRealm().executeTransactionAwait(IO) { transaction ->
            val petToRemove = transaction.where(PetRealm::class.java)
                .equalTo("id", petId)
                .findFirst()
            petToRemove?.deleteFromRealm()
        }
    }
}
package id.mufiid.realmproject.core.domain.model

import id.mufiid.realmproject.core.data.source.local.entity.PetRealm

data class Pet(
    val id: String,
    val name: String,
    val age: Int,
    val petType: String = "",
    val isAdopted: Boolean = false,
    val ownerName: String? = null
)

fun Pet.toRealm() = PetRealm(
    id, name, petType, age, isAdopted
)

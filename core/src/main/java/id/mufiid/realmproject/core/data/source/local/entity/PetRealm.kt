package id.mufiid.realmproject.core.data.source.local.entity

import androidx.annotation.DrawableRes
import id.mufiid.realmproject.core.domain.model.Pet
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import org.bson.types.ObjectId

open class PetRealm(
    @PrimaryKey
    var id: String = ObjectId().toHexString(),

    @Required
    var name: String = "",

    @Required
    var petType: String = "",

    var age: Int = 0,

    var isAdopted: Boolean = false,

    // one to one relationship
    @LinkingObjects("pets")
    val owner: RealmResults<OwnerRealm>? = null
): RealmObject()

fun PetRealm.toDomain() = Pet(
    id, name, age, petType, isAdopted
)
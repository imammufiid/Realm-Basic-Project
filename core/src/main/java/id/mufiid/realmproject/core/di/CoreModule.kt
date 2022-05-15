package id.mufiid.realmproject.core.di

import id.mufiid.realmproject.core.data.repository.MainRepository
import id.mufiid.realmproject.core.data.source.local.PetLocalDataSource
import id.mufiid.realmproject.core.domain.repository.IMainRepository
import io.realm.RealmConfiguration
import org.koin.dsl.module

private const val realmVersion = 1L
val databaseModule = module {
    single {
        RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            // .migration()
            .build()
    }
}

val localDataSourceModule = module {
    single { PetLocalDataSource(get()) }
}

val repositoryModule = module {
    single<IMainRepository> { MainRepository(get()) }
}
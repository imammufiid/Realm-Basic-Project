package id.mufiid.realmproject

import android.app.Application
import id.mufiid.realmproject.core.di.databaseModule
import id.mufiid.realmproject.core.di.localDataSourceModule
import id.mufiid.realmproject.core.di.realmDaoModule
import id.mufiid.realmproject.core.di.repositoryModule
import id.mufiid.realmproject.di.viewModelModules
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MainApplication)
            modules(
                listOf(
                    viewModelModules,
                    databaseModule,
                    realmDaoModule,
                    localDataSourceModule,
                    repositoryModule
                )
            )
        }
    }
}
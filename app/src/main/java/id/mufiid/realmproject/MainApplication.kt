package id.mufiid.realmproject

import android.app.Application
import id.mufiid.realmproject.core.di.databaseModule
import id.mufiid.realmproject.core.di.localDataSourceModule
import id.mufiid.realmproject.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

            startKoin {
                androidLogger(Level.NONE)
                androidContext(this@MainApplication)
                modules(
                    listOf(
                        databaseModule,
                        localDataSourceModule,
                        repositoryModule
                    )
                )
            }
    }
}
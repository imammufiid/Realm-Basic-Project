package id.mufiid.realmproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import id.mufiid.realmproject.core.domain.repository.IMainRepository

class MainViewModel(private val mainRepository: IMainRepository): ViewModel() {
    val pets = mainRepository.getPets().asLiveData()
}
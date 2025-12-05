package com.example.roomdatabase_192.viewmodel.provider



import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.roomdatabase_192.repositori.AplikasiSiswa
import com.example.roomdatabase_192.viewmodel.DetailViewModel
import com.example.roomdatabase_192.viewmodel.EditViewModel
import com.example.roomdatabase_192.viewmodel.EntryViewModel
import com.example.roomdatabase_192.viewmodel.HomeViewModel

object PenyediaViewModel {

    val Factory = viewModelFactory{
        initializer {
            HomeViewModel(aplikasiSiswa().container.repositorySiswa)
        }

        initializer {
            EntryViewModel(aplikasiSiswa().container.repositorySiswa)
        }

        initializer {
            DetailViewModel(savedStateHandle = this.createSavedStateHandle(),
                repositoriSiswa = aplikasiSiswa().container.repositorySiswa)
        }

        initializer {
            EditViewModel(this.createSavedStateHandle(), aplikasiSiswa().container.repositorySiswa)
        }
    }

}

fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory
        .APPLICATION_KEY] as AplikasiSiswa)
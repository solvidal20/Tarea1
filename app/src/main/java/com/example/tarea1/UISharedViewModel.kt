package com.example.tarea1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UISharedViewModel : ViewModel() {
    private val _textoUsuario = MutableLiveData("")
    val textoUsuario: LiveData<String> get() = _textoUsuario

    private val _cargando = MutableLiveData(false)
    val cargando: LiveData<Boolean> get() = _cargando

    fun setTextoUsuario(s: String) { _textoUsuario.value = s }
    fun setCargando(b: Boolean) { _cargando.value = b }
}

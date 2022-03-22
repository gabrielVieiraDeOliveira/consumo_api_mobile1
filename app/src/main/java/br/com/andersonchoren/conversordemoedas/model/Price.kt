package br.com.andersonchoren.conversordemoedas.model

import androidx.databinding.*

class Price {
    private var value = ObservableField<String>()

    fun getValue() = this.value

    fun setValue(value: String){
        this.value.set(value)
    }
}
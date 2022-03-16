package br.com.andersonchoren.conversordemoedas.model

interface IObserver {
    fun updateUI(data: MutableMap<String, Double>)
}
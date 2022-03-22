package br.com.andersonchoren.conversordemoedas.repository

import android.content.Context
import android.util.Log
import br.com.andersonchoren.conversordemoedas.model.IObserver
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RateAPI {
    fun getcurrency(
        context: Context,
        observer: IObserver,
        cepDigitation: String
    ){
        val url = "https://viacep.com.br/ws/${cepDigitation}/json/"
        val queue = Volley.newRequestQueue(context)
        val stringReq = StringRequest(
            Request.Method.GET,
            url,
            {
                result -> val jsonObject = JSONObject(result)
                val cepValue = jsonObject.getString("cep")
                val logradouroValue = jsonObject.getString("logradouro")
                val bairroValue = jsonObject.getString("bairro")
                val localidadeValue = jsonObject.getString("localidade")
                val ufValue = jsonObject.getString("uf")

                val map = mutableMapOf<String, Any>()
                map["cep"] = cepValue
                map["logradouro"] = logradouroValue
                map["bairro"] = bairroValue
                map["localidade"] = localidadeValue
                map["uf"] = ufValue

                observer.updateUI(map)
            },
            {
                Log.e("APPDEBUG", "Erro!!!")
            }
        )
        queue.add(stringReq)
    }
}
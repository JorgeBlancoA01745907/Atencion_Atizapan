package mx.itesm.aa.atencionatizapan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.LluviaAPI
import mx.itesm.aa.atencionatizapan.model.LluviaData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LluviaViewModel : ViewModel() {
    // Modelo
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://localhost/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val lluviaAPI by lazy {
        retrofit.create(LluviaAPI::class.java)
    }

    //Observables
    val listaEventos = MutableLiveData<List<LluviaData>>()

    //Interfaz
    fun descargarDatosEventos() {
        val call = lluviaAPI.descargarDatosLluvia()
        call.enqueue(object: Callback<List<LluviaData>> {
            override fun onResponse(call: Call<List<LluviaData>>, response: Response<List<LluviaData>>) {
                if (response.isSuccessful) {
                    println("Lista de paises: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaEventos.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<LluviaData>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}
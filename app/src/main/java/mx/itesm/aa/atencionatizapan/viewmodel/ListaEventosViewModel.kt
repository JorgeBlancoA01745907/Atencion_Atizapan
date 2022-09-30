package mx.itesm.aa.atencionatizapan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.EventoAPI
import mx.itesm.aa.atencionatizapan.model.EventoData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaEventosViewModel : ViewModel() {
    // Modelo
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://localhost/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val EventoAPI by lazy {
        retrofit.create(EventoAPI::class.java)
    }

    //Observables
    val listaEventos = MutableLiveData<List<EventoData>>()

    //Interfaz
    fun descargarDatosEventos() {
        val call = EventoAPI.descargarDatosEventos()
        call.enqueue(object: Callback<List<EventoData>> {
            override fun onResponse(call: Call<List<EventoData>>, response: Response<List<EventoData>>) {
                if (response.isSuccessful) {
                    println("Lista de paises: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaEventos.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<EventoData>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }


}
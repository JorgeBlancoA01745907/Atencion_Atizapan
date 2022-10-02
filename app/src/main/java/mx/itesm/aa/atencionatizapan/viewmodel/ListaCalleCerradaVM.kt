package mx.itesm.aa.atencionatizapan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.CalleCerradaData
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.LluviaData
import mx.itesm.aa.atencionatizapan.model.interfaces.ServicioCalleCAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaCalleCerradaVM : ViewModel() {
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://143.110.228.198/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioCalleCAPI by lazy {
        retrofit.create(ServicioCalleCAPI::class.java)
    }

    //Observables
    val listaCalleC = MutableLiveData<List<CalleCerradaData>>()

    //Interfaz
    fun descargarDatosCalleCerrada() {
        val call = servicioCalleCAPI.descargarDatosCalleCerrada()
        call.enqueue(object: Callback<List<CalleCerradaData>> {
            override fun onResponse(call: Call<List<CalleCerradaData>>, response: Response<List<CalleCerradaData>>) {
                if (response.isSuccessful) {
                    listaCalleC.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<CalleCerradaData>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}
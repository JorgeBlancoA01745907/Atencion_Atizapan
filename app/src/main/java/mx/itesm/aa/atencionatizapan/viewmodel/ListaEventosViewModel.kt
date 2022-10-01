package mx.itesm.aa.atencionatizapan.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.EventoData
import mx.itesm.aa.atencionatizapan.model.interfaces.ListaEventos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListaEventosViewModel : ViewModel() {
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://143.110.228.198/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val listaEventos by lazy {
        retrofit.create(ListaEventos::class.java)
    }

    //Observables
    val listaPaises = MutableLiveData<List<EventoData>>()

    //Interfaz
    fun descargarDatosPaises() {
        val call = listaEventos.descargarDatosEventos()
        call.enqueue(object: Callback<List<EventoData>> {
            override fun onResponse(call: Call<List<EventoData>>, response: Response<List<EventoData>>) {
                if (response.isSuccessful) {
                    println("Lista de paises: ${response.body()}")
                    // Avisar a la vista (adaptador) que hay datos nuevos
                    listaPaises.value = response.body()
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
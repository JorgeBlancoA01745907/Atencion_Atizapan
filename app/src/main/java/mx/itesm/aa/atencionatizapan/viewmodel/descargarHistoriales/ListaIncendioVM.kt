package mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.IncendioData
import mx.itesm.aa.atencionatizapan.model.interfaces.ServicioIncendioAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** @author:
 *  ViewModel de lista incendio
 */

class ListaIncendioVM : ViewModel() {
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://143.110.228.198/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioIncendioAPI by lazy {
        retrofit.create(ServicioIncendioAPI::class.java)
    }

    //Observables
    val listaIncendio = MutableLiveData<List<IncendioData>>()

    //Interfaz
    fun descargarDatosIncendio() {
        val call = servicioIncendioAPI.descargarDatosIncendio()
        call.enqueue(object: Callback<List<IncendioData>> {
            override fun onResponse(call: Call<List<IncendioData>>, response: Response<List<IncendioData>>) {
                if (response.isSuccessful) {
                    listaIncendio.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<IncendioData>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}
package mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import mx.itesm.aa.atencionatizapan.model.interfaces.ServicioInundacionAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** @author:
 *  ViewModel de Inundación
 */

class ListaInundacionVM : ViewModel() {
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://143.110.228.198/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioInundacionAPI by lazy {
        retrofit.create(ServicioInundacionAPI::class.java)
    }

    //Observables
    val listaInundacion = MutableLiveData<List<InundacionData>>()

    //Interfaz
    fun descargarDatosInundacion() {
        val call = servicioInundacionAPI.descargarDatosInundacion()
        call.enqueue(object: Callback<List<InundacionData>> {
            override fun onResponse(call: Call<List<InundacionData>>, response: Response<List<InundacionData>>) {
                if (response.isSuccessful) {
                    listaInundacion.value = response.body()
                } else {
                    println("Error en los datos: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<InundacionData>>, t: Throwable) {
                println("Error en la descarga: ${t.localizedMessage}")
            }
        })
    }
}
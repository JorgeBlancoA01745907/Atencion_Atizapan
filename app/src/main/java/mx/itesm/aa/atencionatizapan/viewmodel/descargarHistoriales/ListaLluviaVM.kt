package mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.LluviaData
import mx.itesm.aa.atencionatizapan.model.interfaces.ServicioLluviaAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  ViewModel para el historial de lluvias
 */
class ListaLluviaVM : ViewModel() {
    private val retrofit by lazy {  // El objeto retrofit para instanciar el objeto que se conecta a la red y accede a los servicios definidos
        Retrofit.Builder()
            .baseUrl("http://143.110.228.198/") //pagina base
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Instancia que crea el objeto que realiza la descarga
    private val servicioLluviaAPI by lazy {
        retrofit.create(ServicioLluviaAPI::class.java)
    }

    //Observables
    val listaLluvia = MutableLiveData<List<LluviaData>>()

    /**
     * Utiliza la interfaz para descargar la lista de eventos de lluvias
     * @param ninguno
     * @return ninguno
     */
    fun descargarDatosLluvia() {
        val call = servicioLluviaAPI.descargarDatosLluvia()
        call.enqueue(object: Callback<List<LluviaData>> {
            override fun onResponse(call: Call<List<LluviaData>>, response: Response<List<LluviaData>>) {
                if (response.isSuccessful) {
                    listaLluvia.value = response.body()
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
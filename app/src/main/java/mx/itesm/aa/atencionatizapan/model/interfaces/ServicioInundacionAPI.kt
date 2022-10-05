package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import retrofit2.Call
import retrofit2.http.GET

/** @author: Eduardo Joel Cortez Valente
 * Interfaz que descarga los datos de inundaciones
 */

interface ServicioInundacionAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/inundacion.php")
    fun descargarDatosInundacion(): Call<List<InundacionData>>
}
package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import retrofit2.Call
import retrofit2.http.GET

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 * Interfaz que descarga los datos de inundaciones
 */

interface ServicioInundacionAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/inundacion.php")
    fun descargarDatosInundacion(): Call<List<InundacionData>>
}
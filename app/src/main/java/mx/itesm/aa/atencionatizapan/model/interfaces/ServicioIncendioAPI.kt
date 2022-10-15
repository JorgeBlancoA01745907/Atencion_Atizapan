package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.IncendioData
import retrofit2.Call
import retrofit2.http.GET

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 * Interfaz que descarga los datos de los incendios
 */

interface ServicioIncendioAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/incendio.php")
    fun descargarDatosIncendio(): Call<List<IncendioData>>
}
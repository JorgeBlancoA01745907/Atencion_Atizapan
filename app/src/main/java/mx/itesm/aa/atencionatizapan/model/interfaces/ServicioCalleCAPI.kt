package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.CalleCerradaData
import retrofit2.Call
import retrofit2.http.GET

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 * Interfaz que descarga los datos de las calles cerradas
 */
interface ServicioCalleCAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/calle.php")
    fun descargarDatosCalleCerrada(): Call<List<CalleCerradaData>>
}
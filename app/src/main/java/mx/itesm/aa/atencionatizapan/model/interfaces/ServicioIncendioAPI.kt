package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.IncendioData
import retrofit2.Call
import retrofit2.http.GET

interface ServicioIncendioAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/incendio.php")
    fun descargarDatosIncendio(): Call<List<IncendioData>>
}
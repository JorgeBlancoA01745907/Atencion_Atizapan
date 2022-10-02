package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import retrofit2.Call
import retrofit2.http.GET

interface ServicioInundacionAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/inundacion.php")
    fun descargarDatosInundacion(): Call<List<InundacionData>>
}
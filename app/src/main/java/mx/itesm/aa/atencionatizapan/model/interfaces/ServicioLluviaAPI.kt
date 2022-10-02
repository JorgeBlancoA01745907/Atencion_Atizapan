package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.LluviaData
import retrofit2.Call
import retrofit2.http.GET

interface ServicioLluviaAPI {
    @GET("/Atencion-Atizapan-Web/JSONS/lluvia.php")
    fun descargarDatosLluvia(): Call<List<LluviaData>>
}
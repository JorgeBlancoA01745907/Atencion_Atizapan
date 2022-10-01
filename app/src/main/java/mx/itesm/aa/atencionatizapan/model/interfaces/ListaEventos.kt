package mx.itesm.aa.atencionatizapan.model.interfaces

import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.EventoData
import retrofit2.Call
import retrofit2.http.GET

interface ListaEventos {
    @GET("/Atencion-Atizapan-Web/json.php")
    fun descargarDatosEventos(): Call<List<EventoData>>
}
package mx.itesm.aa.atencionatizapan.model

import retrofit2.Call
import retrofit2.http.GET

interface ListaEventos {
    @GET("/Atencion-Atizapan-Web/json.php")
    fun descargarDatosEventos(): Call<List<EventoData>>
}
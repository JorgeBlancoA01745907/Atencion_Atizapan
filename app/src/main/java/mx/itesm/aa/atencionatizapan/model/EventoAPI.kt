package mx.itesm.aa.atencionatizapan.model

import retrofit2.Call

interface EventoAPI {
    // @GET()
    fun descargarDatosEventos(): Call<List<EventoData>>
}
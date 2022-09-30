package mx.itesm.aa.atencionatizapan.model

import retrofit2.Call

interface LluviaAPI {
    // @GET()  se pone el endpoint de URL
    fun descargarDatosLluvia(): Call<List<LluviaData>>
}
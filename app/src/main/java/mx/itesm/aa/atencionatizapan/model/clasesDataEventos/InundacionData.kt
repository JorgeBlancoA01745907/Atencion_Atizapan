package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

import com.google.gson.annotations.SerializedName

data class InundacionData(
    @SerializedName("ID_inundacion")
    val idInundacion: Int,
    @SerializedName("CALLE")
    val calle: String,
    @SerializedName("CP")
    val cp: String,
    @SerializedName("COLONIA")
    val colonia: String,
    @SerializedName("FECHA")
    val fecha: String,
    @SerializedName("HORA")
    val hora: String
)

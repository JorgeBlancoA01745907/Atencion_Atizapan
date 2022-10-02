package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

import com.google.gson.annotations.SerializedName

data class CalleCerradaData(
    @SerializedName("ID_calleC")
    val idCalleCerrada: Int,
    @SerializedName("CALLE")
    val calle: String,
    @SerializedName("CP")
    val cp: String,
    @SerializedName("COLONIA")
    val colonia: String,
    @SerializedName("TIEMPO")
    val tiempo: Double,
    @SerializedName("FECHA")
    val fecha: String,
    @SerializedName("HORA")
    val hora: String
)

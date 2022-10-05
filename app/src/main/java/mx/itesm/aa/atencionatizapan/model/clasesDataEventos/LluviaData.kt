package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/** @author: Jose Luis Madrigal
 * Data class que establece los datos de la clase lluvia
 */

data class LluviaData(
    @SerializedName("ID_lluvia")
    val idLluvia: Int,
    @SerializedName("Humedad")
    val humedad: Double,
    @SerializedName("Volumen")
    val volumen: Double,
    @SerializedName("Viento")
    val viento: Double,
    @SerializedName("Temperatura")
    val temperatura: Double,
    @SerializedName("FECHA")
    val fecha: String,
    @SerializedName("HORA")
    val hora: String
) : Serializable

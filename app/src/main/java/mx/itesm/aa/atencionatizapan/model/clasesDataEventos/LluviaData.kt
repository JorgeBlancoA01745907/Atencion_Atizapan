package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 * Clase que establece los atributos del evento Lluvia
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

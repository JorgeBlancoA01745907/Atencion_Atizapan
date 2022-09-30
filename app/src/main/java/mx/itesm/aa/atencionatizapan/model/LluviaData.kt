package mx.itesm.aa.atencionatizapan.model

data class LluviaData(
    val idLluvia: Int,
    val humedad: Double,
    val volumen: Double,
    val viento: Double,
    val temperatura: Double,
    val fecha: String,
    val hora: String
)

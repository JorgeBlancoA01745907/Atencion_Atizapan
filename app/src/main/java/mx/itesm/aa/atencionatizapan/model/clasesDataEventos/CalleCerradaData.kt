package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

data class CalleCerradaData(
    val idCalleCerrada: Int,
    val calle: String,
    val cp: String,
    val colonia: String,
    val tiempo: Double,
    val fecha: String,
    val hora: String
)

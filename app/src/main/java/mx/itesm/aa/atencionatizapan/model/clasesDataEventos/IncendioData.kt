package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

data class IncendioData(
    val idIncendio: Int,
    val calle: String,
    val cp: String,
    val colonia: String,
    val fecha: String,
    val hora: String
)

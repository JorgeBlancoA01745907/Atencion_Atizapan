package mx.itesm.aa.atencionatizapan.model.clasesDataEventos

data class EventoData(
    //@SerializedName("Evento")
    val evento: String,
    val info: Map<String, String> = mapOf()
)

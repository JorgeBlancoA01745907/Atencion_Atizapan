package mx.itesm.aa.atencionatizapan.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.model.EventoData
import mx.itesm.aa.atencionatizapan.model.LluviaData

class AdaptadorLluvia(val context: Context,
                      var arrEventos: Array<LluviaData>):
    RecyclerView.Adapter<AdaptadorLluvia.RenglonEvento>() {


    // Una vista para un renglon
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonEvento {
        val vista = LayoutInflater.from(context).inflate(
            R.layout.renglon_evento,
            parent, false)
        return RenglonEvento(vista)
    }

    // Poblar la vista (renglon) con los datos del indice 'position'
    override fun onBindViewHolder(holder: RenglonEvento, position: Int) {
        val evento = arrEventos[position]
        holder.set(evento)
    }

    // El numero de renglones que tendra el recyclerview
    override fun getItemCount(): Int {
        return arrEventos.size
    }

    class RenglonEvento(var renglonEvento: View) : RecyclerView.ViewHolder(renglonEvento)
    {
        fun set(evento: LluviaData) {
            val tipoEvento = renglonEvento.findViewById<TextView>(R.id.tituloEvento)
            val fechaEvento = renglonEvento.findViewById<TextView>(R.id.fechaEvento)
            val horaEvento = renglonEvento.findViewById<TextView>(R.id.horaEvento)
            tipoEvento.text = evento.volumen.toString()
            fechaEvento.text = evento.fecha
            horaEvento.text = evento.hora

        }

    }
}
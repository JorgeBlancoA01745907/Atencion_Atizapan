package mx.itesm.aa.atencionatizapan.view.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.CalleCerradaData


class AdaptadorCalleCerrada (val context: Context,
                             var arrEventos: Array<CalleCerradaData>):
    RecyclerView.Adapter<AdaptadorCalleCerrada.RenglonEvento>() {


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
        fun set(evento: CalleCerradaData) {
            val tituloEvento = renglonEvento.findViewById<TextView>(R.id.tituloEvento)
            val fechaEvento = renglonEvento.findViewById<TextView>(R.id.fechaEvento)
            val horaEvento = renglonEvento.findViewById<TextView>(R.id.horaEvento)
            tituloEvento.text = "Calle: " + evento.calle
            fechaEvento.text = "Fecha: " + evento.fecha
            horaEvento.text = "Hora: " + evento.hora

        }

    }
}
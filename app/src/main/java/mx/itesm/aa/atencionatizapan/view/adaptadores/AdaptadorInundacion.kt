package mx.itesm.aa.atencionatizapan.view.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import mx.itesm.aa.atencionatizapan.model.interfaces.ListenerRecycler

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Adaptador que recibe los datos de inundaciones y genera un renglon por cada evento.
 */
class AdaptadorInundacion (val context: Context,
                           var arrEventos: Array<InundacionData>,
                           var listener: ListenerRecycler? = null):
    RecyclerView.Adapter<AdaptadorInundacion.RenglonEvento>() {

    /**
     * Obtiene la vista para un renglon
     * @param padre, tipo de vista
     * @return vista de renglon
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonEvento {
        val vista = LayoutInflater.from(context).inflate(
            R.layout.renglon_evento,
            parent, false)
        return RenglonEvento(vista)
    }

    /**
     * Pobla la vista de un renglon con los datos del indice de la posicion
     * @param renglon del evento, posicion
     * @return ninguno
     */
    override fun onBindViewHolder(holder: RenglonEvento, position: Int) {
        val evento = arrEventos[position]
        holder.set(evento)

        holder.renglonEvento.setOnClickListener {
            listener?.itemClicked(position)
        }
    }

    /**
     * Determina el numero de renglones que tendra el recyclerview
     * @param ninguno
     * @return tamaño del arreglo (num renglones)
     */
    override fun getItemCount(): Int {
        return arrEventos.size
    }

    /**
     * Establece la colocacion de los renglones con sus datos en el recyclerview
     * @param vista de un renglon
     * @return renglon en recyclerview
     */
    class RenglonEvento(var renglonEvento: View) : RecyclerView.ViewHolder(renglonEvento)
    {
        /**
         * Establece los datos a mostrar en los atributos del renglon.
         * @param un evento de inundacion
         * @return ninguno
         */
        fun set(evento: InundacionData) {
            val tituloEvento = renglonEvento.findViewById<TextView>(R.id.tituloEvento)
            val fechaEvento = renglonEvento.findViewById<TextView>(R.id.fechaEvento)
            val horaEvento = renglonEvento.findViewById<TextView>(R.id.horaEvento)
            tituloEvento.text = "Calle: " + evento.calle
            fechaEvento.text = "Fecha: " + evento.fecha
            horaEvento.text = "Hora: " + evento.hora

        }

    }
}
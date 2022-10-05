package mx.itesm.aa.atencionatizapan.view.fragmentos.historiales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.aa.atencionatizapan.databinding.FragmentCalleCerradaBinding
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.CalleCerradaData
import mx.itesm.aa.atencionatizapan.model.interfaces.ListenerRecycler
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorCalleCerrada
import mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales.ListaCalleCerradaVM

/** @author: Eduardo Joel Cortez Valente
 * Fragmento que representa la pantalla con el historial de calle cerrada
 */


class CalleCerradaFrag : Fragment(), ListenerRecycler {

    private lateinit var binding: FragmentCalleCerradaBinding

    private val calleCerradaVM: ListaCalleCerradaVM by viewModels()

    private lateinit var adaptador: AdaptadorCalleCerrada

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_costo, container, false)
        binding = FragmentCalleCerradaBinding.inflate(layoutInflater)
        return binding.root
    }


    //Los componentes graficos YA EXISTEN
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRV()
    }

    override fun onStart() {
        super.onStart()
        calleCerradaVM.descargarDatosCalleCerrada()
        configurarObservables()
    }

    private fun configurarObservables() {
        calleCerradaVM.listaCalleC.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    private fun configurarRV() {
        val arrEventos = arrayOf(CalleCerradaData(5, "Prado", "152674", "Echegaray", 1.5, "15/03/2022", "15:02:25"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorCalleCerrada(requireContext(), arrEventos)
        adaptador?.listener = this
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout
        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }

    override fun itemClicked(position: Int) {
        val callecerrada = adaptador.arrEventos[position]
        val accion = CalleCerradaFragDirections.actionCalleCerradaFragToInfoCalleFragment(callecerrada)
        findNavController().navigate(accion)
    }

}
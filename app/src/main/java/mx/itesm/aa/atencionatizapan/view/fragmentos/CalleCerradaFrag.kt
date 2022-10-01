package mx.itesm.aa.atencionatizapan.view.fragmentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentCalleCerradaBinding
import mx.itesm.aa.atencionatizapan.databinding.FragmentIncendioBinding
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.CalleCerradaData
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.IncendioData
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorCalleCerrada
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorIncendio
import mx.itesm.aa.atencionatizapan.viewmodel.CalleCerradaViewModel
import mx.itesm.aa.atencionatizapan.viewmodel.IncendioViewModel

class CalleCerradaFrag : Fragment() {

    private lateinit var binding: FragmentCalleCerradaBinding

    private val calleCerradaVM: CalleCerradaViewModel by viewModels()

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
        //lluviaVM.descargarDatosEventos()
        //configurarObservables()
    }

    /*private fun configurarObservables() {
        lluviaVM.listaEventos.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }*/

    private fun configurarRV() {
        val arrEventos = arrayOf(CalleCerradaData(5, "Prado", "152674", "Echegaray", 1.5, "15/03/2022", "15:02:25"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorCalleCerrada(requireContext(), arrEventos)
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout
        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }

}
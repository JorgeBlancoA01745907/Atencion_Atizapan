package mx.itesm.aa.atencionatizapan.view.fragmentos.historiales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.aa.atencionatizapan.databinding.FragmentIncendioBinding
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.IncendioData
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorIncendio
import mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales.ListaIncendioVM

class IncendioFrag : Fragment() {

    private lateinit var binding: FragmentIncendioBinding

    private val incendioVM: ListaIncendioVM by viewModels()

    private lateinit var adaptador: AdaptadorIncendio

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_costo, container, false)
        binding = FragmentIncendioBinding.inflate(layoutInflater)
        return binding.root
    }


    //Los componentes graficos YA EXISTEN
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRV()
    }

    override fun onStart() {
        super.onStart()
        incendioVM.descargarDatosIncendio()
        configurarObservables()
    }

    private fun configurarObservables() {
        incendioVM.listaIncendio.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    private fun configurarRV() {
        val arrEventos = arrayOf(IncendioData(2, "Monte", "250315", "Pastores", "04/06/2022", "12:08:27"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorIncendio(requireContext(), arrEventos)
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout
        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }

}
package mx.itesm.aa.atencionatizapan.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.aa.atencionatizapan.databinding.ActivityMainBinding
import mx.itesm.aa.atencionatizapan.databinding.FragmentLluviaBinding
import mx.itesm.aa.atencionatizapan.databinding.HistorialBinding
import mx.itesm.aa.atencionatizapan.model.EventoData
import mx.itesm.aa.atencionatizapan.viewmodel.ListaEventosViewModel


class HistorialView : Fragment() {
    // binding
    private lateinit var binding: HistorialBinding

    //view model
    private val viewModel: ListaEventosViewModel by viewModels()

    // adaptador
    private lateinit var adaptador : AdaptadorHistorial

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_principal, container, false)
        //3
        binding = HistorialBinding.inflate(layoutInflater)
        return binding.root
    }

    //Los componentes graficos YA EXISTEN
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
        configurarRV()
    }

    private fun configurarObservables() {
        viewModel.listaEventos.observe(viewLifecycleOwner){lista ->
            val arrPaises = lista.toTypedArray()
            adaptador.arrEventos = arrPaises //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.descargarDatosEventos()
    }

    private fun configurarRV() {
        val arrEventos = arrayOf(EventoData("Lluvia", "12/02/2022", "13:02:14"), EventoData("Incendio", "04/10/2022", "17:40:05"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorHistorial(requireContext(), arrEventos)
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout

        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }




}
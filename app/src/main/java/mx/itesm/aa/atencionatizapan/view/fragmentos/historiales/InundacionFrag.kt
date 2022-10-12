package mx.itesm.aa.atencionatizapan.view.fragmentos.historiales

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import mx.itesm.aa.atencionatizapan.databinding.FragmentInundacionBinding
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.InundacionData
import mx.itesm.aa.atencionatizapan.model.interfaces.ListenerRecycler
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorInundacion
import mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales.ListaInundacionVM
/** @author: Eduardo Joel Cortez Valente
 * Fragmento que representa la pantalla con el historial de inundación
 */

class InundacionFrag : Fragment(), ListenerRecycler {

    private lateinit var binding: FragmentInundacionBinding

    private val inundacionVM: ListaInundacionVM by viewModels()

    private lateinit var adaptador: AdaptadorInundacion

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_costo, container, false)
        binding = FragmentInundacionBinding.inflate(layoutInflater)
        return binding.root
    }


    //Los componentes graficos YA EXISTEN
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRV()
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    override fun onStart() {
        super.onStart()
        inundacionVM.descargarDatosInundacion()
        configurarObservables()
    }

    private fun configurarObservables() {
        inundacionVM.listaInundacion.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    private fun configurarRV() {
        val arrEventos = arrayOf(InundacionData(8, "Alborada", "153678", "Esmeralda", "15/08/2022", "14:25:06"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorInundacion(requireContext(), arrEventos)
        adaptador?.listener = this
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout
        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }

    override fun itemClicked(position: Int) {
        val inundacion = adaptador.arrEventos[position]
        val accion = InundacionFragDirections.actionInundacionFragToInfoInundacionFragment(inundacion)
        findNavController().navigate(accion)
    }
}
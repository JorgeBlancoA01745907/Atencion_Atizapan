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
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentLluviaBinding
import mx.itesm.aa.atencionatizapan.model.clasesDataEventos.LluviaData
import mx.itesm.aa.atencionatizapan.model.interfaces.ListenerRecycler
import mx.itesm.aa.atencionatizapan.view.adaptadores.AdaptadorLluvia
import mx.itesm.aa.atencionatizapan.viewmodel.descargarHistoriales.ListaLluviaVM

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Fragmento que representa el historial de lluvias
 */
class LluviaFrag : Fragment(), ListenerRecycler {

    private lateinit var binding: FragmentLluviaBinding

    private val lluviaVM: ListaLluviaVM by viewModels()

    private lateinit var adaptador: AdaptadorLluvia

    /**
     * Crea los componentes graficos
     * @param inflater, contenedor, instancia del estado
     * @return vista con los componentes
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_costo, container, false)
        binding = FragmentLluviaBinding.inflate(layoutInflater)
        return binding.root


    }

    /**
     * Modifica recyclerview y corre animacion de fondo al tener componentes creados
     * @param vista, instancia de estado
     * @return ninguno
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarRV()
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    /**
     * Descarga datos y verifica observables al iniciar aplicacion
     * @param ninguno
     * @return ninguno
     */
    override fun onStart() {
        super.onStart()
        lluviaVM.descargarDatosLluvia()
        configurarObservables()
    }

    /**
     * Configura los observables de los eventos de lluvias
     * @param ninguno
     * @return ninguno
     */
    private fun configurarObservables() {
        lluviaVM.listaLluvia.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    /**
     * Actualiza recyclerview con los eventos de lluvias observados
     * @param ninguno
     * @return ninguno
     */
    private fun configurarRV() {
        val arrEventos = arrayOf(LluviaData(1, 3.11, 4.1, 2.1, 2.1, "17/02/2022", "02:32:02"))
        val layout = LinearLayoutManager(requireContext())
        //ya no se declara adaptador porque ya es una variable de instancia
        adaptador = AdaptadorLluvia(requireContext(), arrEventos)
        adaptador?.listener = this
        binding.rvEventos.adapter = adaptador
        binding.rvEventos.layoutManager = layout
        // Separador (linea con orientacion de rv)
        val separador = DividerItemDecoration(requireContext(), layout.orientation)
        binding.rvEventos.addItemDecoration(separador)
    }

    /**
     * Cambia a pantalla de informacion usando los datos del renglon presionado
     * @param posicion del renglon
     * @return ninguno
     */
    override fun itemClicked(position: Int) {
        val lluvia = adaptador.arrEventos[position]
        val accion = LluviaFragDirections.actionLluviaFragToInfoLluviaFragment(lluvia)
        findNavController().navigate(accion)
    }

}
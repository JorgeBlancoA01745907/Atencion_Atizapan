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

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Fragmento que representa el historial de inundaciones
 */
class InundacionFrag : Fragment(), ListenerRecycler {

    private lateinit var binding: FragmentInundacionBinding

    private val inundacionVM: ListaInundacionVM by viewModels()

    private lateinit var adaptador: AdaptadorInundacion

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
        binding = FragmentInundacionBinding.inflate(layoutInflater)
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
        inundacionVM.descargarDatosInundacion()
        configurarObservables()
    }

    /**
     * Configura los observables de los eventos de inundaciones
     * @param ninguno
     * @return ninguno
     */
    private fun configurarObservables() {
        inundacionVM.listaInundacion.observe(viewLifecycleOwner){lista ->
            val arrEventos = lista.toTypedArray()
            adaptador.arrEventos = arrEventos //se cambia la fuente de datos
            adaptador.notifyDataSetChanged() // RECARGA todo
        }
    }

    /**
     * Actualiza recyclerview con los eventos de inundaciones observados
     * @param ninguno
     * @return ninguno
     */
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

    /**
     * Cambia a pantalla de informacion usando los datos del renglon presionado
     * @param posicion del renglon
     * @return ninguno
     */
    override fun itemClicked(position: Int) {
        val inundacion = adaptador.arrEventos[position]
        val accion = InundacionFragDirections.actionInundacionFragToInfoInundacionFragment(inundacion)
        findNavController().navigate(accion)
    }
}
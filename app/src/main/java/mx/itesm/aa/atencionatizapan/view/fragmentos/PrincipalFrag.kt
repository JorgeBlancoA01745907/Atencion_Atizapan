package mx.itesm.aa.atencionatizapan.view.fragmentos

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentPrincipalBinding
import mx.itesm.aa.atencionatizapan.viewmodel.PrincipalViewModel

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Vista del fragmento principal
 */
class PrincipalFrag : Fragment() {

    /* companion object {
        fun newInstance() = PrincipalFrag()
    } */

    private lateinit var viewModel: PrincipalViewModel

    private lateinit var binding: FragmentPrincipalBinding

    /**
     * Crea los componentes graficos
     * @param inflater, contenedor, instancia de estado
     * @return vista con los componentes
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_costo, container, false)
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Registra eventos y corre animacion de fondo al tener componentes creados
     * @param vista, instancia de estado
     * @return ninguno
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    /**
     * Navega a pantalla de historial especifico dependiendo de la seleccion del boton
     */
    private fun registrarEventos() {
        binding.ibLluvia.setOnClickListener {
            val accion = R.id.action_principalFrag_to_lluviaFrag
            findNavController().navigate(accion)
        }
        binding.ibCalle.setOnClickListener {
            val accion = R.id.action_principalFrag_to_calleCerradaFrag
            findNavController().navigate(accion)
        }
        binding.ibInundacion.setOnClickListener {
            val accion = R.id.action_principalFrag_to_inundacionFrag
            findNavController().navigate(accion)
        }
        binding.ibIncendio.setOnClickListener {
            val accion = R.id.action_principalFrag_to_incendioFrag
            findNavController().navigate(accion)
        }
    }

}
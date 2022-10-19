package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoCalleViewModel
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoCalleBinding

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Fragmento que muestra la informacion detalla de un evento de calle cerrada seleccionado
 */
class InfoCalleFragment : Fragment() {

    private lateinit var binding: FragmentInfoCalleBinding

    private lateinit var viewModel: InfoCalleViewModel

    private val args: InfoCalleFragmentArgs by navArgs()

    /**
     * Crea los componentes graficos
     * @param inflater, contenedor, instancia de estado
     * @return vista con los componentes
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoCalleBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * Verifica observables y corre animacion de fondo al tener componentes creados
     * @param vista, instancia de estado
     * @return ninguno
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val constraintLayout2: LinearLayout = binding.linearLayout2
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        val animationDrawable2: AnimationDrawable = constraintLayout2.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        animationDrawable2.setEnterFadeDuration(2500)
        animationDrawable2.setExitFadeDuration(5000)
        animationDrawable2.start()
    }

    /**
     * Revisa los atributos observables del evento seleccionado y los muestra en los componentes.
     * @param ninguno
     * @return ninguno
     */
    private fun configurarObservables() {
        val calle = args.callecerrada.calle
        val cp = args.callecerrada.cp
        val colonia = args.callecerrada.colonia
        val tiempo = args.callecerrada.tiempo
        val fecha = args.callecerrada.fecha
        val hora = args.callecerrada.hora

        binding.infoCalleCalle.text = " $calle"
        binding.infoCPCalle.text = " $cp"
        binding.infoColoniaCalle.text = " $colonia"
        binding.infoTiempoCalle.text = " ${tiempo.toString()} horas"
        binding.infoFechaCalle.text = " $fecha"
        binding.infoHoraCalle.text = " $hora"

    }

}
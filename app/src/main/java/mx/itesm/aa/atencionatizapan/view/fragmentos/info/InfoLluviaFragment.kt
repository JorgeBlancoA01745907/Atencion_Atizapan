package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoLluviaViewModel
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoLluviaBinding

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Fragmento que muestra la informacion detalla de un evento de lluvia seleccionado
 */
class InfoLluviaFragment : Fragment() {

    private lateinit var binding: FragmentInfoLluviaBinding

    private lateinit var viewModel: InfoLluviaViewModel

    private val args: InfoLluviaFragmentArgs by navArgs()

    /**
     * Crea los componentes graficos
     * @param inflater, contenedor, instancia de estado
     * @return vista con los componentes
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoLluviaBinding.inflate(layoutInflater)
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
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
    }

    /**
     * Revisa los atributos observables del evento seleccionado y los muestra en los componentes.
     * @param ninguno
     * @return ninguno
     */
    private fun configurarObservables() {
        val humedad = args.lluvia.humedad
        val volumen = args.lluvia.volumen
        val viento = args.lluvia.viento
        val temperatura = args.lluvia.temperatura
        val fecha = args.lluvia.fecha
        val hora = args.lluvia.hora
        binding.infoHumedadLluvia.text = " ${humedad.toString()} %"
        binding.infoVolumenLluvia.text = " ${volumen.toString()} mm"
        binding.infoVientoLluvia.text = " ${viento.toString()} km/h"
        binding.infoTemperaturaLluvia.text = " ${temperatura.toString()} °C"
        binding.infoFechaLluvia.text = " $fecha"
        binding.infoHoraLluvia.text = " $hora"
    }

}
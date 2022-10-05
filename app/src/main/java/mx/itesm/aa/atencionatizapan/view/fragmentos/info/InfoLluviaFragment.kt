package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoLluviaViewModel
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoLluviaBinding

/** @author: Eduardo Joel Cortez Valente
 * Fragmento que muestra la información detallada de un evento de tipo lluvia en especifico
 */

class InfoLluviaFragment : Fragment() {

    private lateinit var binding: FragmentInfoLluviaBinding

    private lateinit var viewModel: InfoLluviaViewModel

    private val args: InfoLluviaFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoLluviaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
    }

    private fun configurarObservables() {
        val humedad = args.lluvia.humedad
        val volumen = args.lluvia.volumen
        val viento = args.lluvia.viento
        val temperatura = args.lluvia.temperatura
        val fecha = args.lluvia.fecha
        val hora = args.lluvia.hora
        binding.infoHumedad.text = "Humedad: ${humedad.toString()} %"
        binding.infoVolumen.text = "Volumen: ${volumen.toString()} mm de agua"
        binding.infoViento.text = "Viento: ${viento.toString()} km/h"
        binding.infoTemperatura.text = "Temperatura: ${temperatura.toString()} °C"
        binding.infoFecha.text = "Fecha: $fecha"
        binding.infoHora.text = "Hora: $hora"
    }

}
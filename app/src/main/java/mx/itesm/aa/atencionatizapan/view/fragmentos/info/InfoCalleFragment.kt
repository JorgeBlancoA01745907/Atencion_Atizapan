package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoCalleViewModel
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoCalleBinding

/** @author: Eduardo Joel Cortez Valente
 * Fragmento que muestra la información detallada de un evento de tipo calle cerrada en especifico
 */

class InfoCalleFragment : Fragment() {

    private lateinit var binding: FragmentInfoCalleBinding

    private lateinit var viewModel: InfoCalleViewModel

    private val args: InfoCalleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoCalleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
    }

    private fun configurarObservables() {
        val calle = args.callecerrada.calle
        val cp = args.callecerrada.cp
        val colonia = args.callecerrada.colonia
        val tiempo = args.callecerrada.tiempo
        val fecha = args.callecerrada.fecha
        val hora = args.callecerrada.hora

        binding.infoCalleCalle.text = "$calle"
        binding.infoCPCalle.text = "$cp"
        binding.infoColoniaCalle.text = "$colonia"
        binding.infoTiempoCalle.text = "${tiempo.toString()} horas"
        binding.infoFechaCalle.text = "$fecha"
        binding.infoHoraCalle.text = "$hora"

    }

}
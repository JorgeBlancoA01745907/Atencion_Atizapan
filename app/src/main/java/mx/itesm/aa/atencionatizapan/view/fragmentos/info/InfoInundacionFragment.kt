package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoInundacionViewModel
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoInundacionBinding
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoIncendioViewModel

class InfoInundacionFragment : Fragment() {

    private lateinit var binding: FragmentInfoInundacionBinding

    private lateinit var viewModel: InfoIncendioViewModel

    private val args: InfoInundacionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoInundacionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
    }

    private fun configurarObservables() {
        val calle = args.inundacion.calle
        val cp = args.inundacion.cp
        val colonia = args.inundacion.colonia
        val fecha = args.inundacion.fecha
        val hora = args.inundacion.hora

        binding.infoCalleInundacion.text = "$calle"
        binding.infoCPInundacion.text = "$cp"
        binding.infoColoniaInundacion.text = "$colonia"
        binding.infoFechaInundacion.text = "$fecha"
        binding.infoHoraInundacion.text = "$hora"
    }


}
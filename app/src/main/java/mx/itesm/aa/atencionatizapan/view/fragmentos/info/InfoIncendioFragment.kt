package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.navArgs
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoIncendioBinding
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoIncendioViewModel
import mx.itesm.aa.atencionatizapan.databinding.FragmentInfoInundacionBinding

/** @author: Eduardo Joel Cortez Valente
 * Fragmento que muestra la información detallada de un evento de tipo inundación en especifico
 */

class InfoIncendioFragment : Fragment() {

    private lateinit var binding: FragmentInfoIncendioBinding

    private lateinit var viewModel: InfoIncendioViewModel

    private val args: InfoIncendioFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoIncendioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarObservables()
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()

    }

    private fun configurarObservables() {
        val calle = args.incendio.calle
        val cp = args.incendio.cp
        val colonia = args.incendio.colonia
        val fecha = args.incendio.fecha
        val hora = args.incendio.hora

        binding.infoCalleIncendio.text = "$calle"
        binding.infoCPIncendio.text = "$cp"
        binding.infoColoniaIncendio.text = "$colonia"
        binding.infoFechaIncendio.text = "$fecha"
        binding.infoHoraIncendio.text = "$hora"
    }

}
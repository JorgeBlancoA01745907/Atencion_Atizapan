package mx.itesm.aa.atencionatizapan.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentPrincipalBinding
import mx.itesm.aa.atencionatizapan.viewmodel.PrincipalViewModel

class PrincipalFrag : Fragment() {

    companion object {
        fun newInstance() = PrincipalFrag()
    }

    private lateinit var viewModel: PrincipalViewModel

    private lateinit var binding: FragmentPrincipalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrincipalViewModel::class.java)
        // TODO: Use the ViewModel
    }

    /*private fun registrarEventos() {
        binding.buttonLluvia.setOnClickListener {
            val tipo = binding.spServicios.selectedItem.toString()
            val accion = PrincipalFragDirections.actionPrincipalFragToCostoFrag(tipo) //flecha de transicion
            findNavController().navigate(accion)
        }
        setFragmentResultListener("descargarCosto"){requestKey, bundle ->
            val costo = bundle.getDouble("costo")
            binding.tvCosto.setText("Precio a pagar $$costo")
        }
    }*/

}
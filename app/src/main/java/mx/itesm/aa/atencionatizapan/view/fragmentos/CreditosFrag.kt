package mx.itesm.aa.atencionatizapan.view.fragmentos

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import mx.itesm.aa.atencionatizapan.viewmodel.CreditosViewModel
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentCreditosBinding
import mx.itesm.aa.atencionatizapan.databinding.FragmentLluviaBinding

class creditosFrag : Fragment() {

    private lateinit var binding: FragmentCreditosBinding

    companion object {
        fun newInstance() = creditosFrag()
    }

    private lateinit var viewModel: CreditosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreditosBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreditosViewModel::class.java)
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        // TODO: Use the ViewModel


    }



}
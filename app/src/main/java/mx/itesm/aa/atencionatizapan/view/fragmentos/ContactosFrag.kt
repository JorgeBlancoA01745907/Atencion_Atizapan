package mx.itesm.aa.atencionatizapan.view.fragmentos

import android.graphics.drawable.AnimationDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import mx.itesm.aa.atencionatizapan.viewmodel.ContactosViewModel
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.FragmentContactosBinding
import mx.itesm.aa.atencionatizapan.databinding.FragmentCreditosBinding

class contactosFrag : Fragment() {

    private lateinit var binding: FragmentContactosBinding

    companion object {
        fun newInstance() = contactosFrag()
    }

    private lateinit var viewModel: ContactosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContactosBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContactosViewModel::class.java)
        val constraintLayout: ConstraintLayout = binding.mainLayout
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()
        // TODO: Use the ViewModel
    }

}
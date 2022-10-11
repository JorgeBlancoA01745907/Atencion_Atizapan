package mx.itesm.aa.atencionatizapan.view.fragmentos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.viewmodel.ContactosViewModel
import mx.itesm.aa.atencionatizapan.R

class contactosFrag : Fragment() {

    companion object {
        fun newInstance() = contactosFrag()
    }

    private lateinit var viewModel: ContactosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contactos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContactosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
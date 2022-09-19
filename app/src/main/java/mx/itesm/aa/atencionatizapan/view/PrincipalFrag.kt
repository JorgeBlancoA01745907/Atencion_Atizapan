package mx.itesm.aa.atencionatizapan.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.viewmodel.PrincipalViewModel

class PrincipalFrag : Fragment() {

    companion object {
        fun newInstance() = PrincipalFrag()
    }

    private lateinit var viewModel: PrincipalViewModel

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

}
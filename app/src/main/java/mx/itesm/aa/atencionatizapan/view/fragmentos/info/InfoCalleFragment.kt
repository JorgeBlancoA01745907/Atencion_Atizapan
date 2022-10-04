package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoCalleViewModel
import mx.itesm.aa.atencionatizapan.R

class InfoCalleFragment : Fragment() {

    companion object {
        fun newInstance() = InfoCalleFragment()
    }

    private lateinit var viewModel: InfoCalleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_calle, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoCalleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
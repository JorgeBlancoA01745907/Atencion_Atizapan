package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoLluviaViewModel
import mx.itesm.aa.atencionatizapan.R

class InfoLluviaFragment : Fragment() {

    companion object {
        fun newInstance() = InfoLluviaFragment()
    }

    private lateinit var viewModel: InfoLluviaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_lluvia, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoLluviaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
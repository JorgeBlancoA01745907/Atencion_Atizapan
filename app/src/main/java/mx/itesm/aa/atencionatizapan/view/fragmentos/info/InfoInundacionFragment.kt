package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoInundacionViewModel
import mx.itesm.aa.atencionatizapan.R

class InfoInundacionFragment : Fragment() {

    companion object {
        fun newInstance() = InfoInundacionFragment()
    }

    private lateinit var viewModel: InfoInundacionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_inundacion, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoInundacionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
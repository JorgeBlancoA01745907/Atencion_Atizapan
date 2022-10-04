package mx.itesm.aa.atencionatizapan.view.fragmentos.info

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.itesm.aa.atencionatizapan.viewmodel.info.InfoIncendioViewModel
import mx.itesm.aa.atencionatizapan.R

class InfoIncendioFragment : Fragment() {

    companion object {
        fun newInstance() = InfoIncendioFragment()
    }

    private lateinit var viewModel: InfoIncendioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info_incendio, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoIncendioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
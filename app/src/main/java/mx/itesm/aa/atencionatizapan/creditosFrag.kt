package mx.itesm.aa.atencionatizapan

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class creditosFrag : Fragment() {

    companion object {
        fun newInstance() = creditosFrag()
    }

    private lateinit var viewModel: CreditosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_creditos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreditosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
package mx.itesm.aa.atencionatizapan.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import mx.itesm.aa.atencionatizapan.databinding.ActivityMainBinding
import mx.itesm.aa.atencionatizapan.viewmodel.ListaEventosViewModel


class HistorialView : Fragment() {
    // binding
    private lateinit var binding: Fragment

    //view model
    private val viewModel: ListaEventosViewModel by viewModels()

    // adaptador
    private lateinit var adaptador : AdaptadorHistorial

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configurarRV()
        configurarObservables()
    }*/




}
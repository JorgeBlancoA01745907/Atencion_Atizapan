package mx.itesm.aa.atencionatizapan.view

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.databinding.ActivityMenuBinding

/** @author: Jose Luis Madrigal, Eduardo Joel Cortez, Maximiliano Benitez, Jorge Isidro Blanco,
 * Cesar Emiliano Palome, Christian Parrish Gutierrez
 *  Vista de la Actividad Menu (es la que corre al iniciar la aplicacion)
 */
class Menu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    /**
     * Crea los componentes graficos y establece pantallas en cada boton de la barra inferior
     * @param instancia de estado
     * @return ninguno
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Firebase.messaging.subscribeToTopic("alertasAtizapan")

        val constraintLayout: ConstraintLayout = findViewById(R.id.mainLayout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(5000)
        animationDrawable.start()


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.principalFrag, R.id.contactosFrag, R.id.creditosFrag
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
    }

    /**
     * Genera navegacion adecuada por el menu
     * @param ninguno
     * @return booleano que verifica funcionamiento
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_menu)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        return navController.navigateUp() || super.onSupportNavigateUp()

    }
}
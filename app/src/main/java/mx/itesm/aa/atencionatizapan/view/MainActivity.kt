package mx.itesm.aa.atencionatizapan.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import mx.itesm.aa.atencionatizapan.R

/** @author:
 *  Vista de la Actividad Principal
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.fragment_lluvia)
        setContentView(R.layout.activity_main)
        Firebase.messaging.subscribeToTopic("alertasAtizapan")
    }
}
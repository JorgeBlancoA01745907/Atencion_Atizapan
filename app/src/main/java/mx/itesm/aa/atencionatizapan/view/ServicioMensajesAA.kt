package mx.itesm.aa.atencionatizapan.view

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import mx.itesm.aa.atencionatizapan.R
import mx.itesm.aa.atencionatizapan.view.fragmentos.historiales.CalleCerradaFrag

/** @author:
 *  Vista del fragmento de servicio de mensajes
 */
class ServicioMensajesAA : FirebaseMessagingService()
{
    private val channelName = "alertasServer"
    private val channelId = "mx.itesm.aa.atencionatizapan.view"

    // Al recibir nuevo token
    override fun onNewToken(token: String) {
        println("Nuevo Token: $token")
        // enviarTokenAPI(token) token -> BD
    }

    // Al recibir un mensaje
    override fun onMessageReceived(message: RemoteMessage) {
        println("Llega una NOTIFICACIÓN remota")

        if(message.notification != null) {
            generarNotificacion(message)
        }
    }

    // Funcion que genera una notificación
    private fun generarNotificacion(message: RemoteMessage) {
        // Abre la app
        val intent = Intent(this, PrincipalFrag::class.java) // Abre la actividad que tiene el fragment
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // Borrar el historial. No meter a la pila. Cuando le de back, regresa
        // al sistema operativo

        val pendingIntent = PendingIntent.getActivity(this,
            0, intent, PendingIntent.FLAG_MUTABLE) // Mnadar otro intent de maera asincrona

        var builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notificacion)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)
        builder = builder.setContent(crearVistaRemota(message)) // Que es lo que va a mostrar y que xml va a utilizar
        // Aqui se regreso la interfaz grafica

        val admNotificaciones = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canalNotificaciones = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            admNotificaciones.createNotificationChannel(canalNotificaciones)
        }
        // Genera la notificación LOCALMENTE
        admNotificaciones.notify(0, builder.build()) // Forma de saber que esta notificación tiene ID 0
    }

    /* Genera la GUI para mostrar la notificación */
    @SuppressLint("RemoteViewLayout")
    private fun crearVistaRemota(message: RemoteMessage): RemoteViews {
        val titulo = message.notification?.title!!
        val mensaje = message.notification?.body!!
        val vistaRemota = RemoteViews("mx.itesm.aa.atencionatizapan.view", R.layout.notificacion) // Abre val, construye notificación
        vistaRemota.setTextViewText(R.id.constranin, titulo)
        vistaRemota.setTextViewText(R.id.tvMensaje, mensaje)
        vistaRemota.setImageViewResource(R.id.imgIcono, R.drawable.notificacion)
        return vistaRemota // Interfaz Grafica
    }
}
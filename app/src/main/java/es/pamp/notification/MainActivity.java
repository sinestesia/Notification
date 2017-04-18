package es.pamp.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import static android.app.PendingIntent.FLAG_ONE_SHOT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this);
        mBuilder
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .setContentTitle("Mensaje TEST TEST")
                .setContentText("Esto es un mensaje muy bonito!")
                .setAutoCancel(true);//Para eliminar la notificación una vez pulsada.

        Intent resultIntent = new Intent(this, Main2Activity.class);
        PendingIntent contIntent = PendingIntent.getActivity(this, 0, resultIntent, FLAG_ONE_SHOT);

        mBuilder.setContentIntent(contIntent);

        final Notification notification = mBuilder.build();
        final NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Button notificacionBoton = (Button) findViewById(R.id.notificacionBoton);
        notificacionBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNotificationManager.notify(0,notification);

            }
        });
    }
}

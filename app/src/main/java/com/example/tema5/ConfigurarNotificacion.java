package com.example.tema5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfigurarNotificacion extends AppCompatActivity {

    private static EditText txtTitulo;
    private static EditText txtTexto;
    private static EditText txtSegundos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_notificacion);
        setTitle("Configurar Notificación");
        createNotificationChannel();

        txtTitulo = findViewById(R.id.txtTitulo);
        txtTexto = findViewById(R.id.txtTexto);
        txtSegundos = findViewById(R.id.txtSegundos);
    }

    public void crearNotif(View v){

        String titulo = "Vacío";
        String texto = "Texto no seleccionado";
        Long segundos = 0L;

        try {
            if (!txtTitulo.getText().toString().isEmpty()){
                titulo = txtTitulo.getText().toString();
            }
            if (!txtTexto.getText().toString().isEmpty()){
                texto = txtTexto.getText().toString();
            }
            if (!txtSegundos.getText().toString().isEmpty()){
                segundos = Long.parseLong(txtSegundos.getText().toString())*1000;
            }
        }
        catch (Exception e){}

        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder constructor = new NotificationCompat.Builder(v.getContext(), "CANAL_ID")
                .setSmallIcon(R.drawable.ic_notif)
                .setContentTitle(titulo)
                .setContentText(texto).
                setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        try {
            Thread.sleep(segundos);
        }
        catch (Exception e){}

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, constructor.build());
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "CANAL_ID";
            String description = "Este es el canal";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CANAL_ID", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}

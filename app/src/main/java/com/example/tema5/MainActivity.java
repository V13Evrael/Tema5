package com.example.tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Inicio");
    }

    public void openConfigToast(View v){

        Intent intent = new Intent(this, ConfigurarToast.class);
        startActivity(intent);
    }

    public void openConfigNotif(View v){

        Intent intent = new Intent(this, ConfigurarNotificacion.class);
        startActivity(intent);
    }
}

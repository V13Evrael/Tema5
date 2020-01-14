package com.example.tema5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ConfigurarToast extends AppCompatActivity {

    private static EditText txtMensajeToast;
    private static EditText txtDesplHorToast;
    private static EditText txtDesplVerToast;
    private static RadioGroup rdGrEjeX;
    private static RadioGroup rdGrEjeY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_toast);
        txtMensajeToast = findViewById(R.id.txtMensajeToast);
        txtDesplHorToast = findViewById(R.id.txtDesplHorToast);
        txtDesplVerToast = findViewById(R.id.txtDesplVerToast);
        rdGrEjeX = findViewById(R.id.rdGrEjeX);
        rdGrEjeY = findViewById(R.id.rdGrEjeY);
        setTitle("Configurar Toast");

    }

    public void crearToast(View v){

        Toast toastMostrado = Toast.makeText(v.getContext(), txtMensajeToast.getText().toString(), Toast.LENGTH_SHORT);

        int ejeX = rdGrEjeX.indexOfChild(findViewById(rdGrEjeX.getCheckedRadioButtonId()));
        int ejeY = rdGrEjeY.indexOfChild(findViewById(rdGrEjeY.getCheckedRadioButtonId()));

        if (ejeX == 0){
            ejeX = Gravity.LEFT;
        }
        else if (ejeX == 1){
            ejeX = Gravity.CENTER;
        }
        else if (ejeX == 2) {
            ejeX = Gravity.RIGHT;
        }

        if (ejeY == 0){
            ejeY = Gravity.TOP;
        }
        else if (ejeY == 1){
            ejeY = Gravity.CENTER;
        }
        else if (ejeY == 2){
            ejeY = Gravity.BOTTOM;
        }

        try {

            toastMostrado.setGravity(ejeX|ejeY, Integer.parseInt(txtDesplHorToast.getText().toString()), Integer.parseInt(txtDesplVerToast.getText().toString()));
            toastMostrado.show();
        }
        catch (NumberFormatException nfE){
            toastMostrado.setGravity(ejeX|ejeY, 0, 0);
            toastMostrado.show();
        }
    }
}

package com.example.veterinaria_movil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.veterinaria_movil.R;

public class CargaActivity extends AppCompatActivity {
//Mostrar una pantalla de 3segundos al inciar la aplicacion y redigire a la actividad login
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);
        Thread tMain = new Thread(){
           @Override
           public void run(){
               super.run();
               try{
                   sleep(3000);
               }catch (InterruptedException e){
                   e.getMessage();
               }finally {
                   Intent iLogin = new Intent(getApplication(), LoginActivity.class);
                   startActivity(iLogin);
                   finish();
               }
           }

        };
        tMain.start();

    }
}
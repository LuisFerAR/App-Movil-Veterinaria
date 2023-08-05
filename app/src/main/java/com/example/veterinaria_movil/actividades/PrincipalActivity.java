package com.example.veterinaria_movil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.veterinaria_movil.R;
import com.example.veterinaria_movil.clases.Cliente;

public class PrincipalActivity extends AppCompatActivity{

   // TextView lblNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

      /*  lblNombre = findViewById(R.id.bieLblNombre);
        Cliente cliente = (Cliente)getIntent().getSerializableExtra("cliente");
        lblNombre.setText("Bienvenido "+cliente.getNombre());
*/
    }
}
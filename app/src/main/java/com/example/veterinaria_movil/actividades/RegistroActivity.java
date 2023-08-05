package com.example.veterinaria_movil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.veterinaria_movil.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtDni, txtNombre, txtClave, txtCorreo, txtCelular;
    Button btnRegistrar;
    ImageButton imgBtnRetroceder;

   // private final String setCliente = "http://appmovilxddd.000webhostapp.com/webServices/agregarCliente.php";

    private final String setCliente = "https://appmovil-veterinaria.000webhostapp.com/webServices/agregarCliente.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtDni = findViewById(R.id.regTxtDni);
        txtCelular = findViewById(R.id.regTxtCelular);
        txtCorreo = findViewById(R.id.regTxtCorreo);
        txtClave = findViewById(R.id.regTxtClave);
        txtNombre = findViewById(R.id.regTxtNombre);
        btnRegistrar = findViewById(R.id.regBtnRegistrar);
        imgBtnRetroceder = findViewById(R.id.regImgBtnRetroceder);

        btnRegistrar.setOnClickListener(this);
        imgBtnRetroceder.setOnClickListener(this);

    }
/*
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regBtnRegistrar:
                registrarCliente();
                break;
            case R.id.regImgBtnRetroceder:
                regresar();
                break;
        }
    }
*/
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.regBtnRegistrar) {
            registrarCliente();
        } else if (view.getId() == R.id.regImgBtnRetroceder) {
            regresar();
        }
    }


    private void registrarCliente() {
        if(validarForumario()){
            String dni = txtDni.getText().toString();
            String nombre = txtNombre.getText().toString();
            String celular = txtCelular.getText().toString();
            String correo = txtCorreo.getText().toString();
            String clave = txtClave.getText().toString();

            AsyncHttpClient ahcRegistrarcliente = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.add("nombre", nombre);
            params.add("dni", dni);
            params.add("celular", celular);
            params.add("correo", correo);
            params.add("clave", clave);

            ahcRegistrarcliente.post(setCliente, params, new BaseJsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {
                    if(statusCode == 200){
                        int resultado = rawJsonResponse.length() == 0 ? 0 : Integer.parseInt(rawJsonResponse);
                        if(resultado == 1){
                            imgBtnRetroceder.setEnabled(false);
                            Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_LONG).show();
                            Intent login = new Intent(getApplicationContext(), LoginActivity.class);
                            try{
                                Thread.sleep(3000);
                            }catch (InterruptedException e){
                                throw new RuntimeException(e);
                            }
                            startActivity(login);
                            finish();
                        }
                        else
                            Toast.makeText(getApplicationContext(), "ERROR al registrar", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Object errorResponse) {

                }

                @Override
                protected Object parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                    return null;
                }
            });
        }
    }

    private boolean validarForumario() {
        return true;
    }

    private void regresar() {

    }
}
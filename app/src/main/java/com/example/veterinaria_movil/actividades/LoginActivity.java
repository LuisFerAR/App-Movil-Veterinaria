package com.example.veterinaria_movil.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.veterinaria_movil.R;
import com.example.veterinaria_movil.clases.Cliente;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtDni, txtClave;
    Button btnIngresar, btnRegistro;


    final private String urlLogin = "https://appmovil-veterinaria.000webhostapp.com/webServices/iniciarSesion.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //INGRESAR LAS LOS DATOS DEL LAYOUT A BACKEND;
        txtDni = findViewById(R.id.logTxtDni);
        txtClave = findViewById(R.id.logTxtClave);
        btnIngresar = findViewById(R.id.logBtnIngresar);
        btnRegistro = findViewById(R.id.logBtnRegistro);
        //CONFIGURAR LOS BOTONES (ONLICK)
        btnIngresar.setOnClickListener(this);
        btnRegistro.setOnClickListener(this);
    }

   /* @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.logBtnIngresar:
                iniciarSesion(txtDni.getText().toString(), txtClave.getText().toString());
                break;
            case R.id.logBtnRegistro:
                registrar();
                break;
        }
    }
*/
    @Override
    public void onClick(View view){
        if (view.getId() == R.id.logBtnIngresar) {
            iniciarSesion(txtDni.getText().toString(), txtClave.getText().toString());
        } else if (view.getId() == R.id.logBtnRegistro) {
            registrar();
        }
    }


    private void iniciarSesion(String dni, String clave) {

        AsyncHttpClient ahcLogin = new AsyncHttpClient();  // Se crea un cliente HTTP para realizar la solicitud POST al servidor.
        RequestParams params = new RequestParams();  // Se crean los parámetros para enviar al servidor (dni y contraseña).
        params.add("dni", dni);
        params.add("clave", clave);
        // Se realiza la solicitud POST al servidor con la URL especificada en 'urlLogin'
        ahcLogin.post(urlLogin, params, new BaseJsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {
                if (statusCode == 200) {
                    try {
                        JSONArray jsonArray = new JSONArray(rawJsonResponse); // Se crea un JSONArray para analizar la respuesta JSON del servidor.
                        if (jsonArray.length() > 0) {      // Se verifica si el JSONArray contiene al menos un elemento, lo que indica que el inicio de sesión fue exitoso.
                            if (jsonArray.getJSONObject(0).getInt("id_cliente") != 1) {// Se crea una instancia de la clase Cliente y se le asignan los datos ,obtenidos del JSON del servidor.
                                Cliente cliente = new Cliente();
                                cliente.setIdCliente(jsonArray.getJSONObject(0).getInt("id_cliente"));
                                cliente.setNombre(jsonArray.getJSONObject(0).getString("nombre"));
                                cliente.setDni(jsonArray.getJSONObject(0).getString("dni"));
                                cliente.setCelular(jsonArray.getJSONObject(0).getString("celular"));
                                cliente.setCorreo(jsonArray.getJSONObject(0).getString("correo"));
                                cliente.setClave(jsonArray.getJSONObject(0).getString("clave"));

                                Intent iPrincipal = new Intent(getApplicationContext(), PrincipalActivity.class); // Se crea un Intent para ir a la actividad PrincipalActivity y se le pasa el objeto cliente.
                                //iPrincipal.putExtra("cliente", cliente);
                                startActivity(iPrincipal);
                            } else {
                                Toast.makeText(getApplicationContext(), "ERROR: usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "ERROR al iniciar sesion", Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
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
       /*if(correo.equals("cuto@upn.edu.pe") && clave.equals("e05adfb80b6cc009a848215b506ae63f6fd05b97")){
            Intent iBienvenida = new Intent(this, BienvenidaActivity.class);
            iBienvenida.putExtra("nombre", "Cuto");
            if(chkRecordar.isChecked()){
                yugioh yugioh = new yugioh(getApplicationContext());
                yugioh.agregarUsuario(1, correo, clave);
            }
            startActivity(iBienvenida);
        }
        else{
            Toast.makeText(this, "Usuario o clase incorrecta", Toast.LENGTH_SHORT).show();
        }*/


        private void registrar() {
        Intent iRegistro = new Intent(this, RegistroActivity.class);
        startActivity(iRegistro);
        }
}


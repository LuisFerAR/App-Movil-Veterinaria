package com.example.veterinaria_movil.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.veterinaria_movil.R;
import com.example.veterinaria_movil.fragmentos.AdoptarFragment;
import com.example.veterinaria_movil.fragmentos.CitasFragment;
import com.example.veterinaria_movil.fragmentos.ConsultaOnlineFragment;
import com.example.veterinaria_movil.fragmentos.PetShopFragment;

public class MenuActivity extends AppCompatActivity {
    Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
      /*  fragments = new Fragment[4];
        fragments[0] = new AdoptarFragment();
        fragments[1] = new CitasFragment();
        fragments[2] = new ConsultaOnlineFragment();
        fragments[3] = new PetShopFragment();
        int iIdBoton = getIntent().getIntExtra("BotonElegido", -1);
        menu(iIdBoton);*/
    }

   /* private void menu(int iIdBoton) {
        FragmentManager frgManager = getSupportFragmentManager();
        FragmentTransaction frgTransaction = frgManager.beginTransaction();
        frgTransaction.replace(R.id.menRelMenu, fragments[iIdBoton]);
        frgTransaction.commit();
    }
*/

}
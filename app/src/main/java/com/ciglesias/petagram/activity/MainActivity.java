package com.ciglesias.petagram.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.adaptor.PageAdapter;
import com.ciglesias.petagram.fragment.FragmentMiMascota;
import com.ciglesias.petagram.fragment.FragmentRecyclerView;
import com.ciglesias.petagram.restApi.IEndPointsApi;
import com.ciglesias.petagram.restApi.adapter.RestApiAdapter;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    SharedPreferences sharedPreferences;

    private final String PREFERENCIA_USUARIO = "DatosUsuario";
    private String userId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.id_toolbar);

        tabLayout = (TabLayout) findViewById(R.id.id_tab);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        sharedPreferences = getSharedPreferences(getResources().getString(R.string.preferencia_datos_usuario), Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            userId = sharedPreferences.getString(getResources().getString(R.string.preferencia_usuario), "");
        }


        if (myToolbar != null) {
            setSupportActionBar(myToolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentRecyclerView());
        fragments.add(new FragmentMiMascota());

        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_mi_mascota);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavoritos:
                Intent iFavoritas = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(iFavoritas);
                break;
            case R.id.mContacto:
                Intent iContacto = new Intent(MainActivity.this, Contacto.class);
                startActivity(iContacto);
                break;
            case R.id.mConfigurarCuenta:
                Intent iConfigurarCuenta = new Intent(MainActivity.this, ActivityUsuario.class);
                startActivity(iConfigurarCuenta);
                break;
            case R.id.mAcercaDe:
                showDialogoAcercaDe();
                break;
            case R.id.mRegistrarUsuario:
                registrarUsuario();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registrarUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        IEndPointsApi endPointsApi = restApiAdapter.establecerConexionApiNode();
        String idDispositivo = FirebaseInstanceId.getInstance().getToken();
        Call<String> stringCall = endPointsApi.registrarUsuario(idDispositivo, userId);
        stringCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("MainActivy", "ResponseNode: " + response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    private void showDialogoAcercaDe() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_acerca_de);

        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));


        dialog.show();
    }
}
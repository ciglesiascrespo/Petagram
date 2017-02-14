package com.ciglesias.petagram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewMascotas;
    ArrayList<Mascota> listMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listMascotas = new ArrayList<>();

        listMascotas.add(new Mascota("Alex", 0, R.drawable.img_mascota_1));
        listMascotas.add(new Mascota("Dante", 2, R.drawable.img_mascota_2));
        listMascotas.add(new Mascota("Kelpie", 3, R.drawable.img_mascota_3));
        listMascotas.add(new Mascota("Kiba", 5, R.drawable.img_mascota_4));
        listMascotas.add(new Mascota("Akamaru", 0, R.drawable.img_mascota_5));
        listMascotas.add(new Mascota("Tyson", 0, R.drawable.img_mascota_6));
        listMascotas.add(new Mascota("Tom", 0, R.drawable.img_mascota_7));
        listMascotas.add(new Mascota("Toby", 0, R.drawable.img_mascota_8));
        listMascotas.add(new Mascota("Firulais", 0, R.drawable.img_mascota_9));

        recyclerViewMascotas = (RecyclerView) findViewById(R.id.id_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(listMascotas);

        recyclerViewMascotas.setLayoutManager(linearLayoutManager);
        recyclerViewMascotas.setAdapter(mascotaAdaptador);
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
                Intent i = new Intent(MainActivity.this, MascotasFavoritas.class);
                startActivity(i);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
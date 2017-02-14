package com.ciglesias.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    RecyclerView recyclerViewMascotasFavoritas;
    ArrayList<Mascota> listMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        listMascotasFavoritas = new ArrayList<>();

        listMascotasFavoritas.add(new Mascota("Alex", 0, R.drawable.img_mascota_1));
        listMascotasFavoritas.add(new Mascota("Dante", 2, R.drawable.img_mascota_2));
        listMascotasFavoritas.add(new Mascota("Kelpie", 3, R.drawable.img_mascota_3));
        listMascotasFavoritas.add(new Mascota("Kiba", 5, R.drawable.img_mascota_4));
        listMascotasFavoritas.add(new Mascota("Akamaru", 0, R.drawable.img_mascota_5));


        recyclerViewMascotasFavoritas = (RecyclerView) findViewById(R.id.id_recyclerview_favoritas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(listMascotasFavoritas);

        recyclerViewMascotasFavoritas.setLayoutManager(linearLayoutManager);
        recyclerViewMascotasFavoritas.setAdapter(mascotaAdaptador);
    }
}

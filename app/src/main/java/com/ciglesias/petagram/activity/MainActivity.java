package com.ciglesias.petagram.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import com.ciglesias.petagram.R;
import com.ciglesias.petagram.adaptor.PageAdapter;
import com.ciglesias.petagram.fragment.FragmentMiMascota;
import com.ciglesias.petagram.fragment.FragmentRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar myToolbar;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.id_toolbar);

        tabLayout = (TabLayout) findViewById(R.id.id_tab);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);


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
            case R.id.mAcercaDe:
                showDialogoAcercaDe();
                break;
        }

        return super.onOptionsItemSelected(item);
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
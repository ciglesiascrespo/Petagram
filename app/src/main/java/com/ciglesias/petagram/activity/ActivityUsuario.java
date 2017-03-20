package com.ciglesias.petagram.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ciglesias.petagram.R;

public class ActivityUsuario extends AppCompatActivity implements IActivityUsuario {

    EditText edtNombre;
    Button btnGuardar;

    SharedPreferences sharedPreferences;

    private final String PREFERENCIA_USUARIO = "DatosUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_usuario);
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.preferencia_datos_usuario), Context.MODE_PRIVATE);
        edtNombre = (EditText) findViewById(R.id.id_edt_nombre_usuario);
        btnGuardar = (Button) findViewById(R.id.id_btn_guardar_usuario);
        btnGuardar.setOnClickListener(guardarPreferencias());

    }

    @Override
    public View.OnClickListener guardarPreferencias() {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String nombre = edtNombre.getText().toString();

                editor.putString(getResources().getString(R.string.preferencia_usuario), nombre);
                editor.commit();

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.preferencia_guardada), Toast.LENGTH_SHORT).show();
                edtNombre.setText("");

            }
        };
        return onClickListener;
    }

}

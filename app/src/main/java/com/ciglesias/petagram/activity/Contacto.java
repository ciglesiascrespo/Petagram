package com.ciglesias.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ciglesias.petagram.Mail.SendMail;
import com.ciglesias.petagram.R;

public class Contacto extends AppCompatActivity {

    private EditText edtNombre, edtCorreo, edtMensaje;
    private Button btnEnviar;

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        myToolbar = (Toolbar) findViewById(R.id.id_toolbar);


        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.menu_contacto));



        edtNombre = (EditText) findViewById(R.id.id_edt_nombre);
        edtCorreo = (EditText) findViewById(R.id.id_edt_correo);
        edtMensaje = (EditText) findViewById(R.id.id_edt_msj);

        btnEnviar = (Button) findViewById(R.id.id_btn_registrarse);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {

        String email = edtCorreo.getText().toString().trim();
        String subject = edtNombre.getText().toString().trim();
        String message = edtMensaje.getText().toString().trim();

        SendMail sm = new SendMail(this, email, subject, message);

        sm.execute();
    }
}

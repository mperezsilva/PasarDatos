package com.example.mperezsilva.pasardatos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad2 extends Activity {

    EditText no, to;
    String largo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        no = (EditText) findViewById(R.id.etNombreO);
        to = (EditText) findViewById(R.id.etTelO);
        //Penha p1 = (Penha) getIntent().getSerializableExtra("persona");
        Intent i=getIntent();
        Penha p1=(Penha)i.getExtras().getSerializable("persona");
        no.setText(p1.getNombre());
        largo=p1.getNombre().toString();
        to.setText(String.valueOf(p1.getTel()));
        Button btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = no.getText().toString();
                int tel = Integer.parseInt(to.getText().toString());
                Penha p = new Penha(nom, tel);
                Intent i=new Intent();
                Bundle reci=new Bundle();
                reci.putString("largo",largo);
                reci.putString("mensaje","Penha cambiada");
                reci.putSerializable("peña",p);
                i.putExtras(reci);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.actividad2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

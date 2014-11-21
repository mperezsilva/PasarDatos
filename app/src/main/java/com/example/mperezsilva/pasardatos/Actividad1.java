package com.example.mperezsilva.pasardatos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class Actividad1 extends Activity {

    ArrayList<Penha> ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Button btnA = (Button) findViewById(R.id.btnAñadir);
        //Button btnE = (Button) findViewById(R.id.btnEditar);
        Button btnM = (Button) findViewById(R.id.btnLista);
        ap = new ArrayList<Penha>();
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText na = (EditText) findViewById(R.id.etNombreA);
                EditText ta = (EditText) findViewById(R.id.etTelA);
                String nom = na.getText().toString();
                int tel = Integer.parseInt(ta.getText().toString());
                if (nom == "") {
                    showToast("Introduce un nombre");
                } else {
                    Penha p = new Penha(nom, tel);
                    ap.add(p);
                    showToast("Penha añadida");
                    na.setText("");
                    ta.setText("");
                }
            }
        });
        /*btnE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ne = (EditText) findViewById(R.id.etNombreE);
                String nom = ne.getText().toString();
                if (nom == "") {
                    showToast("Introduce un nombre");
                } else {
                    Boolean nomEx = false;
                    for (Penha p1 : ap) {
                        showToast(p1.getNombre());
                        if (p1.getNombre().toString().equalsIgnoreCase(nom)) {
                            showToast("existe");
                            nomEx = true;
                            Intent i = new Intent(Actividad1.this, Actividad2.class);
                            i.putExtra("persona", new Penha(p1.getNombre(), p1.getTel()));
                            startActivityForResult(i, 1);
                        }
                    }
                    if (nomEx == true) {
                        showToast("Peña no encontrada");
                    }
                }
            }
        });*/
        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ap == null) {
                    showToast("No hay Peña");
                } else {
                    Intent i = new Intent(Actividad1.this, MostrarLista.class);
                    i.putExtra("array", ap);
                    startActivityForResult(i, 1);
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*Penha p = (Penha) data.getExtras().getSerializable("peña");
        String n = data.getExtras().getString("largo");
        for (Penha p1 : ap) {
            showToast(p1.getNombre());
            if (p1.getNombre().toString().equalsIgnoreCase(n)) {
                p1.setNombre(p.getNombre().toString());
                p1.setTel(p.getTel());
                String res = data.getExtras().getString("mensaje");
                showToast(res);
                showToast("La peña " + n + " " + "cambio a " + p1.getNombre() + " " + p1.getTel());
            }
        }*/
        if (resultCode == RESULT_OK) {
            ap = (ArrayList<Penha>) data.getExtras().getSerializable("array");
            showToast("Lista actualizada");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public void showToast(String t) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, t, duration);
        toast.show();
    }
}

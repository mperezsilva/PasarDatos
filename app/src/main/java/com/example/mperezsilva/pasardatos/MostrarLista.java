package com.example.mperezsilva.pasardatos;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MostrarLista extends ListActivity {

    ArrayList<Penha> ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_lista);
        ap = (ArrayList<Penha>) getIntent().getSerializableExtra("array");
        setListAdapter(new ArrayAdapter<Penha>(this, android.R.layout.simple_list_item_1, ap));
    }

    public void onListItemClick(ListView parent, View v, int posicion, long id) {
        Toast.makeText(this, "Vas a editar " + ap.get(posicion), Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MostrarLista.this, Actividad2.class);
        i.putExtra("persona", ap.get(posicion));
        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Penha p = (Penha) data.getExtras().getSerializable("peña");
            String n = data.getExtras().getString("largo");
            for (Penha p1 : ap) {
                if (p1.getNombre().toString().equalsIgnoreCase(n)) {
                    p1.setNombre(p.getNombre().toString());
                    p1.setTel(p.getTel());
                    String res = data.getExtras().getString("mensaje");
                    showToast(res);
                    showToast("La peña " + n + " " + "cambio a " + p1.getNombre() + " " + p1.getTel());
                }
            }
            //setListAdapter(new ArrayAdapter<Penha>(this,android.R.layout.simple_list_item_1, ap));
            Intent i = new Intent();
            i.putExtra("array", ap);
            setResult(RESULT_OK, i);
            finish();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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

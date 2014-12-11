package com.example.mperezsilva.pasardatos;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActivityBorrar extends ListActivity {

    ArrayList<Penha> ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        ap = (ArrayList<Penha>) getIntent().getSerializableExtra("array");
        setListAdapter(new ArrayAdapter<Penha>(this, android.R.layout.simple_list_item_1, ap));
    }

    public void onListItemClick(ListView parent, View v, int posicion, long id) {
        Toast.makeText(this, "Has borrado " + ap.get(posicion), Toast.LENGTH_SHORT).show();
        ap.remove(ap.get(posicion));
        Intent i = new Intent();
        i.putExtra("array", ap);
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_borrar, menu);
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
}

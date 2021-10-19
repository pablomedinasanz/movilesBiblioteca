package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int numLista = 0;
    private static int COD_RTN_ACT = 0;

    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

            numLista = savedInstanceState.getInt("numLibro", 0);
        }

        //llamar al objeto de listView y recogemos la lista de libros
        ListView lvLibros = (ListView) this.findViewById(R.id.lstLibros);
        lvLibros.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, com.example.biblioteca.Datos.getNombres())); //primero el contexto, segundo donde queremos que vayan y tercero de donde sacamos la info, en lvLibros esta preparado para usarse

        lvLibros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {

                numLista = posicion;
                Intent intent = new Intent(view.getContext(), com.example.biblioteca.Detalles.class);
                intent.putExtra("numLibro", numLista);
                startActivityForResult(intent, COD_RTN_ACT); //inicio con la intención de que haya un resultado


            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (resultCode == RESULT_OK && requestCode == COD_RTN_ACT) {
            StringBuffer sb = new StringBuffer();

            sb.append("De vuelta: \n");
            sb.append("Título: " + intent.getStringExtra("Edicion libro"));
            sb.append("Autor: " + intent.getData().toString());
            Toast.makeText(ctx, sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
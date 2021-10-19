package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();

        int numLista = intent.getIntExtra("numLibro", 0);

        TextView libro = (TextView) this.findViewById(R.id.txtLibro);
        libro.setText(Datos.lista[numLista][0]);
        TextView autor = (TextView) this.findViewById(R.id.txtAutor);
        autor.setText(Datos.lista[numLista][1]);

        EditText libroEdit = (EditText) this.findViewById(R.id.editTextLibro);
        EditText autorEdit = (EditText) this.findViewById(R.id.editTextAutor);

        Button btEdit = (Button) this.findViewById(R.id.buttonEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentBoton = new Intent();
                intentBoton.putExtra("EdicionLibro", libroEdit.getText().toString());
                intentBoton.setData(Uri.parse(autorEdit.getText().toString()));
                setResult(RESULT_OK, intentBoton);
                finish();

            }
        });

    }
}
package com.example.conversorunidades;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerCategoria, spinnerUnidades;
    private EditText editCantidad;
    private Button btnConvertir;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //vincular los elementos XML con java (gráfica/lógica)
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        spinnerCategoria = findViewById(R.id.spinnerUnidades);
        editCantidad = findViewById(R.id.editCantidad);
        btnConvertir = findViewById(R.id.btnConvertir);
        textResultado = findViewById(R.id.textResultado);

        //opciones para el spinner de vategoria
        String[] categorias = {"Monedas", "Temperatura", "Longitud"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spinnerCategoria.setAdapter(adapter);

        //Manejar seleccion de Spinner
        spinnerCategoria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                atualizarUnidades(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){}
        });

    }
}


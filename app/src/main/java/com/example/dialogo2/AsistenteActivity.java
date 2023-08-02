package com.example.dialogo2;

// AsistenteActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AsistenteActivity extends AppCompatActivity {
    private Spinner spinnerConferencias;
    private Button btnRegistrarAsistente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistente);

        spinnerConferencias = findViewById(R.id.spinnerConferencias);
        btnRegistrarAsistente = findViewById(R.id.btnRegistrarAsistente);

        // Crear el adaptador para el spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conferencias_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asignar el adaptador al spinner
        spinnerConferencias.setAdapter(adapter);

        btnRegistrarAsistente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener la conferencia seleccionada
                String conferencia = spinnerConferencias.getSelectedItem().toString();

                // Guardar los datos en algún lugar (por ejemplo, en una base de datos o en SharedPreferences)

                // Mostrar mensaje de registro exitoso
                Toast.makeText(AsistenteActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

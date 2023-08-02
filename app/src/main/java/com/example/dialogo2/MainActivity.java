package com.example.dialogo2;

// MainActivity.java
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_FIRST_TIME = "first_time";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isFirstTime = sharedPreferences.getBoolean(KEY_FIRST_TIME, true);

        if (isFirstTime) {
            // Es la primera vez que se abre la aplicación, mostrar mensaje de bienvenida
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(KEY_FIRST_TIME, false);
            editor.apply();
            // Aquí puedes agregar la lógica para mostrar el mensaje de bienvenida
        }

        Button btnExpositor = findViewById(R.id.btnExpositor);
        Button btnAsistente = findViewById(R.id.btnAsistente);

        btnExpositor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExpositorActivity.class);
                startActivity(intent);
            }
        });

        btnAsistente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AsistenteActivity.class);
                startActivity(intent);
            }
        });
    }
}

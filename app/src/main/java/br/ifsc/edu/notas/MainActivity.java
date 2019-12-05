package br.ifsc.edu.notas;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Notas nota;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText=findViewById(R.id.editTextHint);
        nota=new Notas(getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                nota.salvaNota(editText.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        editText.setText(nota.recuperaNota());
    }

    @Override
    protected void onPause() {
        super.onPause();
        nota.salvaNota(editText.getText().toString());
    }
}

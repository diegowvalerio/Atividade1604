package com.example.aluno.atividade1604;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buscar(View view){
        EditText ed = (EditText)findViewById(R.id.editText);
        if(ed.getText().equals("")){
            Toast.makeText(this, "Informe Cnpj válido !", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ApresentaBusca.class);
            intent.putExtra("cnpj", ((EditText) findViewById(R.id.editText)).getText().toString());
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EditText ed = (EditText)findViewById(R.id.editText);
        ed.setText(null);
    }
}

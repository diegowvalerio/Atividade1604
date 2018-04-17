package com.example.aluno.atividade1604;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ApresentaBusca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresenta_busca);

        Bundle bundle = getIntent().getExtras();
        String cnpj = bundle.getString("cnpj");

        BuscarEmpresaWS buscaremp = new BuscarEmpresaWS(ApresentaBusca.this);
        buscaremp.execute("https://www.receitaws.com.br/v1/cnpj/"+cnpj);
    }
}

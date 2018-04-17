package com.example.aluno.atividade1604;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by aluno on 11/04/18.
 */

public class BuscarEmpresaWS extends AsyncTask<String,Integer,String> {

    Activity activity;


    public BuscarEmpresaWS(Activity activity){
        this.activity = activity;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Gson gson = new Gson();
        Empresa empresa = gson.fromJson(s, Empresa.class);


        EditText nome = (EditText) activity.findViewById(R.id.ed_nome);
        EditText logradouro = (EditText) activity.findViewById(R.id.ed_logradouro);
        EditText bairro = (EditText) activity.findViewById(R.id.ed_bairro);
        EditText cep = (EditText) activity.findViewById(R.id.ed_cep);
        EditText municipio = (EditText) activity.findViewById(R.id.ed_municipio);
        EditText numero = (EditText) activity.findViewById(R.id.ed_numero);
        EditText uf = (EditText) activity.findViewById(R.id.ed_uf);
        EditText situacao = (EditText) activity.findViewById(R.id.ed_situacao);

        //Empresa empresa = new Empresa();

        nome.setText(empresa.getNome());
        logradouro.setText(empresa.getLogradouro());
        bairro.setText(empresa.getBairro());
        cep.setText(empresa.getCep());
        municipio.setText(empresa.getMunicipio());
        numero.setText(empresa.getNumero());
        uf.setText(empresa.getUf());
        situacao.setText(empresa.getSituacao());


    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected String doInBackground(String... strings) {

        String jsonRetorno=null;
        try {
            URL url = new URL(strings[0]);
            InputStream stream = url.openStream();
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            //onProgressUpdate(10);
            String linha;
            while ((linha = bufferedReader.readLine())!=null){
                builder.append(linha);
            }
            jsonRetorno = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonRetorno;
    }
}

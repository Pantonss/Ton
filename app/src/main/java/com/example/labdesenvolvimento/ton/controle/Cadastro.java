package com.example.labdesenvolvimento.ton.controle;

import android.app.Activity;

import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.labdesenvolvimento.ton.modelo.CustomJson;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.example.labdesenvolvimento.ton.R;
import com.example.labdesenvolvimento.ton.modelo.CustomJson;
import com.example.labdesenvolvimento.ton.modelo.CustomJsonArray;
import com.example.labdesenvolvimento.ton.modelo.User;
import com.example.labdesenvolvimento.ton.modelo.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lab. Desenvolvimento on 26/10/2017.
 */

public class Cadastro extends Activity {

    EditText email,senha,nome,sobre,telefone,celular,rg,cpf,cep,endereco,profissao;
    Button cadastro;
    CheckBox provedor;
    private RequestQueue rq;
    private Map<String, String> params;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        url = "http://localhost:8180/TON-WS/WS/Usuario/Cadastrar";
        email = (EditText) findViewById(R.id.editEmail);
        senha = (EditText) findViewById(R.id.editSenha);
        nome = (EditText) findViewById(R.id.editNome);
        sobre = (EditText) findViewById(R.id.editSobre);
        telefone = (EditText) findViewById(R.id.editTelefone);
        celular = (EditText) findViewById(R.id.editNumero);
        rg = (EditText) findViewById(R.id.editRg);
        cpf = (EditText) findViewById(R.id.editCpf);
        cep = (EditText) findViewById(R.id.editCep);
        endereco = (EditText) findViewById(R.id.editEndereco);
        cadastro = (Button) findViewById(R.id.cadastorCadastro);
        provedor = (CheckBox) findViewById(R.id.checkPrestador);
        profissao = (EditText) findViewById(R.id.editProfi);
        rq = Volley.newRequestQueue(Cadastro.this);


        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    public void callByJasonObjectRequest(View view) {
        params = new HashMap<String, String>();
        String providerIdProvider = params.put("providerIdProvider", provedor.getText().charAt();
        params.put("FirstName", nome.getText().toString());
        params.put("LastName", sobre.getText().toString());
        params.put("Email", email.getText().toString());
        params.put("Rg", rg.getText().toString());
        params.put("Cpf", cpf.getText().toString());
        params.put("Phone", telefone.getText().toString());
        params.put("CellPhone", celular.getText().toString());
        params.put("Cep", cep.getText().toString());
        params.put("Password", senha.getText().toString());
        params.put("Adress", endereco.getText().toString());
        params.put("SubCategoria", profissao.getText().toString());
        params.put("method", "web-data-jor");

        CustomJson cj = new CustomJson(Method.Post, url, params, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Cadastro.this, "Erro" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("SCRIPT", "SUCESSO" + response);
            }
        });
        cj.setTag("tag");
        rq.add(cj);
    }
    public  void callByJsonObjectArrayRequest(View view){

        params = new HashMap<String, String>();
        String providerIdProvider = params.put("providerIdProvider", provedor.getText().charAt();
        params.put("FirstName", nome.getText().toString());
        params.put("LastName", sobre.getText().toString());
        params.put("Email", email.getText().toString());
        params.put("Rg", rg.getText().toString());
        params.put("Cpf", cpf.getText().toString());
        params.put("Phone", telefone.getText().toString());
        params.put("CellPhone", celular.getText().toString());
        params.put("Cep", cep.getText().toString());
        params.put("Password", senha.getText().toString());
        params.put("Adress", endereco.getText().toString());
        params.put("SubCategoria", profissao.getText().toString());
        params.put("method", "web-data-jor");

        CustomJsonArray cja = new CustomJsonArray(Method.POST, url, params, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Cadastro.this, "Erro" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("SCRIPT", "SUCESSO" + response);
            }
        });
        cja.setTag("tag");
        rq.add(cja);

    }

    public  void callByStringRequest(View view) {
        params = new HashMap<String, String>();
        String providerIdProvider = params.put("providerIdProvider", provedor.getText().charAt();
        params.put("FirstName", nome.getText().toString());
        params.put("LastName", sobre.getText().toString());
        params.put("Email", email.getText().toString());
        params.put("Rg", rg.getText().toString());
        params.put("Cpf", cpf.getText().toString());
        params.put("Phone", telefone.getText().toString());
        params.put("CellPhone", celular.getText().toString());
        params.put("Cep", cep.getText().toString());
        params.put("Password", senha.getText().toString());
        params.put("Adress", endereco.getText().toString());
        params.put("SubCategoria", profissao.getText().toString());
        params.put("method", "web-data-jor");

                StringRequest request = new StringRequest(Request.Method.POST, url, params, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Cadastro.this, "Erro" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("SCRIPT", "SUCESSO" + response);
            }
        }) {
                    @Override
                public Map<String, String> getParams() throws AuthFailureError {
                    params = new HashMap<String, String>();
                    String providerIdProvider = params.put("providerIdProvider", provedor.getText().charAt();
                    params.put("FirstName", nome.getText().toString());
                    params.put("LastName", sobre.getText().toString());
                    params.put("Email", email.getText().toString());
                    params.put("Rg", rg.getText().toString());
                    params.put("Cpf", cpf.getText().toString());
                    params.put("Phone", telefone.getText().toString());
                    params.put("CellPhone", celular.getText().toString());
                    params.put("Cep", cep.getText().toString());
                    params.put("Password", senha.getText().toString());
                    params.put("Adress", endereco.getText().toString());
                    params.put("SubCategoria", profissao.getText().toString());
                    params.put("method", "web-data-jor");

                    return (params);
                }
                };
        request.setTag("tag");
        rq.add(request);

    }

    public void onStop(){
        super.onStop();
        rq.cancelAll("tag");


    }
    public Request.Priority getPriority(){
        return (Request.Priority.NORMAL);
    }
}

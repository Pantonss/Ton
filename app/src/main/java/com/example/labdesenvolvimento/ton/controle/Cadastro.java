package com.example.labdesenvolvimento.ton.controle;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.labdesenvolvimento.ton.R;
import com.example.labdesenvolvimento.ton.modelo.User;
import com.example.labdesenvolvimento.ton.modelo.Util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lab. Desenvolvimento on 26/10/2017.
 */

public class Cadastro extends Activity {

    EditText email,senha,nome,sobre,telefone,celular,rg,cpf,cep,endereco;
    Button cadastro;
    CheckBox provedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
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

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


}

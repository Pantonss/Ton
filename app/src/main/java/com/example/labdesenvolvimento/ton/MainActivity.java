package com.example.labdesenvolvimento.ton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.labdesenvolvimento.ton.controle.Cadastro;
import com.example.labdesenvolvimento.ton.controle.Entrar;


public class MainActivity extends Activity {

    private EditText userEmail, userSenha;
    private Button logar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logar(View view) {
        startActivity(new Intent(getApplicationContext(), Entrar.class));
    }

    public void cadastro(View view) {
        startActivity(new Intent(getApplicationContext(), Cadastro.class));
    }
}
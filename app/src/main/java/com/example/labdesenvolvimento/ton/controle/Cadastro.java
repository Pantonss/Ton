package com.example.labdesenvolvimento.ton.controle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.labdesenvolvimento.ton.MainActivity;
import com.example.labdesenvolvimento.ton.R;
import com.example.labdesenvolvimento.ton.modelo.User;
import com.example.labdesenvolvimento.ton.modelo.Util;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lab. Desenvolvimento on 26/10/2017.
 */

public class Cadastro extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

}

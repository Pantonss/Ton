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

public class Cadastro extends Activity implements View.OnClickListener {

    private Button cadastro;
    private TextView userData;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        cadastro = (Button) findViewById(R.id.cadastorCadastro);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, MainActivity.class));
        }
        user = firebaseAuth.getCurrentUser();

        showUserData();
    }

    @Override
    public void onClick(View v) {

        if(v == cadastro) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void showUserData() {
        new getDadosUsuario().execute();
    }

    public void editUserData(User usuario) {
        String info = "FirstName: " + usuario.getFirstName();
        info += "\nLastName: " + usuario.getLastName();
        info += "\nEmail: " + usuario.getEmail();
        info += "\nRg: " + usuario.getRg();
        info += "\nCpf: " + usuario.getCpf();
        info += "\n\nPhone: " + usuario.getPhone();
        info += "\n\nCellPhone: " + usuario.getCellPhone();
        info += "\n\nAdress: " + usuario.getAdress();
        info += "\n\nCep: " + usuario.getCep();
        info += "\n\nPassword: " + usuario.getPassword();
        info += "\n\nprovider: " + usuario.getProvider();

        userData.setText(info);
    }

    private class getDadosUsuario extends AsyncTask<Void,Void,User> {
        @Override
        public void onPreExecute(){
        }

        @Override
        public User doInBackground(Void... params){
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://localhost:9999/TON-WS/WS/Usuario/Cadastrar");
                con = (HttpURLConnection) url.openConnection();
                con.setReadTimeout(10000);
                con.setConnectTimeout(15000);
                con.setRequestMethod("POST");
                con.setDoInput(true);
                con.setDoOutput(true);

                Uri.Builder postBody = new Uri.Builder().appendQueryParameter("email", user.getEmail());
                String query = postBody.build().getEncodedQuery();

                OutputStream os = con.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                con.connect();

                String resultado = Util.streamToString(con.getInputStream());
                User usuario = Util.JSONToUsuario(resultado);
                return usuario;
            }
            catch (Exception e){
                e.printStackTrace();
            }finally {
                con.disconnect();
            }
            return null;
        }

        @Override
        public void onPostExecute(User usuario){
            editUserData(usuario);
        }
    }
}

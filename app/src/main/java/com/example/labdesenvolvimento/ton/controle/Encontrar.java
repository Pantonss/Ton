package com.example.labdesenvolvimento.ton.controle;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.labdesenvolvimento.ton.R;
import com.example.labdesenvolvimento.ton.modelo.User;
import com.example.labdesenvolvimento.ton.modelo.Util;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by may_s on 09/11/2017.
 */

public class Encontrar extends Activity{
    EditText pesquisar;
    Button encontrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encontrar);
        pesquisar = (EditText) findViewById(R.id.editEncontrar);
        encontrar = (Button) findViewById(R.id.buttonEncontrar);
        executeTasck();
    }
    public void executeTasck(){new APIConnection().execute();}



    private class APIConnection extends AsyncTask<Void,Void,User> {
        @Override
        public void onPreExecute() {
        }

        public User doInBackground(Void... params) {
            HttpURLConnection con = null;
            try {
                URL url = new URL("http://localhost:8180/TON-WS/WS/ListarSubcategoria");
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setDoInput(true);

                String resultado = Util.streamToString(con.getInputStream());
                User user = Util.JSONToUsuario(resultado);
                return user;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                con.disconnect();
            }

            return null;
        }
        @Override
        public void onPostExecute(User user){
            String info = "Trabalha : " + user.getSubcategoria();
            String info = "Nome : " + user.getFirstName();
            String info = "Sobre Nome : " + user.getLastName();
            String info = "Celular : " + user.getCellPhone();
            String info = "Telefone :" + user.getPhone();
            String info = "Endereço :" + user.getCep();

            pesquisar.setText(info);
        }

    }
}

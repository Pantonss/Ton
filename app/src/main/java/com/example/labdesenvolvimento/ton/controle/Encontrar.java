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
                URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Curitiba&mode=json&units=metric&cnt=1&appid=440b84a8027be4fcf90f9b83e4b45aa9");
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
            String info = "Cidade: " + user.getCidade();
            info += "\nTemperatura: " + user.getTemperatura();
            textInfo.setText(info);
        }

    }
}

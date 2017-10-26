package com.example.labdesenvolvimento.ton.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/**
 * Created by Lab. Desenvolvimento on 26/10/2017.
 */

public class Util {
    public static String streamToString(InputStream is){
        BufferedReader br;
        StringBuilder sb = new StringBuilder();

        br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static User JSONToUsuario(String jsonFile){

        JSONObject mainObj;
        User usuario = new User();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            mainObj = new JSONObject(jsonFile);

            usuario = new User();
            usuario.setIdUser(mainObj.getInt("idUser"));
            usuario.setProviderIdProvider(mainObj.getInt("providerIdProvider"));
            usuario.setFirstName(mainObj.getString("FirstName"));
            usuario.setLastName(mainObj.getString("LastName"));
            usuario.setEmail(mainObj.getString("Email"));
            usuario.setRg(mainObj.getString("Rg"));
            usuario.setCpf(mainObj.getString("Cpf"));
            usuario.setPhone(mainObj.getString("Phone"));
            usuario.setCellPhone(mainObj.getString("CellPhone"));
            usuario.setCep(mainObj.getString("Cep"));
            usuario.setPassword(mainObj.getString("Password"));
            usuario.setData(new java.sql.Date(format.parse(mainObj.getString("data")).getTime()));
            usuario.setProvider(mainObj.getString("provider"));
            usuario.setAdress(mainObj.getString("Adress"));



        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            return usuario;
        }
    }

}

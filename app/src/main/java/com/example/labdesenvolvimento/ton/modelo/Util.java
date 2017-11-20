package com.example.labdesenvolvimento.ton.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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


    public static String enviarPost(String pUrl, String pDados)
    {
        try
        {
            // Montando o objeto de conexï¿½o
            URL tUrl = new URL(pUrl);

            // Abrindo a conexï¿½o e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setDoOutput(true);
            tConexao.setRequestMethod("POST");
            tConexao.setRequestProperty("Content-Type", "application/json");

            if (pDados != null)
            {
                // Obtendo o canal de gravaï¿½ï¿½o e mandando os dados recebidos
                OutputStream tCanalSaida = tConexao.getOutputStream();
                tCanalSaida.write(pDados.getBytes());
                tCanalSaida.flush();
            }
            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarPut(String pUrl, String pDados)
    {
        try
        {
            // Montando o objeto de conexï¿½o
            URL tUrl = new URL(pUrl);

            // Abrindo a conexï¿½o e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setDoOutput(true);
            tConexao.setRequestMethod("PUT");
            tConexao.setRequestProperty("Content-Type", "application/json");
            if (pDados != null)
            {
                // Obtendo o canal de gravaï¿½ï¿½o e mandando os dados recebidos
                OutputStream tCanalSaida = tConexao.getOutputStream();
                tCanalSaida.write(pDados.getBytes());
                tCanalSaida.flush();
            }

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarGet(String pUrl)
    {
        try
        {
            // Montando o objeto de conexï¿½o
            URL tUrl = new URL(pUrl);

            // Abrindo a conexï¿½o e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setRequestMethod("GET");
            tConexao.setRequestProperty("Accept", "application/json");

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    public static String enviarDelete(String pUrl)
    {
        try
        {
            // Montando o objeto de conexï¿½o
            URL tUrl = new URL(pUrl);

            // Abrindo a conexï¿½o e mandando os headers
            HttpURLConnection tConexao = (HttpURLConnection) tUrl.openConnection();
            tConexao.setRequestMethod("DELETE");
            tConexao.setRequestProperty("Accept", "application/json");

            // Processando a resposta
            String tSaida = processarResposta(tConexao);

            // Retornando os dados recebidos
            return tSaida;
        }
        catch (IOException tExcept)
        {
            tExcept.printStackTrace();
            return null;
        }
    }

    private static String processarResposta(HttpURLConnection tConexao) throws IOException
    {
        // Verificando se o retorno foi OK
        if (tConexao.getResponseCode() != HttpURLConnection.HTTP_OK)
        {
            throw new RuntimeException("Erro na conexão do codigo de erro HTTP : " + tConexao.getResponseCode());
        }

        // Obtendo o canal de leitura da resposta
        BufferedReader tResposta = new BufferedReader(new InputStreamReader(tConexao.getInputStream()));

        // Lendo as linhas e concatenando
        String tSaida = "";
        while (true)
        {
            String tLinha = tResposta.readLine();
            if (tLinha == null)
                break;
            tSaida += tLinha;
        }

        // Fechando a conexï¿½o
        tConexao.disconnect();
        return tSaida;
    }
}

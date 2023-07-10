package service;

import com.google.gson.JsonObject;
import com.google.gson.Gson;

import dominio.Moeda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MoedaService {


    static String webService = "https://economia.awesomeapi.com.br/json/last/";
    static int codigoSucesso = 200;

    public static Moeda buscaMoeda(String code, String codein) throws Exception {

        String urlParaChamar = webService + code +"-"+ codein;

        try {

            URL url = new URL(urlParaChamar);

            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != codigoSucesso)

                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));

            String jsonString = Util.converteJsonEmString(resposta);

            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

            // parâmetro recebe a conversão que se  deseja realizar
            JsonObject usdbrObject = jsonObject.getAsJsonObject(code + codein);
            Moeda moeda = gson.fromJson(usdbrObject, Moeda.class);

            return moeda;

        } catch (Exception e) {

            throw new Exception("Erro: " + e);

        }
    }
}

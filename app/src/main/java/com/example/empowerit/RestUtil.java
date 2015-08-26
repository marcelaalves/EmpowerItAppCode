package com.example.empowerit;

import android.content.Context;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by Marcela on 23/08/15.
 */
public class RestUtil {

    public static Mensagem<String> get(Context c) {

        Mensagem<String> mensagem = new Mensagem<String>();
        String url = "https://api.smartcanvas.com/card/v1/cards/6258364619161600";
       String  token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ5WVNyOWlncm1Qa1IiLCJpYXQiOjE0MzgyNjY3OTEsImV4cCI6MTQ2OTgwMzA2Miwic3ViIjoicm9vdEBleGFtcGxlLmNvbSIsInJvb3QiOnRydWUsInRva2VuVHlwZSI6IkFDQ0VTUyIsImVtYWlsIjoicm9vdEBleGFtcGxlLmNvbSJ9.308YvI73sQM3IkCu_iIOQ1h55pAW9nZttG2xOVspdwE";
        String id = "kMRaR35PmKwZRqtEfznNkQUaiitKr0Ij";
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("token", token);
        httpGet.addHeader("id",id);

        try {

            HttpResponse response = httpClient.execute(httpGet);
            int status = response.getStatusLine().getStatusCode();

            switch(status) {
                case 200 : {

                    HttpEntity entity = response.getEntity();
                    InputStream instream = entity.getContent();

                    byte[] bytes = new byte[1024];
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int lidos;
                    while ((lidos = instream.read(bytes)) > 0) {
                        bos.write(bytes, 0, lidos);
                    }

                    String json = new String(bos.toByteArray());
                    instream.close();

                    mensagem.setStatus(StatusTarefa.HTTP_200);
                    mensagem.setAnexo(json);
                    break;

                }

            }

        } catch (Exception e) {

            mensagem.setStatus(StatusTarefa.EXCECAO);
            mensagem.setMensagem(mensagem.getMensagem());
            mensagem.setAnexo(e.getMessage());

            Log.e("ERROR", "ERROR", e);
        }

        return mensagem;

    }

    /**
     * Efetua o acesso ao serviÃ§o REST para envio de dados usando mÃ©todo POST.
     * @param c Contexto
     * @param url url completa do serviÃ§o REST, incluindo parÃ¢metros GET
     * @param json objeto JSON a ser postado no BODY da requisiÃ§Ã£o
     * @param token token de identificaÃ§Ã£o do usuÃ¡rio
     * @return  Mensagem com Status 200 e anexo igual ao JSON gerado pelo serviÃ§o REST,
     * se a requisiÃ§Ã£o for executada com sucesso. Mensagem com Status na faixa 400 e
     * mensagem detalhada de erro, caso contrÃ¡rio.
     */
    public static Mensagem<String> post(Context c, String url, String json, String token){
        int status;
        Mensagem<String> mensagem = new Mensagem<String>();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        HttpResponse resposta = null;

        httppost.addHeader("Content-type", "application/json");
        httppost.addHeader("token", token);

        try {

			/* Definindo o objeto Body*/
            httppost.setEntity(new StringEntity(json, "UTF8"));

            resposta = httpclient.execute(httppost);
            status = resposta.getStatusLine().getStatusCode();


            switch(status){
                case 200: {
                    mensagem.setStatus(StatusTarefa.HTTP_200);
                    break;
                }

            }

        } catch (Exception e) {

            mensagem.setStatus(StatusTarefa.EXCECAO);
            mensagem.setAnexo(e.getMessage());


        }

        return mensagem;
    }

    /**
     *
     * @param c contexto
     * @param url
     * @param nomesParams
     * @param valoresParams
     * @return
     */
   /* public static Mensagem<String> postSimples(Context c, String url, List<NameValuePair> params){

        int status;
        Mensagem<String> mensagem = new Mensagem<String>();
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        HttpResponse resposta = null;

        try {

            // AdiÃ§Ã£o dos parÃ¢metros

            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            resposta = httpclient.execute(httppost);
            status = resposta.getStatusLine().getStatusCode();

            String msgText = GerenteMensagem.recuperarMensagem(c,
                    Constantes.PREFIXO_MSG_HTTP + status);
            mensagem.setMensagem(msgText);
            switch(status){
                case 200: {
                    mensagem.setStatus(StatusTarefa.HTTP_200);
                    break;
                }
                default : {
                    mensagem.setStatus(StatusTarefa.valueOf(status));
                }
            }

        } catch (Exception e) {

            mensagem.setStatus(StatusTarefa.EXCECAO);
            String mensagemErro = c.getString(R.string.msg_erro_json);
            mensagem.setMensagem(mensagemErro);
            mensagem.setAnexo(e.getMessage());

            Log.e(Constantes.TAG, mensagemErro, e);

        }

        return mensagem;
    }*/
}

package io.github.mirents.Request;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author vadim
 */
public class RequestGet {
    static String sURL = "http://speller.yandex.net/services/spellservice";
    
    public static void main(String[] args) {
        CloseableHttpResponse resp = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=Апасный");
            
            resp = httpClient.execute(httpGet);
            
            System.out.println(EntityUtils.toString(resp.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

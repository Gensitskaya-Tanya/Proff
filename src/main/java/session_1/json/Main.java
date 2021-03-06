package session_1.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/** Отправили запрос
 * получили ответ в виде JSON
 * распарсили в обьект
 * обьект перевели обратно в     JSON
 *
 *
 * {
 * "query":{
 *      "count":2,
 *      "created":"2016-11-19T14:07:50Z",
 *      "lang":"en-US",
 *      "results":{
 *          "rate":
 *              [{
 *               "id":"USDEUR",
 *               "Name":"USD/EUR",
 *               "Rate":"0.9443",
 *               "Date":"11/18/2016",
 *               "Time":"10:33pm",
 *               "Ask":"0.9448",
 *               "Bid":"0.9443"},
 *              {
 *               "id":"USDUAH",
 *               "Name":"USD/UAH",
 *               "Rate":"25.8500",
 *               "Date":"11/18/2016",
 *               "Time":"10:26pm",
 *               "Ask":"26.1000",
 *               "Bid":"25.8500"}
 *               ]
 *              }
 *         }
 * }
 */
public class Main {
    
    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=json&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        String result = performRequest(request);
        System.out.println(result);




        Gson gson = new GsonBuilder().create();
        JSON json = (JSON) gson.fromJson(result, JSON.class);

        for (Rate rate : json.query.results.rate) {
            System.out.println(rate.id + "=" + rate.Rate);
        }
        
        System.out.println("JSON: \n\t" + gson.toJson(json));
    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }

}
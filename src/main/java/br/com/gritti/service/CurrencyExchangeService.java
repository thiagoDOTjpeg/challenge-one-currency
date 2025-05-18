package br.com.gritti.service;

import br.com.gritti.entities.apiresponse.PairConvertionRateResponse;
import br.com.gritti.entities.responses.ConvertedResponse;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class CurrencyExchangeService {
  private final Dotenv dotenv = Dotenv.configure().load();
  private final String apiKey = dotenv.get("API_KEY");
  private final String apiUrl = dotenv.get("API_URL");
  private final HttpClient client = HttpClient.newHttpClient();
  private final Gson gson = new Gson();
  private final LinkedHashMap<Date, ConvertedResponse> history = new LinkedHashMap<>();

  public String getConvertionRateFrom(String from, String to, double amount) throws IOException, InterruptedException {
    URI url = URI.create(apiUrl + "/" + apiKey + "/pair/" + from + "/" + to);
    HttpRequest request = HttpRequest.newBuilder().uri(url).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    PairConvertionRateResponse responseBody = gson.fromJson(response.body(), PairConvertionRateResponse.class);
    if (response.statusCode() != 200) throw new IOException("Erro ao obter a taxa de conversão");
    ConvertedResponse convertedData = new ConvertedResponse(amount, from, to, responseBody.getConversion_rate(), amount * responseBody.getConversion_rate());
    history.put(new Date(), convertedData);
    return gson.toJson(convertedData);
  }

  public List<Map.Entry<Date, ConvertedResponse>> getHistory() {
    return new ArrayList<>(history.entrySet());
  }
}

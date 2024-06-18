package conversorApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConversorApi {
    private String base_code;
    private String target_code;
    private String conversion_rate;
    private double amount;
    private String apiKey;
    List<Conversor> listConversor = new ArrayList<>();

    public ConversorApi(Conversor conversor){
        this.base_code = conversor.getBase_code();
        this.target_code = conversor.getTarget_code();
        this.amount = conversor.getValor();
    }

    public String chamadaApi(){
        this.apiKey = "cd990863185f55895b4bfffd";
        String uriConsulta = this.apiKey + "/pair/" + this.base_code + "/" + this.target_code + "/" + this.amount;

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/" + uriConsulta);


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            Conversor conversor = gson.fromJson(json, Conversor.class);
            listConversor.add(conversor);
            return conversor.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro!!");
            //return "Erro" + e.getMessage();
        }

    }

    public List<Conversor> getListConversor(){
        return listConversor;
    }

}
package Logica;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarApi {

//4) Construir el HTTPClient con Request Y response
    private void creadorDeUrl(){
        String dirrecion = "https://v6.exchangerate-api.com/v6/72806b28397c13815d22c528/latest/";//Agregar valor desde itemBox
    }
    private String SolicitarApi(String dirrecion){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(dirrecion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e); //Agregar Pop up de Swing
        }

    }
}

package Logica;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//Importamos los paquetes con la clases necesarias para construir la consulta al API
public class ConsultarApi {


//El metodo crearURL construira junto con el APIKEY la consulta en base al codigo
//moneda proporcionado por el usuario y devolvera el URL

    public String crearURL(String codigoMoneda){
        return "https://v6.exchangerate-api.com/v6/72806b28397c13815d22c528/latest/" + codigoMoneda ;
    }
    //El cuerpo de la consulta URL Creando Un HttpClient, HttpRequest en base el url construido y luego devolviendo el Json Crudo
    public String SolicitarApi(String codigoMoneda){
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(crearURL(codigoMoneda)))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

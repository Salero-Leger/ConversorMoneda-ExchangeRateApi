package Logica;

import com.google.gson.Gson;

public class SerializacionJson {
    //Con GSON y consultando la API obtenemos los datos y lo asignamos a los valores del Record.
    public Moneda convertirJson(String codigoMoneda){
        ConsultarApi consultarApi = new ConsultarApi();
        String json = consultarApi.SolicitarApi(codigoMoneda);
        Gson gson = new Gson();
        return gson.fromJson(json, Moneda.class);
    }
}

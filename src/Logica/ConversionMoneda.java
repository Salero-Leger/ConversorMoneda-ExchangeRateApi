package Logica;

public class ConversionMoneda {

    //Inicializamos los atributos y objetos necesarios;
    private String codigoMonedaDesde;
    private String codigoMonedaHacia;
    private double valorUsuario;
    private SerializacionJson serializacionJson = new SerializacionJson();
    private Moneda moneda;
    //Metodo inicializarMoneda asigna valores y empieza la llamada de la serializacionJson
    public void inicializarMoneda(String codigoMoneda){
        this.codigoMonedaDesde = codigoMoneda;
        this.moneda = serializacionJson.convertirJson(codigoMoneda);
    }
    //Getter y setter
    public void setCodigoMonedaDesde(String codigoMoneda) {
        this.codigoMonedaDesde = codigoMoneda;
    }
    public void setCodigoMonedaHacia(String codigoMoneda) {
        this.codigoMonedaHacia = codigoMoneda;
    }

    public String getCodigoMonedaDesde(){
        return this.codigoMonedaDesde;

    }    public String getCodigoMonedaHacia(){
        return this.codigoMonedaHacia;
    }
    public void setValorUsuario(double valor){
        this.valorUsuario = valor;
    }
    //MetodoObtenerValorConvertido llama los datos del usuario y al objeto moneda que posee un hasmap consultando sus valores y realizando la conversión final
    public double ObtenervalorConvertidos(){
        Double valorHacia = moneda.conversion_rates().get(getCodigoMonedaHacia());

        if (valorHacia == null) {
            throw new RuntimeException("La moneda '" + getCodigoMonedaHacia() + "' no está disponible o es inválida.");
        }

        return this.valorUsuario * valorHacia;
    }
    }




package Logica;

public class Menu {
    // Inicializo los objetos necesarios para el flujo del menú
    static ConversionMoneda conversionMoneda = new ConversionMoneda();
    static ConsultarApi consultarApi = new ConsultarApi();

    public static void mostrarMenu() {
        System.out.println("""
                      - Bienvenido al Conversor de moneda-
                                ______________
                    __,.,---'''''              '''''---..._
                 ,-'             .....:::''::.:            '`-.
                '           ...:::.....       '
                            ''':::'''''       .               ,
                |'-.._           ''''':::..::':          __,,-
                 '-.._''`---.....______________.....---''__,,-
                      ''`---.....______________.....---''
                
                Sugerencias de monedas más populares:
                USD(Dolar),ARS(Peso argentino), BRL(Real brasileño),COP(Peso colombiano)""");


        try {
            //Preguntar por el código de moneda
            System.out.print("\nEscriba el código de moneda desde la que va a convertir: ");
            String codigoDesde = DatosConsola.introducirDatos().toUpperCase(); // Convert to uppercase for uniformity

            //Llamamos al metodo que inicializa la ruta para consultar a la API
            conversionMoneda.inicializarMoneda(codigoDesde);

            //Preguntamos hacia que moneda el quiero convertir
            System.out.print("Escriba el código de moneda hacia donde va a convertir: ");
            String codigoHacia = DatosConsola.introducirDatos().toUpperCase(); // Convert to uppercase for uniformity
            conversionMoneda.setCodigoMonedaHacia(codigoHacia);

            //Dejamos ver al usuario que moneda seleccionar
            System.out.printf("""
                    \n
                    
                            -Conversor de moneda-
                                    ______________
                        __,.,---'''''              '''''---..._
                     ,-'             .....:::''::.:            '`-.
                    '           ...:::.....       '
                                ''':::'''''       .               ,
                    |'-.._           ''''':::..::':          __,,-
                     '-.._''`---.....______________.....---''__,,-
                          ''`---.....______________.....---''
                    
                    Desde: %s
                    Hacia: %s
                    Ingrese el total a convertir:""", conversionMoneda.getCodigoMonedaDesde(),conversionMoneda.getCodigoMonedaHacia());

            //Obtenemos el valor del usuario para la conversión posterior
            double valorUsuario = DatosConsola.introducirValorNumerico();
            conversionMoneda.setValorUsuario(valorUsuario);

            //Vemos el resultado final
            System.out.printf("Su valor convertido desde: %s, Hacia: %s, Es igual a %.2f %s",
                    conversionMoneda.getCodigoMonedaDesde(),
                    conversionMoneda.getCodigoMonedaHacia(),
                    conversionMoneda.ObtenervalorConvertidos(),
                    conversionMoneda.getCodigoMonedaHacia());
        } catch (RuntimeException e) {
            System.out.println("\nSu códigos fueron: "+ conversionMoneda.getCodigoMonedaDesde() +"|"+ conversionMoneda.getCodigoMonedaHacia());
            System.out.println("Inténtelo de nuevo con códigos de moneda válidos.");

        }
        //Preguntamos al usuario si quiere salir para mantener el while del principal
        System.out.println("\nIngrese el valor de 0 para continuar o 1 para salir.");

    }


}

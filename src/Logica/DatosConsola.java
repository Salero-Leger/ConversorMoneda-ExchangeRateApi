package Logica;
import java.util.Scanner;
public class DatosConsola {
    static Scanner teclado = new Scanner(System.in);
//Los metodos de esta clase funcionan para utilizar Scanner para ingresar datos por consola
    static public String introducirDatos() {
        String datosUsuario = teclado.nextLine();
        return datosUsuario;
    }
    static public double introducirValorNumerico() {
        try {
            String entrada = teclado.nextLine();
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor ingrese un valor numérico válido.");
            return introducirValorNumerico();
        }
    }
}

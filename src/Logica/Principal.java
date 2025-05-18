package Logica;

import java.io.IOException;

public class Principal {
    public static void main(String[] args){
        //Bucle do while para mantener el programa hasta que el usuario decida Salir
        int salidaUsuario = 0;
        do {
            try {
                Menu.mostrarMenu();
                salidaUsuario = Integer.parseInt(DatosConsola.introducirDatos());
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
                e.printStackTrace();
            }
        }while (salidaUsuario !=1);
        System.out.println("Vuelva pronto!!");



}
}

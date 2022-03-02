package Frontera;

import Contolador.GestorTienda;

import java.util.Scanner;

public class Menu {

    public static void menuInicial() {
        GestorTienda gestorTienda = new GestorTienda();
        gestorTienda.cargarProductos("src/Files/ProductosPancitaFeliz.txt");
        gestorTienda.cargarTiendas("src/Files/TiendasClientesPancitaFeliz.txt");

        //TODO: Inicializacion del objeto gestor tienda
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("¡¡BIENVENIDO A PANCITA FELIZ!! \n");
            System.out.println("1.Ver Productos");
            System.out.println("2.Ver Tiendas");
            System.out.println("Elija Una Opcion");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    //TODO: Muestra los productos
                    break;
                case 2:
                    //TODO: Muestra las tiendas registradas
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        }while (opcion != 0);
    }
}

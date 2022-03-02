package Frontera;

import Contolador.GestorTienda;

import java.util.Scanner;

public class Menu {

    public static void menuInicial() {
        GestorTienda gestorTienda = new GestorTienda();
        gestorTienda.cargarProductos("D:\\Documents\\MATERIALES\\Material Virtual\\2022-1\\Software 1\\Taller 1 Poo\\ProductosPancitaFeliz.txt");
        gestorTienda.cargarTiendas("D:\\Documents\\MATERIALES\\Material Virtual\\2022-1\\Software 1\\Taller 1 Poo\\TiendasClientesPancitaFeliz.txt");

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

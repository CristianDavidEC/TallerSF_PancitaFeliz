package Frontera;

import Contolador.GestorTienda;
import Entidades.Producto;
import Entidades.TiendaCliente;
import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que se encarga de todos los dialogos e informacion que va a usar el usuario
 */
public class Menu {
    /**
     * Menu Principal de ejecucion del programa
     */
    public static void menuInicial() {
        GestorTienda gestorTienda = new GestorTienda();
        gestorTienda.cargarProductos("src/Files/ProductosPancitaFeliz.txt");
        gestorTienda.cargarTiendas("src/Files/TiendasClientesPancitaFeliz.txt");

        //TODO: Inicializacion del objeto gestor tienda
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("¡¡BIENVENIDO A PANCITA FELIZ!! \n");
            System.out.println("1.Ver Productos");
            System.out.println("2.Ver Tiendas");
            System.out.println("Elija Una Opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(gestorTienda.getProductos());
                    break;
                case 2:
                    mostrarTiendas(gestorTienda.getTiendas());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public static void mostrarProductos(ArrayList<Producto> productos){
        for (Producto p: productos) {
            System.out.println(p.getCodigoProducto() +" - "+ p.getNombreProducto() +" - "+ p.getValorUnitario());
        }
    }
    public static void mostrarTiendas(ArrayList<TiendaCliente> tiendas){
        for (TiendaCliente t: tiendas) {
            System.out.println(t.getCodigoTienda() +" - "+ t.getNombreTienda());
        }
    }
}

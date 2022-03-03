package Frontera;
import Contolador.GestorTienda;
import Entidades.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import jdk.swing.interop.SwingInterOpUtils;
import javax.swing.*;
/**
 * Clase que se encarga de todos los dialogos e informacion que va a usar el usuario
 */
public class Menu {
    /**
     * Menu Principal de ejecucion del programa
     */
    GestorTienda gestorTienda;

    /**
     * Cuando se crea el objeto Menu en en main se carga la informacion de la tienda
     *
     * @param gestorTienda
     */
    public Menu(GestorTienda gestorTienda) {
        this.gestorTienda = gestorTienda;
        gestorTienda.cargarProductos();
        gestorTienda.cargarTiendas();
    }

    public void menuInicial() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n ¡¡BIENVENIDO A PANCITA FELIZ!! \n");
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

    public void mostrarProductos(ArrayList<Producto> productos) {
        for (Producto p : productos) {
            System.out.println(p.getCodigoProducto() + " - " + p.getNombreProducto() + " - " + p.getValorUnitario());
        }
    }

    public void mostrarTiendas(ArrayList<TiendaCliente> tiendas) {
        System.out.println("Seleccione una tienda para registrar una orden:");
        System.out.println("Lista de Tiendas vinculadas");
        int opcion;
        do {
            int valor = 1;
            for (TiendaCliente t : tiendas) {
                System.out.println(valor + ")" + t.getCodigoTienda() + " - " + t.getNombreTienda());
                valor++;
            }
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            if (opcion <= tiendas.size()) {
                crearOrden(tiendas.get(opcion - 1));
                opcion = 0;
            }
        } while (opcion != 0);
    }

    public void crearOrden(TiendaCliente tienda) {
        System.out.println("REGISTRO ORDEN PARA LA TIENDA: \n" +
                tienda.getCodigoTienda() + " " + tienda.getNombreTienda());

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los valores Solicitados");

        System.out.print("Codigo de Vendedor: ");
        String codigoVendedor = sc.nextLine();

        System.out.print("Nombre Vendedor: ");
        String nombreVendedor = sc.nextLine();

        System.out.print("Fecha de la Venta: ");
        System.out.println(" ");
        String fechaVenta = sc.next();

        Orden orden = new Orden(codigoVendedor, nombreVendedor, fechaVenta);
        String ruta = VentanaArchivo();
        try {
            orden.cargarPedidos(ruta, getGestorTienda());
            tienda.setOrden(orden);
            mostrarOrdenDeTienda(tienda);
        } catch (ProductoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarOrdenDeTienda (TiendaCliente tienda) {
        System.out.println("!! ORDEN DE LA TIENDA ¡¡");
        System.out.println("------------------------------------");
        System.out.println("Codigo de la tienda: " + tienda.getCodigoTienda() +"\n"
                    +"Nombre de la tienda: "+ tienda.getNombreTienda() +"\n"
                    +"Codigo Vendedor:"+ tienda.getOrden().getCodigoVededor() +"\n"
                    +"Nombre Vendedor:"+ tienda.getOrden().getNombreVendedor() +"\n"
                    +"Fecha:"+ tienda.getOrden().getFechaVenta() +"\n");
        System.out.println("Lista de Productos Solicitados");

        for (Pedido p: tienda.getOrden().getPedidos()) {
            System.out.println("------------------------------------------");
            System.out.println("Codigo Producto: "+ p.getProducto().getCodigoProducto() +"\n"
                                +"Nombre Producto: "+ p.getProducto().getNombreProducto() +"\n"
                                +"Valor Unitario: "+ p.getProducto().getValorUnitario() +"\n"
                                +"Cantidad Solicitada: "+ p.getCantidadPedida());
        }
    }

    /**
     * Creacion ventana para seleccionar manualmente un archivo de pedido
     * */
    public static String VentanaArchivo () {
        String ruta;
        Scanner entrada = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        try {
            return ruta = fileChooser.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        return null;
    }

    public GestorTienda getGestorTienda() {
        return gestorTienda;
    }
}



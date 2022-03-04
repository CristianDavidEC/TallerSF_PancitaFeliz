package Frontera;
import Contolador.GestorTienda;
import Entidades.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
    }

    public void menuInicial() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n ¡¡BIENVENIDO A PANCITA FELIZ!! \n");
            System.out.println("1.Ver Productos");
            System.out.println("2.Ver Tiendas");
            System.out.println("3.Crear Orden para Una Tienda");
            System.out.println("4.Ver Orden De Una Tienda");
            System.out.print("Elija Una Opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(gestorTienda.getProductos());
                    break;
                case 2:
                    verTiendas(gestorTienda.getTiendas());
                    break;
                case 3:
                    elegirTienda(gestorTienda.getTiendas());
                    break;
                case 4:
                    //TODO:Ver la orden ya creada de una tienda
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public void mostrarProductos(ArrayList<Producto> productos) {
        Comparator<Producto> comparador = Comparator.comparing(Producto::getNombreProducto);
        List<Producto>lista= productos.stream().sorted(comparador).toList();
        for (Producto p : lista) {
            System.out.println(p.getCodigoProducto() + " - " + p.getNombreProducto() + " - " + p.getValorUnitario());
        }
    }

    public void  verTiendas (ArrayList<TiendaCliente> tiendas) {
        System.out.println("\n Lista de Tiendas vinculadas");
        System.out.println("--------------------------------");
        int valor = 1;
        for (TiendaCliente t : tiendas) {
            System.out.println(valor + ")" + t.getCodigoTienda() + " - " + t.getNombreTienda());
            valor++;
        }
    }

    public void elegirTienda(ArrayList<TiendaCliente> tiendas) {
        int opcion;
        do {
            verTiendas(tiendas);
            System.out.print("Seleccione una tienda para registrar una orden: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            if (opcion <= tiendas.size()&& opcion > 0) {
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
        DateTimeFormatter fechaVenta = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        System.out.println(fechaVenta.format(LocalDateTime.now()));
        System.out.println(" ");

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

        //ordenarProductos(gestorTienda.getProductos());

        for (Pedido p: tienda.getOrden().getPedidos()) {
            System.out.println("------------------------------------------");
            System.out.println("Codigo Producto: "+ p.getProducto().getCodigoProducto() +"\n"
                                +"Nombre Producto: "+ p.getProducto().getNombreProducto() +"\n"
                                +"Valor Unitario: "+ p.getProducto().getValorUnitario() +"\n"
                                +"Cantidad Solicitada: "+ p.getCantidadPedida());
            System.out.println("------------------------------------------");
            System.out.println("Valor total: "+p.getValorTotal());
        }
    }
    public void ordenarProductos (List<Producto> productos) {
        Comparator<Producto> comparador = Comparator.comparing(Producto::getNombreProducto);
        List<Producto>lista= productos.stream().sorted(comparador).toList();
        for (Producto p: lista){
            System.out.println(p.getNombreProducto());
            System.out.println(p.getCodigoProducto());
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
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fileChooser.setFileFilter(filtro);
        try {
            return ruta = fileChooser.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public GestorTienda getGestorTienda() {
        return gestorTienda;
    }
}



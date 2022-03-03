package Contolador;
import Entidades.Producto;

import Entidades.TiendaCliente;
import java.util.ArrayList;

public class GestorTienda {
    private ArrayList<Producto> productos;
    private ArrayList<TiendaCliente> tiendas;

    public GestorTienda() {
        this.productos = new ArrayList<Producto>();
        this.tiendas = new ArrayList<TiendaCliente>();
    }

    /**
     * Carga el archivo de productos y los crea
     */
    public void cargarProductos (String ruta) {
        Archivo archivo = new Archivo();
        ArrayList<String[]> datos = archivo.leerArchivo(ruta);
        for (String[] dato: datos) {
            Producto producto = new Producto(dato[0], dato[1], Double.parseDouble(dato[2]));
            this.productos.add(producto);
        }
    }

    /**
     * Carga del archivo de las tienda y crea las entidades de esta
     */
    public void cargarTiendas (String ruta) {
        Archivo archivo = new Archivo();
        ArrayList<String[]> datos = archivo.leerArchivo(ruta);
        for (String[] dato: datos) {
            TiendaCliente tienda = new TiendaCliente(dato[0], dato[1]);
            this.tiendas.add(tienda);
        }
    }

    /**
     * Busca un producto por codigo del mismo, sino no encuntra retorna null
     * @param codigoProducto
     * @return p, null
     */
    public Producto buscarProducto (String codigoProducto) {
        for (Producto p : this.productos ) {
            if(p.getCodigoProducto().equals(codigoProducto)){
                return p;
            }
        }
        return null;
    }

    //------------ Gets ---------------------
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<TiendaCliente> getTiendas() {
        return tiendas;
    }
}

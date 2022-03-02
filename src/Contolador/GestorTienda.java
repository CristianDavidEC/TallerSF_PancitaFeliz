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

    public void cargarProductos (String path){
        ArrayList<String[]> datos = Archivo.leerArchivo(path);
        for (String[] dato: datos) {
            Producto producto = new Producto(dato[0], dato[1], Double.parseDouble(dato[2]));
            this.productos.add(producto);
        }
    }

    public void cargarTiendas (String path){
        ArrayList<String[]> datos = Archivo.leerArchivo(path);
        for (String[] dato: datos) {
            TiendaCliente tienda = new TiendaCliente(dato[0], dato[1]);
            this.tiendas.add(tienda);
        }
    }

    //------------ Gets ---------------------
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public ArrayList<TiendaCliente> getTiendas() {
        return tiendas;
    }
}

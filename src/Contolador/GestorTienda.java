package Contolador;

import Entidades.Producto;
import Entidades.TiendaCliente;

import java.util.ArrayList;

public class GestorTienda {
    private ArrayList<Producto> productos;
    private ArrayList<TiendaCliente> tiendas;

    public void cargarProductos (String path){
        ArrayList<String[]> datos = Archivo.leerArchivo(path);

        for (String[] dato: datos) {
            System.out.println(dato[0] +" "+ dato[1] +" "+ dato[2]);
        }

    }

}

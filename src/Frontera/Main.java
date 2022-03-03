package Frontera;

import Contolador.GestorTienda;
import Entidades.Producto;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GestorTienda gestorTienda = new GestorTienda("src/Files/ProductosPancitaFeliz.txt",
                                    "src/Files/TiendasClientesPancitaFeliz.txt");
        Menu menu = new Menu(gestorTienda);
        menu.menuInicial();
    }
}


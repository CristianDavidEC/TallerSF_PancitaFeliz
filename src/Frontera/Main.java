package Frontera;

import Contolador.GestorTienda;
import Entidades.Producto;
import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;

/**
 * PRIMER PROYECTO DE INGENIERIA DE SOFTWARE 1
 * MANUELA RENDON DE LA PAVA
 * CRISTIAN DAVID ESCOBAR CASTILLO
 * DIAGRAMA DE CLASES: https://drive.google.com/file/d/1LKgkO5orrrhM9_CelzQLopvtuL-mBXVm/view?usp=sharing
 * REPOSITORIO: https://github.com/CristianDavidEC/TallerSF_PancitaFeliz.git
 */
public class Main {
    public static void main(String[] args) {
        GestorTienda gestorTienda = new GestorTienda();
        gestorTienda.cargarProductos("src/Files/ProductosPancitaFeliz.txt");
        gestorTienda.cargarTiendas("src/Files/TiendasClientesPancitaFeliz.txt");
        Menu menu = new Menu(gestorTienda);
        menu.menuInicial();
    }
}


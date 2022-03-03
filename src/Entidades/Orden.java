package Entidades;

import Contolador.Archivo;
import Contolador.GestorTienda;

import java.util.ArrayList;
import java.util.Date;

public class Orden {
    private String codigoVededor;
    private String NombreVendedor;
    private String fechaVenta;
    private ArrayList<Pedido> pedidos;

    public Orden(String codigoVededor, String nombreVendedor, String fechaVenta) {
        this.codigoVededor = codigoVededor;
        NombreVendedor = nombreVendedor;
        this.fechaVenta = fechaVenta;
        this.pedidos = new ArrayList<Pedido>();
    }

    /**
     * Carga el archivo del cliente con los pedidos, busca el producto y
     * llena la lista de pedidos del cliente, si un producto no se encuentra
     * produce una excepcion.
     * @param pathArchivo
     */
    public void cargarPedidos (String pathArchivo, GestorTienda gestorTienda)
    throws ProductoException{
        Archivo archivo = new Archivo();
        ArrayList<String[]> datos = archivo.leerArchivo(pathArchivo);
        for (String[] dato: datos) {
            int cantidad = Integer.parseInt(dato[1]);
            Producto prod = gestorTienda.buscarProducto(dato[0]);
            if (prod == null) {
                throw new ProductoException("El producto con id "+dato[0]+ " NO es valido, porfavor verifique el archivo.");
            }
            Pedido pedido = new Pedido(cantidad, prod, calcularValor(cantidad, prod.getValorUnitario()));
            this.pedidos.add(pedido);
        }
    }

    public double calcularValor (int cantidad, double valorUnitario) {
        return cantidad * valorUnitario;
    }

    //-------------Sets & Gets--------------
    public String getCodigoVededor() {
        return codigoVededor;
    }

    public void setCodigoVededor (String codigoVededor) {
        this.codigoVededor = codigoVededor;
    }

    public String getNombreVendedor () {
        return NombreVendedor;
    }

    public void setNombreVendedor (String nombreVendedor) {
        NombreVendedor = nombreVendedor;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta (String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos (ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

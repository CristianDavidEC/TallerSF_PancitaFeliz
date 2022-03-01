package Entidades;

import java.util.ArrayList;
import java.util.Date;

public class Orden {
    private String codigoVededor;
    private String NombreVendedor;
    private Date fechaVenta;
    private double valorTotal;
    private ArrayList<Pedido> pedidos;

    public Orden(String codigoVededor, String nombreVendedor, Date fechaVenta, double valorTotal, ArrayList<Pedido> pedidos) {
        this.codigoVededor = codigoVededor;
        NombreVendedor = nombreVendedor;
        this.fechaVenta = fechaVenta;
        this.valorTotal = valorTotal;
        this.pedidos = pedidos;
    }

    //-------------Sets & Gets--------------
    public String getCodigoVededor() {
        return codigoVededor;
    }

    public void setCodigoVededor(String codigoVededor) {
        this.codigoVededor = codigoVededor;
    }

    public String getNombreVendedor() {
        return NombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        NombreVendedor = nombreVendedor;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}

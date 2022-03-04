package Entidades;

public class Pedido {
    private int cantidadPedida;
    private Producto producto;
    private double valorTotal;

    public Pedido(int cantidadPedida, Producto producto, double valorTotal) {
        this.cantidadPedida = cantidadPedida;
        this.producto = producto;
        this.valorTotal = valorTotal;
    }

    //-------------Sets & Gets--------------

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}

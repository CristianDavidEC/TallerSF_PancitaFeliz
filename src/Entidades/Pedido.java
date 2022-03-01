package Entidades;

public class Pedido {
    private int cantidadPedida;
    private Producto producto;

    public Pedido(int cantidadPedida, Producto producto) {
        this.cantidadPedida = cantidadPedida;
        this.producto = producto;
    }

    //-------------Sets & Gets--------------
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

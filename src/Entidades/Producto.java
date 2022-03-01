package Entidades;
/**
 *Define los productos de la tienda
 */
public class Producto {

    private String codigoProducto;
    private String nombreProducto;
    private double valorUnitario;

    public Producto(String codigoProducto, String nombreProducto, double valorUnitario) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.valorUnitario = valorUnitario;
    }

    //-------------Sets & Gets--------------
    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}

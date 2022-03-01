package Entidades;

public class TiendaCliente {
    private String codigoTienda;
    private String nombreTienda;
    private Orden orden;

    public TiendaCliente(String codigoTienda, String nombreTienda, Orden orden) {
        this.codigoTienda = codigoTienda;
        this.nombreTienda = nombreTienda;
        this.orden = orden;
    }

    //-------------Sets & Gets--------------
    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}

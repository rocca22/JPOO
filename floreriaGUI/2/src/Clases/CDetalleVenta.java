package Clases;
import java.util.ArrayList;
import java.util.List;
import conexion.conector;

public class CDetalleVenta {
    private int idVenta;
    private int idProducto; // Es una flor ....
    private int cantidad;
    private Double descuento;
    private double precio;
    public CDetalleVenta() {
        this.idVenta =0;
        this.idProducto = 0;
        this.cantidad = 0;
        this.descuento = 0.0;
        this.precio = 0;
    }
    public CDetalleVenta(int idVenta, int idProducto, int cantidad, Double descuento, double precio) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
    }

    public void save(){
        conector c = new conector();

        String consulta = "call crearDetalle("+
                this.idVenta+","+
                this.idProducto+","+
                this.precio+","+
                this.cantidad+","+
                this.descuento+");";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
        System.out.println("Se añadio correctamente la venta ");
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

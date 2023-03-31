package Clases;

import conexion.conector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CDocumentoVenta {
    private int IdDocVenta;
    private String tipoDocumento;
    private String nroDocumento;
    private String fechaVenta;
    private int idVendedor;
    private int idCliente;
    private double precioTotal;  // Suma de precios de los detalles de venta
    private double igv; // Al precio total
    private double descuento;
    private String estado;

    public CDocumentoVenta() {
        this.IdDocVenta =0;
        this.tipoDocumento = "";
        this.nroDocumento = "";
        this.idVendedor = 0;
        this.idCliente = 0;
        this.fechaVenta ="";
        this.precioTotal = 0;
        this.igv = 0.18;
        this.descuento =0;
        this.estado = "";
    }


    public CDocumentoVenta(String tipoDocumento, String nroDocumento, String fechaVenta, int idVendedor, int idCliente, double precioTotal, double igv, double descuento, String estado) {
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.fechaVenta = fechaVenta;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.precioTotal = precioTotal;
        this.igv = igv;
        this.descuento = descuento;
        this.estado = estado;
    }



    public String save(){
        conector c = new conector();

        String consulta = "select creardocventalasID('"+
                this.tipoDocumento+"','"+
                this.nroDocumento+"',"+
                this.idCliente+","+
                this.idVendedor+",'"+
                this.fechaVenta+"',"+
                this.precioTotal+","+
                this.igv+","+
                this.descuento+",'"+
                this.estado+"');";
        System.out.println(consulta);
        data = c.ejecutarProcedimientoConDatos(consulta);
        String ID = "";
        for (List<String> dato: data ) {
            ID = dato.get(0);
        }
        return ID;
    }



    private static List<List<String>> data = new ArrayList<List<String>>();
    /*
    pidDocventa int,
ptipodocumento varchar(45),
pnumdocumento varchar(45) ,
pidcliente int,
pidvendedor int ,
pfechaventa date ,
ppreciototal double ,
pigv double ,
pdescuento double ,
pestado varchar(45)
     */
    public  void  update(){
        conector c = new conector();
        String consulta = "call actualizarDocVenta("+
                this.IdDocVenta+",'"+
                this.tipoDocumento+"','"+
                this.nroDocumento+"',"+
                this.idCliente+","+
                this.idVendedor+",'"+
                this.fechaVenta+"',"+
                this.precioTotal+","+
                this.igv+","+
                this.descuento+",'"+
                this.estado+"');";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }

    public static List<List<String>> mostrarVenta(String pIdVenta) {
        List<List<String>> data = null;
        try {
            conector conexion = new conector();
            String consulta = "";
            if (pIdVenta.compareTo("") == 0) {
                consulta = "call listaDocVenta('PAGADO');";
            } else {
                consulta = "select * from tdocumentoventa where iddocumentoventa = " + pIdVenta + ";";
            }
            data = conexion.ejecutarProcedimientoConDatos(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    public int getIdDocVenta() {
        return IdDocVenta;
    }

    public void setIdDocVenta(int idDocVenta) {
        IdDocVenta = idDocVenta;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

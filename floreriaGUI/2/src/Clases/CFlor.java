package Clases;

import java.util.Date;
import java.util.List;

import conexion.conector;

public class CFlor {
    // ATRIBUTOS - Caracteristicas - Propiedades del objeto de la realidad
    private int idflor = 0;
    private String nombre;
    private String aroma;
    private String color;
    private double precio;
    private int stock = 0;
    private String fcreacion = null;
    private String estado;

    // MÉTODOS
    // M. contructores
    public CFlor(){
        this.idflor = 0;
        this.nombre="";
        this.aroma="";
        this.color="";
        this.precio=0.0;
        this.estado = "";
        this.fcreacion = null;
        this.stock = 0;
    }

    public CFlor(String pNombre, String pAroma, String pColor, double pPrecio, int pstock, String pfcreacion, String pestado){
        nombre = pNombre;
        aroma = pAroma;
        color = pColor;
        precio = pPrecio;
        stock = pstock;
        fcreacion = pfcreacion;
        estado = pestado;
    }

    // M. Getters

    public int getIdflor() {
        return idflor;
    }

    public void setIdflor(int idflor) {
        this.idflor = idflor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAroma() {
        return aroma;
    }

    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(String fcreacion) {
        this.fcreacion = fcreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public static List<List<String>> mostrarFlores(String pIdFlor) {
        List<List<String>> data = null;
        try {
            conector conexion = new conector();
            String consulta = "";
            if (pIdFlor.compareTo("") == 0) {
                consulta = "call listarFlores('ACTIVO');";
            } else {
                consulta = "select * from tflor where idFlor = " + pIdFlor + ";";
            }
            data = conexion.ejecutarProcedimientoConDatos(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void save(){
        conector c = new conector();
        String consulta = "call crearFlor('"
                          + this.nombre+"','"
                          + this.aroma +"','"
                          + this.color + "', "
                          + this.precio + ","
                          + this.stock + ",'"
                          + this.fcreacion+ "', '"
                          + this.estado + "');";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }
    public void update(){
        conector c = new conector();
        String consulta = "call actualizarFlor("
                + this.idflor+",'"
                + this.nombre+"','"
                + this.aroma +"','"
                + this.color + "', "
                + this.precio + ","
                + this.stock + ",'"
                + this.fcreacion + "', '"
                + this.estado + "')";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }




}

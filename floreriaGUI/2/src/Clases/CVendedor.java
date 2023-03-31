package Clases;
import conexion.conector;

import java.util.List;

public class CVendedor {
    private int idVendedor;
    private String tipoDocumento;
    private String numDocumento;
    private String nombres;
    private String apellidos;
    private String correo;

    public Double getComision() {
        return comision;
    }

    public void setComision(Double comision) {
        this.comision = comision;
    }

    private Double comision;
    private String Contrasenia;
    private String estado;

    public CVendedor() {
        this.nombres = "";
        this.apellidos = "";
        this.tipoDocumento = "";
        this.numDocumento = "";
        this.correo = "";
        this.comision = 0.0;
        this.Contrasenia = "";
        this.estado = "";
    }

    public CVendedor(String nombres, String Apellidos, String tipoDocumento, String numDocumento, String correo, Double comision,String contrasenia, String estado) {
        this.nombres = nombres;
        this.apellidos = Apellidos;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.correo = correo;
        this.comision = comision;
        this.Contrasenia = contrasenia;
        this.estado = estado;
    }

    public  void  save(){
        conector c = new conector();
        String consulta = "call crearVendedor('"+
                this.nombres+"','"+
                this.apellidos+"','"+
                this.tipoDocumento+"','"+
                this.numDocumento+"','"+
                this.correo+"',"+
                this.comision+",'"+
                this.Contrasenia+"','"+
                this.estado+"');";
        System.out.println(consulta);
         c.ejecutarProcedimientoSinDatos(consulta);
    }

    public  void  update(){
        conector c = new conector();
        String consulta = "call actualizarVendedor("
                +this.idVendedor+",'"+
                this.nombres+"','"+
                this.apellidos+"','"+
                this.tipoDocumento+"','"+
                this.numDocumento+"','"+
                this.correo+"',"+
                this.comision+",'"+
                this.Contrasenia+"','"+
                this.estado+"');";
        System.out.println(consulta);
        c.ejecutarProcedimientoSinDatos(consulta);
    }

    public static List<List<String>> mostrarVendedores(String pIdVendedor) {
        List<List<String>> data = null;
        try {
            conector conexion = new conector();
            String consulta = "";
            if (pIdVendedor.compareTo("") == 0) {
                consulta = "call  listarVendedor('ACTIVO');";
            } else {
                consulta = "select * from tvendedor where idvendedor = " + pIdVendedor + ";";
            }
            data = conexion.ejecutarProcedimientoConDatos(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

package ventanas;

import Clases.CVendedor;
import conexion.conector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class crudVendedor extends JFrame {
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private  int idVenta;
    private Double Precio;
    private Double Descuento;
    private  CVendedor vendedor;
    private JPanel panel;
    private JFrame mensage;
    private JLabel jlbIDVendedor;
    private JTextField jtfNombres;
    private JTextField jtfApellidos;
    private JTextField jtfTipoDocumento;
    private JTextField jtfNumDocumento;
    private JTextField jtfCorreo;
    private JTextField jtfComision;
    private JPasswordField jpfContrasenea;
    private JTextField jtfEstado;

    private JLabel lbNombres;
    private JLabel lbApellidos;
    private JLabel lbTipoDocumento;
    private JLabel lbNumDocumento;
    private JLabel lbCorreo;
    private JLabel lbComision;
    private JLabel lbContrasenea;
    private JLabel lbEstado;

    private JButton jbtnGuardar = new JButton();
    private JButton jbtnActualizar = new JButton();
    private JButton jbtnLimpiar = new JButton();
    public crudVendedor(CVendedor Vendedor,String parrametro,int IDventa,int IDcliente, int IDvendedor, int IDflor,Double precio,Double desc){
        vendedor = Vendedor;
        setSize(750, 550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        idCliente = IDcliente;
        idVendedor  =IDvendedor;
        idFlor = IDflor;
        idVenta = IDventa;
        Precio = precio;
        Descuento = desc;
        cargarEventos();
    }

    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);


        jlbIDVendedor = new JLabel();
        jlbIDVendedor.setText(vendedor.getIdVendedor()+"");
        jlbIDVendedor.setBounds(30,30, 150,30);

        lbNombres = new JLabel();
        lbNombres.setText("Nombres");
        lbNombres.setBounds(30,90, 150,30);

        jtfNombres = new JTextField();
        jtfNombres.setText(vendedor.getNombres()+"");
        jtfNombres.setBounds(180,90, 150,30);

        lbApellidos = new JLabel();
        lbApellidos.setText("Apellidos");
        lbApellidos.setBounds(30,140, 150,30);

        jtfApellidos = new JTextField();
        jtfApellidos.setText(vendedor.getApellidos()+"");
        jtfApellidos.setBounds(180,140, 150,30);

        lbTipoDocumento = new JLabel();
        lbTipoDocumento.setText("Tipo Documento");
        lbTipoDocumento.setBounds(30,190, 150,30);

        jtfTipoDocumento = new JTextField();
        jtfTipoDocumento.setText(vendedor.getTipoDocumento()+"");
        jtfTipoDocumento.setBounds(180, 190, 150,30);

        lbNumDocumento = new JLabel();
        lbNumDocumento.setText("Número Documento");
        lbNumDocumento.setBounds(30,240, 150,30);

        jtfNumDocumento = new JTextField();
        jtfNumDocumento.setText(vendedor.getNumDocumento()+"");
        jtfNumDocumento.setBounds(180,240, 150,30);

        lbCorreo = new JLabel();
        lbCorreo.setText("Correo");
        lbCorreo.setBounds(30,290, 150,30);

        jtfCorreo = new JTextField();
        jtfCorreo.setText(vendedor.getCorreo()+"");
        jtfCorreo.setBounds(180,290, 150,30);


        lbComision = new JLabel();
        lbComision.setText("Comisión");
        lbComision.setBounds(30,340, 150,30);


        jtfComision = new JTextField();
        jtfComision.setText(vendedor.getComision()+"");
        jtfComision.setBounds(180,340, 150,30);


        lbContrasenea = new JLabel();
        lbContrasenea.setText("Contraseña");
        lbContrasenea.setBounds(30,390,150,30);

        jpfContrasenea = new JPasswordField();
        jpfContrasenea.setText(vendedor.getContrasenia()+"");
        jpfContrasenea.setBounds(180,390,150,30);


        lbEstado = new JLabel();
        lbEstado.setText("Estado");
        lbEstado.setBounds(30,440, 150,30);


        jtfEstado = new JTextField();
        jtfEstado.setText(vendedor.getEstado()+"");
        jtfEstado.setBounds(180,440, 150,30);



        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setBounds(480,100, 150,45);

        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.setBounds(480,200, 150,45);

        jbtnLimpiar.setText("limpiar");
        jbtnLimpiar.setBounds(480,300, 150,45);

        panel.add(jlbIDVendedor);
        panel.add(jtfNombres);
        panel.add(jtfApellidos);
        panel.add(jtfTipoDocumento);
        panel.add(jtfNumDocumento);
        panel.add(jtfCorreo);
        panel.add(jtfComision);
        panel.add(jpfContrasenea);
        panel.add(jtfEstado);

        panel.add(lbNombres);
        panel.add(lbApellidos);
        panel.add(lbTipoDocumento);
        panel.add(lbNumDocumento);
        panel.add(lbCorreo);
        panel.add(lbComision);
        panel.add(lbContrasenea);
        panel.add(lbEstado);
        panel.add(jbtnGuardar);
        panel.add(jbtnActualizar);
        panel.add(jbtnLimpiar);

        this.getContentPane().add(panel);
    }
    public static String LeerTex(String mensaje){
        return mensaje.toUpperCase();
    }

    public static boolean  isNumerico(String P){
        boolean isNumeric = true;
        for (int i = 0; i < P.length(); i++) {
            if (!Character.isDigit(P.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }
    public void cargarEventos(){



        jbtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarVendedores lV = new ListarVendedores("ACTUALIZAR",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                lV.setVisible(true);
                lV.setTitle("LOS VENDEDORES");
                dispose();
            }
        });
        jbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                ListarFlores lf = new ListarFlores();
//                lf.setVisible(true);
//                lf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                lf.setTitle("Flores existentes");
                CVendedor Vendedor = new CVendedor();
                String Nombres = LeerTex(jtfNombres.getText());
                String Apellidos = LeerTex(jtfApellidos.getText());
                String TipoDoc = LeerTex(jtfTipoDocumento.getText());
                String NumDoc = LeerTex(jtfNumDocumento.getText());
                String Correo = jtfCorreo.getText();
                String C = jtfComision.getText();
                Double Comision = 0.0;
                String Contrasenea = jpfContrasenea.getText();
                String Estado = LeerTex(jtfEstado.getText());

                if (Nombres.length() == 0 || Apellidos.length() == 0 || TipoDoc.length() == 0 || NumDoc.length() == 0 || Correo.length() == 0 || C.length() == 0 || Contrasenea.length() == 0 || Estado.length() == 0  ){
                    JOptionPane.showMessageDialog(mensage, "¡Debes rellenar TODOS los campos!");
                }else {
                    Comision = Double.parseDouble(C);
                    if (crudVendedor.this.vendedor.getIdVendedor() == 0){
                        vendedor.setNombres(Nombres);
                        vendedor.setApellidos(Apellidos);
                        vendedor.setTipoDocumento(TipoDoc);
                        vendedor.setNumDocumento(NumDoc);
                        vendedor.setCorreo(Correo);
                        vendedor.setComision(Comision);
                        vendedor.setContrasenia(Contrasenea);
                        vendedor.setEstado(Estado);
                        vendedor.save();
                    }else {
                        crudVendedor.this.vendedor.setIdVendedor(Integer.parseInt(jlbIDVendedor.getText()));
                        vendedor.setNombres(Nombres);
                        vendedor.setApellidos(Apellidos);
                        vendedor.setTipoDocumento(TipoDoc);
                        vendedor.setNumDocumento(NumDoc);
                        vendedor.setCorreo(Correo);
                        vendedor.setCorreo(Correo);
                        vendedor.setComision(Comision);
                        vendedor.setContrasenia(Contrasenea);
                        vendedor.setEstado(Estado);
                        vendedor.update();
                    }
                }

                jlbIDVendedor.setText("0");
                jtfNombres.setText("");
                jtfApellidos.setText("");
                jtfTipoDocumento.setText("");
                jtfNumDocumento.setText("");
                jtfCorreo.setText("");
                jtfComision.setText("");
                jpfContrasenea.setText("");
                jtfEstado.setText("");
                jtfNombres.grabFocus();

            }
        });

        jbtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conector c = new conector();
                int IdVendedor =Integer.parseInt(jlbIDVendedor.getText());

                if (IdVendedor == 0){
                    jtfNombres.setText("");
                    jtfApellidos.setText("");
                    jtfTipoDocumento.setText("");
                    jtfNumDocumento.setText("");
                    jtfCorreo.setText("");
                    jtfComision.setText("");
                    jpfContrasenea.setText("");
                    jtfEstado.setText("");
                    jtfNombres.grabFocus();
                }else {
                    String Consulta = "CALL EliminarVendedor("+ IdVendedor +");";
                    c.ejecutarProcedimientoSinDatos(Consulta);
                    jlbIDVendedor.setText("0");
                    jtfNombres.setText("");
                    jtfApellidos.setText("");
                    jtfTipoDocumento.setText("");
                    jtfNumDocumento.setText("");
                    jtfCorreo.setText("");
                    jtfComision.setText("");
                    jpfContrasenea.setText("");
                    jtfEstado.setText("");
                    jtfNombres.grabFocus();
                }

            }
        });
    }

    /**/
}

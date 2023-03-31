package ventanas;

import Clases.CCliente;
import Clases.CDocumentoVenta;
import conexion.conector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class crudCliente extends JFrame {
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private int idVenta;
    private  Double Precio;
    private Double Descuento;
    private  CCliente cliente;
    private JPanel panel;
    private JFrame mensage;
    private JLabel jlbIDcliente;
    private JTextField jtfNombres;
    private JTextField jtfApellidos;
    private JTextField jtfTipoDocumento;
    private JTextField jtfNumDocumento;
    private JTextField jtfCorreo;
    private JTextField jtfTipo;
    private JTextField jtfEstado;

    private JLabel lbNombres;
    private JLabel lbApellidos;
    private JLabel lbTipoDocumento;
    private JLabel lbNumDocumento;
    private JLabel lbCorreo;
    private JLabel lbTipo;
    private JLabel lbEstado;

    private JButton jbtnGuardar = new JButton();
    private JButton jbtnActualizar = new JButton();
    private JButton jbtnLimpiar = new JButton();
    public crudCliente(CCliente Cliente,String Parrametro,int IDventa,int IDcliente, int IDvendedor, int IDflor,Double precio, Double desc){
        cliente = Cliente;
        setSize(850, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        cargarEventos();
        idCliente = IDcliente;
        idVendedor = IDvendedor;
        idFlor = IDflor;
        idVenta = IDventa;
        Precio = precio;
        Descuento = desc;
    }

    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);


        jlbIDcliente = new JLabel();
        jlbIDcliente.setText(cliente.getIdCliente()+"");
        jlbIDcliente.setBounds(30,30, 150,30);

        lbNombres = new JLabel();
        lbNombres.setText("Nombres");
        lbNombres.setBounds(30,90, 150,30);

        jtfNombres = new JTextField();
        jtfNombres.setText(cliente.getNombres()+"");
        jtfNombres.setBounds(180,90, 150,30);

        lbApellidos = new JLabel();
        lbApellidos.setText("Apellidos");
        lbApellidos.setBounds(30,140, 150,30);

        jtfApellidos = new JTextField();
        jtfApellidos.setText(cliente.getApellidos()+"");
        jtfApellidos.setBounds(180,140, 150,30);

        lbTipoDocumento = new JLabel();
        lbTipoDocumento.setText("Tipo Documento");
        lbTipoDocumento.setBounds(30,190, 150,30);

        jtfTipoDocumento = new JTextField();
        jtfTipoDocumento.setText(cliente.getTipoDocumento()+"");
        jtfTipoDocumento.setBounds(180, 190, 150,30);

        lbNumDocumento = new JLabel();
        lbNumDocumento.setText("Número Documento");
        lbNumDocumento.setBounds(30,240, 150,30);

        jtfNumDocumento = new JTextField();
        jtfNumDocumento.setText(cliente.getNumDocumento()+"");
        jtfNumDocumento.setBounds(180,240, 150,30);

        lbCorreo = new JLabel();
        lbCorreo.setText("Correo");
        lbCorreo.setBounds(30,290, 150,30);

        jtfCorreo = new JTextField();
        jtfCorreo.setText(cliente.getCorreo()+"");
        jtfCorreo.setBounds(180,290, 150,30);


        lbTipo = new JLabel();
        lbTipo.setText("Tipo");
        lbTipo.setBounds(30,340, 150,30);


        jtfTipo = new JTextField();
        jtfTipo.setText(cliente.getTipo()+"");
        jtfTipo.setBounds(180,340, 150,30);

        lbEstado = new JLabel();
        lbEstado.setText("Estado");
        lbEstado.setBounds(30,390, 150,30);


        jtfEstado = new JTextField();
        jtfEstado.setText(cliente.getEstado()+"");
        jtfEstado.setBounds(180,390, 150,30);



        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setBounds(480,100, 150,45);

        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.setBounds(480,200, 150,45);

        jbtnLimpiar.setText("limpiar");
        jbtnLimpiar.setBounds(480,300, 150,45);

        panel.add(jlbIDcliente);
        panel.add(jtfNombres);
        panel.add(jtfApellidos);
        panel.add(jtfTipoDocumento);
        panel.add(jtfNumDocumento);
        panel.add(jtfCorreo);
        panel.add(jtfTipo);
        panel.add(jtfEstado);

        panel.add(lbNombres);
        panel.add(lbApellidos);
        panel.add(lbTipoDocumento);
        panel.add(lbNumDocumento);
        panel.add(lbCorreo);
        panel.add(lbTipo);
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
                ListarClientes ls = new ListarClientes("ACTUALIZAR",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                ls.setVisible(true);
                ls.setTitle("LOS CLIENTES");
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
                CCliente Cliente = new CCliente();
                String Nombres = LeerTex(jtfNombres.getText());
                String Apellidos = LeerTex(jtfApellidos.getText());
                String TipoDoc = LeerTex(jtfTipoDocumento.getText());
                String NumDoc = jtfNumDocumento.getText();
                String Correo = jtfCorreo.getText();
                String Tipo = LeerTex(jtfTipo.getText());
                String Estado = LeerTex(jtfEstado.getText());

                if (!Nombres.equals("")){
                    if (!Apellidos.equals("")){
                        if (!TipoDoc.equals("")){
                            if (!NumDoc.equals("")){
                                if (!Correo.equals("")){
                                    if (!Tipo.equals("")){
                                        if (!Estado.equals("")){
                                            if (isNumerico(NumDoc)){
                                                if (crudCliente.this.cliente.getIdCliente() == 0){
                                                    Cliente.setNombres(Nombres);
                                                    //Cliente.setNombres(Nombres);
                                                    Cliente.setApellidos(Apellidos);
                                                    Cliente.setTipoDocumento(TipoDoc);
                                                    Cliente.setNumDocumento(NumDoc);
                                                    Cliente.setCorreo(Correo);
                                                    Cliente.setTipo(Tipo);
                                                    Cliente.setEstado(Estado);
                                                    Cliente.saveCliente();
                                                }else {
                                                    crudCliente.this.cliente.setIdCliente(Integer.parseInt(jlbIDcliente.getText()));
                                                    Cliente.setNombres(Nombres);
                                                    //Cliente.setNombres(Nombres);
                                                    Cliente.setApellidos(Apellidos);
                                                    Cliente.setTipoDocumento(TipoDoc);
                                                    Cliente.setNumDocumento(NumDoc);
                                                    Cliente.setCorreo(Correo);
                                                    Cliente.setTipo(Tipo);
                                                    Cliente.setEstado(Estado);
                                                    Cliente.updateCliente();
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(mensage, "El campo número documento tiene que ser valores númericos");
                                            }

                                        }else {
                                            JOptionPane.showMessageDialog(mensage, "El campo estado esta vacio");
                                        }
                                    }else {
                                        JOptionPane.showMessageDialog(mensage, "El campo tipo esta vacio");
                                    }
                                }else {
                                    JOptionPane.showMessageDialog(mensage, "El campo correo esta vacio");
                                }
                            }else {
                                JOptionPane.showMessageDialog(mensage, "El campo número documento esta vacio");
                            }
                        }else{
                            JOptionPane.showMessageDialog(mensage, "El campo tipo de documento esta vacio");
                        }
                    }else {
                        JOptionPane.showMessageDialog(mensage, "El campo apellidos esta vacio");
                    }
                }else{
                    JOptionPane.showMessageDialog(mensage, "El campo nombres esta vacio");
                }

            }
        });

        jbtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conector c = new conector();
                int IdCliente =Integer.parseInt(jlbIDcliente.getText());

                if (IdCliente == 0){
                    jtfNombres.setText("");
                    jtfApellidos.setText("");
                    jtfTipoDocumento.setText("");
                    jtfNumDocumento.setText("");
                    jtfCorreo.setText("");
                    jtfTipo.setText("");
                    jtfEstado.setText("");
                    jtfNombres.grabFocus();
                }else {
                    String Consulta = "CALL EliminarCliente("+ IdCliente +");";
                    c.ejecutarProcedimientoSinDatos(Consulta);
                    jlbIDcliente.setText("..");
                    jtfNombres.setText("");
                    jtfApellidos.setText("");
                    jtfTipoDocumento.setText("");
                    jtfNumDocumento.setText("");
                    jtfCorreo.setText("");
                    jtfTipo.setText("");
                    jtfEstado.setText("");
                    jtfNombres.grabFocus();
                }
                dispose();
            }
        });
    }
    /**/
}

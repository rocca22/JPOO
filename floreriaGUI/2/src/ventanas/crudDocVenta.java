package ventanas;

import Clases.CDocumentoVenta;
import Clases.CVendedor;
import conexion.conector;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class crudDocVenta extends JFrame {
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private  int idVenta;
    private  double Precio;
    private  Double Descuento;
    private CDocumentoVenta venta;
    private JPanel panel;
    private JFrame mensage;
    private JLabel jlbIDVenta;
    private JTextField jtfTipoDoc;
    private JTextField jtfNumDoc;
    private JTextField jtfIdCliente;
    private JButton jbtnCliente;
    private JTextField jtfIdVendedor;
    private JButton jbtnVendedor;

    private  JButton jbtnFlor;

    private JTextField jtfPrecioTotal;
    private JTextField jpfIgv;
    private JTextField jpfDescuento;
    private JTextField jtfEstado;
    private JLabel lbTipoDoc;
    private JLabel lbNumDoc;
    private JLabel lbIdCliente;
    private JLabel lbIdVendedor;
    private JLabel lbPrecioTotal;
    private JLabel lbigv;
    private JLabel lbDescuento;
    private JLabel lbEstado;

    private JButton jbtnGuardar = new JButton();
    private JButton jbtnActualizar = new JButton();
    private JButton jbtnLimpiar = new JButton();
    public crudDocVenta(CDocumentoVenta Venta,String Parrametro ,int IdVenta, int IdCliente, int IdVendedor , int IDflor,double precio,Double desc){
        venta = Venta;
        idCliente = IdCliente;
        idVendedor = IdVendedor;
        idVenta = IdVenta;
        idFlor = IDflor;
        Precio = precio;
        Descuento = desc;
        setSize(750, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        jbtnGuardar.setEnabled(false);
        jbtnFlor.setEnabled(true);
        jtfIdCliente.setEditable(false);
        jtfIdVendedor.setEditable(false);
        jtfTipoDoc.setEditable(false);
        jpfDescuento.setEditable(false);
        jtfNumDoc.setEditable(false);
        jpfIgv.setEditable(false);
        jtfPrecioTotal.setEditable(false);
        jtfEstado.setEditable(false);
        if (Parrametro.equals("ACTUALIZAR")){
            cargarEventos();
        }
        else{
            jtfIdCliente.setText(String.valueOf(idCliente));
            jtfIdVendedor.setText(String.valueOf(idVendedor));
            jtfPrecioTotal.setText(String.valueOf(Precio));
            idCliente = IdCliente;
            idVendedor = IdVendedor;
            idFlor = IDflor;
            idVenta = IdVenta;
            if (idFlor !=0){
                        jtfTipoDoc.setText("BOLETA");
                        jtfEstado.setText("PAGADO");
                       panel.add(jtfPrecioTotal);
                       panel.add(jpfIgv);
                       panel.add(jpfDescuento);
                       panel.add(jtfEstado);
                       panel.add(lbPrecioTotal);
                       panel.add(lbigv);
                       panel.add(lbDescuento);
                       panel.add(lbEstado);
                       panel.add(jtfTipoDoc);
                       panel.add(jtfNumDoc);
                       jbtnGuardar.setEnabled(true);
                       jbtnFlor.setEnabled(false);
            }
            cargarEventos();
        }
    }


    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        jlbIDVenta = new JLabel();
        jlbIDVenta.setText(idVenta+"");
        jlbIDVenta.setBounds(30,30, 150,30);

        lbTipoDoc = new JLabel();
        lbTipoDoc.setText("Tipo Doc");
        lbTipoDoc.setBounds(30,90, 150,30);

        jtfTipoDoc = new JTextField();
        jtfTipoDoc.setText(venta.getTipoDocumento()+"");
        jtfTipoDoc.setBounds(180,90, 150,30);

        lbNumDoc = new JLabel();
        lbNumDoc.setText("Número Doc");
        lbNumDoc.setBounds(30,140, 150,30);

        jtfNumDoc = new JTextField();
        jtfNumDoc.setText("B-000"+idVenta+"");
        jtfNumDoc.setBounds(180,140, 150,30);

        lbIdCliente = new JLabel();
        lbIdCliente.setText("Id Cliente");
        lbIdCliente.setBounds(30,190, 150,30);

        jtfIdCliente = new JTextField();
        jtfIdCliente.setText(venta.getIdCliente()+"");
        jtfIdCliente.setBounds(180, 190, 50,30);


        jbtnCliente = new JButton();
        jbtnCliente.setText("Añadir Cliente");
        jbtnCliente.setBounds(260, 190, 160,25);


        lbIdVendedor = new JLabel();
        lbIdVendedor.setText("Id Vendedor");
        lbIdVendedor.setBounds(30,240, 150,30);




        jtfIdVendedor = new JTextField();
        jtfIdVendedor.setText(venta.getIdVendedor()+"");
        jtfIdVendedor.setBounds(180,240, 50,30);

        jbtnVendedor = new JButton();
        jbtnVendedor.setText("Añadir Vendedor");
        jbtnVendedor.setBounds(260, 240, 160,25);

        jbtnFlor = new JButton();
        jbtnFlor.setText("Seleciona flor a vender");
        jbtnFlor.setBounds(30, 290, 390,25);

        lbPrecioTotal = new JLabel();
        lbPrecioTotal.setText("Precio Total");
        lbPrecioTotal.setBounds(30,340, 150,30);

        jtfPrecioTotal = new JTextField();
        jtfPrecioTotal.setText(Precio+"");
        jtfPrecioTotal.setBounds(180,340, 150,30);





        lbigv = new JLabel();
        lbigv.setText("IGV");
        lbigv.setBounds(30,390, 150,30);


        jpfIgv = new JTextField();
        jpfIgv.setText(venta.getIgv()+"");
        jpfIgv.setBounds(180,390, 150,30);


        lbDescuento = new JLabel();
        lbDescuento.setText("Descuento");
        lbDescuento.setBounds(30,440,150,30);

        jpfDescuento = new JTextField();
        jpfDescuento.setText(Descuento+"");
        jpfDescuento.setBounds(180,440,150,30);


        lbEstado = new JLabel();
        lbEstado.setText("Estado");
        lbEstado.setBounds(30,490, 150,30);


        jtfEstado = new JTextField();
        jtfEstado.setText("PROCESO");
        jtfEstado.setBounds(180,490, 150,30);



        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setBounds(480,100, 150,45);

        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.setBounds(480,200, 150,45);

        jbtnLimpiar.setText("MOSTRAR");
        jbtnLimpiar.setBounds(480,300, 150,45);

        panel.add(jlbIDVenta);
        /*
        panel.add(jtfTipoDoc);
        panel.add(jtfNumDoc);*/
        panel.add(jtfIdCliente);
        panel.add(jbtnCliente);
        panel.add(jtfIdVendedor);
        panel.add(jbtnVendedor);
        panel.add(jbtnFlor);
        /*
        panel.add(jtfPrecioTotal);
        panel.add(jpfIgv);
        panel.add(jpfDescuento);
        panel.add(jtfEstado);*/

        panel.add(lbTipoDoc);
        panel.add(lbNumDoc);
        panel.add(lbIdCliente);
        panel.add(lbIdVendedor);
        /*
        panel.add(lbPrecioTotal);
        panel.add(lbigv);
        panel.add(lbDescuento);
        panel.add(lbEstado);*/


        panel.add(jbtnGuardar);
       // panel.add(jbtnActualizar);
        panel.add(jbtnLimpiar);

        this.getContentPane().add(panel);
    }

    public static int PrecioTotal(int Idflor){
        int preciotota = 0;



        return preciotota;
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
        jbtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarVenta lv = new ListarVenta("ID",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                lv.setTitle("---------------- VENTAS REALIZADAS---------------");
                lv.setVisible(true);
                dispose();

            }
        });
        jbtnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarClientes ls = new ListarClientes("ID",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                ls.setVisible(true);
                ls.setTitle(" LISTA DE CLIENTES");
                dispose();
            }
        });

        jbtnVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarVendedores ls = new ListarVendedores("",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                ls.setVisible(true);
                ls.setTitle("LISTA DE LOS VENDEDORES");
                dispose();
            }
        });

        jbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat fI = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fecha = fI.format(new Date());
                venta = new CDocumentoVenta();
                String tipoDocumento = jtfTipoDoc.getText();
                String nroDocumento = jtfNumDoc.getText();
                String estado= jtfEstado.getText();
                Double igv=Double.parseDouble(jpfIgv.getText());
                // Double precioTotal = Precio - igv;
                if (tipoDocumento.length() == 0 || nroDocumento.length() == 0  ||  estado.length() == 0){
                    JOptionPane.showMessageDialog(mensage, "¡Debes rellenar TODOS los campos!");
                }else {
                    Double precioTotal = Precio - igv;
                    Double descuento = Descuento;

                    venta.setIdDocVenta(idVenta);
                    venta.setTipoDocumento(tipoDocumento);
                    venta.setNroDocumento(nroDocumento);
                    venta.setIdCliente(idCliente);
                    venta.setIdVendedor(idVendedor);
                    venta.setFechaVenta(fecha);
                    venta.setPrecioTotal(precioTotal);
                    venta.setIgv(igv);
                    venta.setDescuento(descuento);
                    venta.setEstado(estado);
                    venta.update();
                    crudDocVenta cDv = new crudDocVenta(new CDocumentoVenta(),"",0,0,0,0,0.0,0.0);
                    cDv.setVisible(true);
                    cDv.setTitle("CRUD DOCUMENTO VENTA");
                    dispose();
                }
            }
        });
        jbtnFlor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat fI = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fecha = fI.format(new Date());
                Double igv=Double.parseDouble(jpfIgv.getText());
                Double precioTotal = 0.0;
                Double descuento= 0.0;
                String estado= jtfEstado.getText();

                if (jtfIdCliente.getText().equals("0") || jtfIdVendedor.getText().equals("0")){
                    JOptionPane.showMessageDialog(mensage, "¡Selecione Cliente o Vendedor!");
                }else {
                    venta.setTipoDocumento("");
                    venta.setNroDocumento("");
                    venta.setFechaVenta(fecha);
                    venta.setIdCliente(idCliente);
                    venta.setIdVendedor(idVendedor);
                    venta.setPrecioTotal(0.0);
                    venta.setIgv(igv);
                    venta.setDescuento(0.0);
                    venta.setEstado("Proceso");
                    String ID = venta.save();
                    idVenta = Integer.parseInt(ID);
                    System.out.println(idVenta);
                    Ventanas.ListarFlores lV = new Ventanas.ListarFlores("ID",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                    jbtnGuardar.setEnabled(true);
                    lV.setVisible(true);
                    lV.setTitle(" LISTA DE FLORES ");
                    dispose();
                }

            }
        });





    }
    /**/
}

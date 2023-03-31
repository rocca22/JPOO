package Ventanas;

import Clases.CDetalleVenta;
import Clases.CDocumentoVenta;
import Clases.CFlor;
import ventanas.crudDocVenta;
import ventanas.crudFlor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListarFlores extends JFrame {
    private JFrame mensage;
    private CDetalleVenta Detalle;
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private int IdVenta;
    private  Double Descuento;
    private double PrecioTotal;
    private  JLabel Titulo;
    private  JLabel jblIdVenta;
    private  JLabel jtfidventa;
    private  JLabel jblIProducto;
    private  JLabel jtfProducto;
    private  JLabel jblCantidad;
    private JTextField jtfCantidad;
    private JLabel jblDescuento;
    private JTextField jtfDescuento;
    private  JLabel jblPrecio;
    private  JLabel jtfPrecio;

    private JPanel panel;
    private JTable tablaFlores;
    private DefaultTableModel modeloTablaFlores;
    private JScrollPane despl;
    private JButton jbtnCerrar;
    private JButton jbtnGuardar;

    public ListarFlores(String Parrametro,int IDventa,int IDcliente, int IDvendedor, int IDflor,Double precio,Double desc){
        Detalle = new CDetalleVenta();
        if (Parrametro.equals("ACTUALIZAR")){
            setSize(600, 480);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            inicializarComponentes();
            cargarEventos();
            panel.add(jbtnCerrar);
        } else if (Parrametro.equals("ID")){
            setSize(600, 540);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            inicializarComponentes();
            idCliente = IDcliente;
            idVendedor = IDvendedor;
            idFlor = IDflor;
            IdVenta = IDventa;
            Descuento = desc;
            PrecioTotal = precio;
            jblIdVenta = new JLabel();
            jblIdVenta.setText("ID VENTA");
            jblIdVenta.setBounds(30,250, 150,30);
            jtfidventa = new JLabel();
            jtfidventa.setText(IdVenta+"");
            jtfidventa.setBounds(180,250, 50,30);
            jblIProducto = new JLabel();
            jblIProducto.setText("ID FLOR");
            jblIProducto.setBounds(30,300, 150,30);
            jtfProducto = new JLabel();
            jtfProducto.setText("0");
            jtfProducto.setBounds(180,300, 50,30);
            jblCantidad = new JLabel();
            jblCantidad.setText("CANTIDAD");
            jblCantidad.setBounds(30,350, 150,30);

            jtfCantidad = new JTextField();
            jtfCantidad.setText("1");
            jtfCantidad.setBounds(180,350, 100,30);

            jblDescuento = new JLabel();
            jblDescuento.setText("DESCUENTO");
            jblDescuento.setBounds(30,400, 150,30);


            jtfDescuento = new JTextField();
            jtfDescuento.setText(Detalle.getDescuento()+"");
            jtfDescuento.setBounds(180,400, 100,30);

            jblPrecio = new JLabel();
            jblPrecio.setText("PRECIO UNITARIO");
            jblPrecio.setBounds(30,450, 150,30);

            jtfPrecio = new JLabel();
            jtfPrecio.setText(Detalle.getPrecio()+"");
            jtfPrecio.setBounds(180,450, 50,30);

            jbtnGuardar = new JButton();
            jbtnGuardar.setText("GUARDAR");
            jbtnGuardar.setBounds(390 ,310, 150,30);

            panel.add(jblIdVenta);
            panel.add(jtfidventa);
            panel.add(jblIProducto);
            panel.add(jtfProducto);
            panel.add(jblCantidad);
            panel.add(jtfCantidad);
            panel.add(jblDescuento);
            panel.add(jtfDescuento);
            panel.add(jblPrecio);
            panel.add(jtfPrecio);
            panel.add(jbtnGuardar);

            this.getContentPane().add(panel);

            cargarEventosSecionado();
        }
    }
    /**/
    private void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        Titulo = new JLabel();
        Titulo.setText("SELECIONE UNA FLOR DE ESTA TABLA");
        Titulo.setBounds(180,10, 500,30);
        modeloTablaFlores = new DefaultTableModel();

        modeloTablaFlores.addColumn("id");
        modeloTablaFlores.addColumn("Nombre");
        modeloTablaFlores.addColumn("Aroma");
        modeloTablaFlores.addColumn("Color");
        modeloTablaFlores.addColumn("Precio");
        modeloTablaFlores.addColumn("Stock");
        modeloTablaFlores.addColumn("F. Creacion");
        modeloTablaFlores.addColumn("Estado");

        tablaFlores = new JTable(modeloTablaFlores);

        tablaFlores.setBounds(30, 50, 533, 200);
        panel.add(tablaFlores);

        despl = new JScrollPane(tablaFlores,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        despl.setBounds(30, 50, 533, 200);
        despl.setAutoscrolls(true);
        panel.add(despl);

        jbtnCerrar = new JButton("Cerrar");
        jbtnCerrar.setBounds(30,520, 120, 35);
        panel.add(Titulo);

        this.getContentPane().add(panel);

        final List<List<String>> datos = CFlor.mostrarFlores("");
        for (List<String> list : datos) {
            modeloTablaFlores.addRow(list.toArray());
        }
    }
    private void cargarEventos(){
        jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CFlor f = new CFlor();
                crudFlor cf = new crudFlor(f,"",IdVenta,idCliente,idVendedor,idFlor,PrecioTotal,Descuento);
                cf.setTitle("CRUD FLOR");
                cf.setVisible(true);
                dispose();
            }
        });



        tablaFlores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){

                int fila = tablaFlores.rowAtPoint(e.getPoint());
                SimpleDateFormat fI = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fecha = fI.format(new Date());
                CFlor f = new CFlor(
                        tablaFlores.getValueAt(fila,1).toString(),
                        tablaFlores.getValueAt(fila,2).toString(),
                        tablaFlores.getValueAt(fila,3).toString(),
                        Double.parseDouble(tablaFlores.getValueAt(fila,4).toString()),
                        Integer.parseInt(tablaFlores.getValueAt(fila,5).toString()),
                        fecha,
                        tablaFlores.getValueAt(fila,7).toString()
                );

                f.setIdflor(Integer.parseInt(tablaFlores.getValueAt(fila,0).toString()));

                crudFlor cf = new crudFlor(f,"",IdVenta,idCliente,idVendedor,idFlor,PrecioTotal,Descuento);
                cf.setVisible(true);
                cf.setTitle("CRUD FLOR");
                dispose();
            }
        });

    }
    private void cargarEventosSecionado(){

        jbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int idProducto =  Integer.parseInt(jtfProducto.getText());
                int cantidad =  Integer.parseInt(jtfCantidad.getText());
                Descuento = Double.parseDouble(jtfDescuento.getText());
                CDocumentoVenta V = new CDocumentoVenta();
                if (idProducto == 0 || cantidad == 0){
                    JOptionPane.showMessageDialog(mensage, "¡Debes rellenar TODOS los campos!");
                }else {
                    if (idProducto == 0 ){
                        JOptionPane.showMessageDialog(mensage, "¡Debes rellenar TODOS los campos!");
                    }else {
                        Double Precio = Double.parseDouble(jtfPrecio.getText());
                        int Cantidad = Integer.parseInt(jtfCantidad.getText());
                        if (jtfDescuento.getText().equals("0")){
                            PrecioTotal = Math.round((Precio*Cantidad) - Descuento);
                            Detalle = new CDetalleVenta();
                            Detalle.setIdVenta(IdVenta);
                            Detalle.setIdProducto(idProducto);
                            Detalle.setCantidad(Integer.parseInt(jtfCantidad.getText()));
                            Detalle.setPrecio(Integer.parseInt(jtfPrecio.getText()));
                            Detalle.setDescuento(Descuento);
                            Detalle.save();
                            System.out.println(IdVenta);
                            crudDocVenta crC = new crudDocVenta(V,"",IdVenta,idCliente,idVendedor,idFlor,PrecioTotal,Descuento);
                            crC.setVisible(true);
                            crC.setTitle("CRUD DOCUMENTO VENTA");
                            dispose();

                        }else {
                            PrecioTotal = Math.round((Precio*Cantidad) - Descuento);

                            Detalle = new CDetalleVenta();
                            Detalle.setIdVenta(IdVenta);
                            Detalle.setIdProducto(idProducto);
                            Detalle.setCantidad(Integer.parseInt(jtfCantidad.getText()));
                            Detalle.setPrecio(PrecioTotal);
                            Detalle.setDescuento(Descuento);
                            Detalle.save();
                            crudDocVenta crC = new crudDocVenta(V,"",IdVenta,idCliente,idVendedor,idFlor,PrecioTotal,Descuento);
                            crC.setVisible(true);
                            crC.setTitle("CRUD DOCUMENTO VENTA");
                            dispose();
                        }
                    }
                    /*
                    Double Precio = Double.parseDouble(jtfPrecio.getText());
                    int Cantidad = Integer.parseInt(jtfCantidad.getText());
                    int Descuento = Integer.parseInt(jtfDescuento.getText());
                    PrecioTotal = (Precio*Cantidad) -Descuento;
                    System.out.println(PrecioTotal);*/
                }







            }
        });

        /*jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CDocumentoVenta f = new CDocumentoVenta();
                crudDocVenta cf = new crudDocVenta(f,"",idCliente,idVendedor,idFlor);
                cf.setTitle("CRUD FLOR");
                cf.setVisible(true);
                dispose();
            }
        });
        */

        tablaFlores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int fila = tablaFlores.rowAtPoint(e.getPoint());

                idFlor = Integer.parseInt(tablaFlores.getValueAt(fila,0).toString());
                System.out.println(idFlor);
                SimpleDateFormat fI = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fecha = fI.format(new Date());
                CFlor f = new CFlor(
                        tablaFlores.getValueAt(fila,1).toString(),
                        tablaFlores.getValueAt(fila,2).toString(),
                        tablaFlores.getValueAt(fila,3).toString(),
                        Double.parseDouble(tablaFlores.getValueAt(fila,4).toString()),
                        Integer.parseInt(tablaFlores.getValueAt(fila,5).toString()),
                        fecha,
                        tablaFlores.getValueAt(fila,7).toString()
                );
                f.setIdflor(Integer.parseInt(tablaFlores.getValueAt(fila,0).toString()));
                /*crudDocVenta crC = new crudDocVenta(V,"ID",idCliente,idVendedor,Idflor);
                crC.setVisible(true);
                crC.setTitle("CRUD DOCUMENTO VENTA");
                dispose();*/
                jtfProducto.setText(f.getIdflor()+"");
                jtfPrecio.setText(f.getPrecio()+"");
                panel.add(jtfProducto);
                panel.add(jtfPrecio);

            }
        });

    }
}
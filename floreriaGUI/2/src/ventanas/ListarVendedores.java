package ventanas;

import Clases.CCliente;
import Clases.CDocumentoVenta;
import Clases.CVendedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;


public class ListarVendedores extends JFrame {
    private  double Precio;
    private  Double Descuento;
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private  int idVenta;

    private JPanel panel;
    private JTable tablaVendedores;
    private DefaultTableModel modeloTablaVendedores;
    private JScrollPane despl;
    private JButton jbtnCerrar;
    public ListarVendedores(String Parrametro,int IDventa,int IDcliente,int IDvendedor,int IDflor,Double precio,Double desc){

        setSize(850, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        if(Parrametro.equals("ACTUALIZAR")){
            inicializarComponentes();
            cargarEventosActualizar();
            panel.add(jbtnCerrar);
        }else {
            inicializarComponentes();
            idCliente = IDcliente;
            idVendedor  =IDvendedor;
            idFlor = IDflor;
            idVenta = IDventa;
            Precio = precio;
            Descuento = desc;
            cargarEventosSeleciona();
        }
    }
    /**/
    private void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        modeloTablaVendedores = new DefaultTableModel();
        modeloTablaVendedores.addColumn("id");
        modeloTablaVendedores.addColumn("Nombres");
        modeloTablaVendedores.addColumn("Apellidos");
        modeloTablaVendedores.addColumn("Tipo Doc");
        modeloTablaVendedores.addColumn("Número Doc");
        modeloTablaVendedores.addColumn("Correo");
        modeloTablaVendedores.addColumn("Comisión");
        modeloTablaVendedores.addColumn("Contraseña");
        modeloTablaVendedores.addColumn("Estado");

        tablaVendedores = new JTable(modeloTablaVendedores);

        tablaVendedores.setBounds(10, 50, 812, 350);
        panel.add(tablaVendedores);

        despl = new JScrollPane(tablaVendedores,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        despl.setBounds(10, 50, 812, 300);
        despl.setAutoscrolls(true);
        panel.add(despl);

        jbtnCerrar = new JButton("Cerrar");
        jbtnCerrar.setBounds(344,380, 120, 35);


        this.getContentPane().add(panel);

        final List<List<String>> datos = CVendedor.mostrarVendedores("");
        for (List<String> list : datos) {
            modeloTablaVendedores.addRow(list.toArray());
        }
    }
    private void cargarEventosActualizar(){
        jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CVendedor Vendedor = new CVendedor();
                crudVendedor cC = new crudVendedor(Vendedor,"",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                cC.setTitle("----------------  CRUD VENDEDOR  ---------------");
                cC.setVisible(true);
                dispose();
            }
        });

        tablaVendedores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){


                int fila = tablaVendedores.rowAtPoint(e.getPoint());
                CVendedor C = new CVendedor(
                        tablaVendedores.getValueAt(fila,1).toString(),
                        tablaVendedores.getValueAt(fila,2).toString(),
                        tablaVendedores.getValueAt(fila,3).toString(),
                        tablaVendedores.getValueAt(fila,4).toString(),
                        tablaVendedores.getValueAt(fila,5).toString(),
                        Double.parseDouble(tablaVendedores.getValueAt(fila,6).toString()),
                        tablaVendedores.getValueAt(fila,7).toString(),
                        tablaVendedores.getValueAt(fila,8).toString()
                );
                C.setIdVendedor(Integer.parseInt(tablaVendedores.getValueAt(fila,0).toString()));


                crudVendedor crC = new crudVendedor(C,"",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                crC.setVisible(true);
                crC.setTitle("CRUD CLIENTE");
                dispose();
            }
        });

    }

    private void cargarEventosSeleciona(){
        tablaVendedores.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                CDocumentoVenta V = new CDocumentoVenta();
                int fila = tablaVendedores.rowAtPoint(e.getPoint());

                int IdVendedor = Integer.parseInt(tablaVendedores.getValueAt(fila,0).toString());

                crudDocVenta crC = new crudDocVenta(V,"",idVenta,idCliente,IdVendedor,idFlor,Precio,Descuento);
                crC.setVisible(true);
                crC.setTitle("CRUD DOC VENTA");
                dispose();
            }
        });

    }


}
package ventanas;

import Clases.CCliente;
import Clases.CDocumentoVenta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ListarVenta extends JFrame {
    private JPanel panel;
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private int idVenta;
    private  Double Precio;
    private Double Descuento;
    private CDocumentoVenta Venta;
    private JTable tablaClientes;
    private DefaultTableModel modeloTablaClientes;
    private JScrollPane despl;
    private JButton jbtnCerrar;
    public ListarVenta(String Parrametro, int IDventa, int IDcliente, int IDvendedor, int IDflor, Double precio, Double desc){
        setSize(850, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        cargarEventosCerrar();
            idCliente = IDcliente;
            idVendedor = IDvendedor;
            idFlor = IDflor;
            idVenta = IDventa;
            Precio = precio;
            Descuento = desc;
    }
    /**/
    private void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        modeloTablaClientes = new DefaultTableModel();

        modeloTablaClientes.addColumn("ID");
        modeloTablaClientes.addColumn("Tipo Doc");
        modeloTablaClientes.addColumn("Num Doc");
        modeloTablaClientes.addColumn("ID Cliente");
        modeloTablaClientes.addColumn("ID Vendedor");
        modeloTablaClientes.addColumn("Fecha Venta");
        modeloTablaClientes.addColumn("Precio Total");
        modeloTablaClientes.addColumn("Descuento");
        modeloTablaClientes.addColumn("Estado");

        tablaClientes = new JTable(modeloTablaClientes);

        tablaClientes.setBounds(10, 50, 812, 350);
        panel.add(tablaClientes);

        despl = new JScrollPane(tablaClientes,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        despl.setBounds(10, 50, 812, 300);
        despl.setAutoscrolls(true);
        panel.add(despl);

        jbtnCerrar = new JButton("Cerrar");
        jbtnCerrar.setBounds(344,380, 120, 35);


        this.getContentPane().add(panel);
        panel.add(jbtnCerrar);
        final List<List<String>> datos = CDocumentoVenta.mostrarVenta("");
        for (List<String> list : datos) {
            modeloTablaClientes.addRow(list.toArray());
        }
    }
    private void cargarEventosCerrar(){
        jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CDocumentoVenta ventaS = new CDocumentoVenta();
                crudDocVenta cC = new crudDocVenta(ventaS,"ACTUALIZAR",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                cC.setTitle("----------------  CRUD VENTA  ---------------");
                cC.setVisible(true);
                dispose();
            }
        });

/*
        tablaClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){

                int fila = tablaClientes.rowAtPoint(e.getPoint());
                CCliente C = new CCliente(
                        tablaClientes.getValueAt(fila,1).toString(),
                        tablaClientes.getValueAt(fila,2).toString(),
                        tablaClientes.getValueAt(fila,3).toString(),
                        tablaClientes.getValueAt(fila,4).toString(),
                        tablaClientes.getValueAt(fila,5).toString(),
                        tablaClientes.getValueAt(fila,6).toString(),
                        tablaClientes.getValueAt(fila,7).toString()
                );
                C.setIdCliente(Integer.parseInt(tablaClientes.getValueAt(fila,0).toString()));
                crudCliente crC = new crudCliente(C,"",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                crC.setVisible(true);
                crC.setTitle("CRUD CLIENTE");
                dispose();
            }
        });

    }

    private void cargarEventosSeleciona(){
        jbtnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CCliente Cliente = new CCliente();
                crudCliente cC = new crudCliente(Cliente,"",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                cC.setTitle("----------------  CRUD CLIENTE  ---------------");
                cC.setVisible(true);
                dispose();
            }
        });

        tablaClientes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                CDocumentoVenta V = new CDocumentoVenta();
                int fila = tablaClientes.rowAtPoint(e.getPoint());

                idCliente = Integer.parseInt(tablaClientes.getValueAt(fila,0).toString());

                crudDocVenta crC = new crudDocVenta(V,"ID",idVenta,idCliente,idVendedor,idFlor,Precio,Descuento);
                crC.setVisible(true);
                crC.setTitle("CRUD CLIENTE");
                dispose();
            }
        });
*/
    }
}
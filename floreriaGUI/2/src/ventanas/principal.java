package ventanas;

import Clases.CCliente;
import Clases.CDocumentoVenta;
import Clases.CFlor;
import Clases.CVendedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal extends JFrame {
    private JPanel panel;
    private JLabel jlbTitulo;
    private JButton jbtnFlores;
    private JButton jbtnClientes;
    private JButton jbtnVendedores;

    private  JButton jbtnDocventa;

    public principal(){
        setSize(900, 500); // Dimesiones en pixeles
        setDefaultCloseOperation(EXIT_ON_CLOSE); //(para cerrar el programa)
        setResizable(false); // No se podra redimensional (true para que si se pueda)
        setLocationRelativeTo(null); // Centramos la ventana

        inicializarComponentes(); //
        cargarEventos(); //
    }

    public void inicializarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);

        jlbTitulo = new JLabel();
        jlbTitulo.setText("CRUD GUI");
        jlbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        jlbTitulo.setBounds(0, 0, 600, 40); // (posX, posY, ancho, alto)

        jbtnFlores = new JButton();
        jbtnFlores.setText("Gest. Flores");
        jbtnFlores.setBounds(50, 45, 160, 45);

        jbtnClientes = new JButton();
        jbtnClientes.setText("Gest. Clientes");
        jbtnClientes.setBounds(300, 45, 160, 45);

        jbtnVendedores = new JButton();
        jbtnVendedores.setText("Gest. Vendedores");
        jbtnVendedores.setBounds(560, 45, 160, 45);

        jbtnDocventa = new JButton();
        jbtnDocventa.setText("Gest. Doc venta");
        jbtnDocventa.setBounds(300, 170, 160, 45);


        panel.add(jlbTitulo);
        panel.add(jbtnFlores);
        panel.add(jbtnClientes);
        panel.add(jbtnVendedores);
        panel.add(jbtnDocventa);

        this.getContentPane().add(panel);
    }

    public void cargarEventos(){
        jbtnFlores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crudFlor cf = new crudFlor(new CFlor(),"",0,0,0,0,0.0,0.0);
                cf.setVisible(true);
                cf.setTitle("CRUD FLOR");
            }
        });

        jbtnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crudCliente cc = new crudCliente(new CCliente(),"",0,0,0,0,0.0,0.0);
                cc.setVisible(true);
                cc.setTitle("CRUD CLIENTE");
            }
        });

        jbtnVendedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crudVendedor cv = new crudVendedor(new CVendedor(),"",0,0,0,0,0.0,0.0);
                cv.setVisible(true);
                cv.setTitle("CRUD VENDEDORES");
            }
        });

        jbtnDocventa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crudDocVenta cDv = new crudDocVenta(new CDocumentoVenta(),"",0,0,0,0,0.0,0.0);
                cDv.setVisible(true);
                cDv.setTitle("CRUD DOCUMENTO VENTA");
            }
        });

    }
}

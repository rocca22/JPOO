package ventanas;

import Clases.CFlor;
import Clases.CVendedor;
import conexion.conector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


public class crudFlor extends JFrame {
    private double PrecioTotal;
    private  Double Descuento;
    private CFlor flor;
    private  int idCliente;
    private  int idVendedor;
    private  int idFlor;
    private  int idVenta;

    private JPanel panel;
    private JFrame mensage;
    private JLabel jlbIdFlor;
    private JTextField jtfNombre;
    private JTextField jtfAroma;
    private JTextField jtfColor;
    private JTextField jtfPrecio;
    private JTextField jtfStock;
    private JTextField fcreacion;
    private JTextField jtfEstado;

    private JLabel lbNombre;
    private JLabel lbAroma;
    private JLabel lbColor;
    private JLabel lbPrecio;
    private JLabel lbStock;
    private JLabel lbfcreacion;
    private JLabel lbEstado;

    private JButton jbtnGuardar = new JButton();
    private JButton jbtnActualizar = new JButton();
    private JButton jbtnLimpiar = new JButton();
    public crudFlor(CFlor pFlor, String parrametro, int IDventa,int IDcliente , int IDvendedor, int IDflor,Double precio ,Double desc){
        flor = pFlor;
        idVenta = IDventa;
        idCliente = IDcliente;
        idVendedor = IDvendedor;
        idFlor = IDflor;
        PrecioTotal = precio;
        Descuento = desc;
        setSize(730, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        inicializarComponentes();
        cargarEventos();
    }

    public void inicializarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);


        jlbIdFlor = new JLabel();
        jlbIdFlor.setText(flor.getIdflor()+"");
        jlbIdFlor.setBounds(30,30, 150,30);

        lbNombre = new JLabel();
        lbNombre.setText("Nombre");
        lbNombre.setBounds(30,90, 150,30);

        jtfNombre = new JTextField();
        jtfNombre.setText(flor.getNombre()+"");
        jtfNombre.setBounds(180,90, 150,30);

        lbAroma = new JLabel();
        lbAroma.setText("Aroma");
        lbAroma.setBounds(30,140, 150,30);

        jtfAroma = new JTextField();
        jtfAroma.setText(flor.getAroma()+"");
        jtfAroma.setBounds(180,140, 150,30);

        lbColor = new JLabel();
        lbColor.setText("Color");
        lbColor.setBounds(30,190, 150,30);

        jtfColor = new JTextField();
        jtfColor.setText(flor.getColor());
        jtfColor.setBounds(180, 190, 150,30);

        lbPrecio = new JLabel();
        lbPrecio.setText("Precio");
        lbPrecio.setBounds(30,240, 150,30);

        jtfPrecio = new JTextField();
        jtfPrecio.setText(flor.getPrecio()+"");
        jtfPrecio.setBounds(180,240, 150,30);

        lbStock = new JLabel();
        lbStock.setText("Stock");
        lbStock.setBounds(30,290, 150,30);

        jtfStock = new JTextField();
        jtfStock.setText(flor.getStock()+"");
        jtfStock.setBounds(180,290, 150,30);


        lbEstado = new JLabel();
        lbEstado.setText("Estado");
        lbEstado.setBounds(30,340, 150,30);


        jtfEstado = new JTextField();
        jtfEstado.setText(flor.getEstado());
        jtfEstado.setBounds(180,340, 150,30);


        jbtnGuardar.setText("Guardar");
        jbtnGuardar.setBounds(480,100, 150,45);

        jbtnActualizar.setText("Actualizar");
        jbtnActualizar.setBounds(480,200, 150,45);

        jbtnLimpiar.setText("limpiar");
        jbtnLimpiar.setBounds(480,300, 150,45);

        panel.add(jlbIdFlor);
        panel.add(jtfNombre);
        panel.add(jtfAroma);
        panel.add(jtfColor);
        panel.add(jtfPrecio);
        panel.add(jtfStock);
        panel.add(jtfEstado);
        panel.add(lbNombre);
        panel.add(lbColor);
        panel.add(lbAroma);
        panel.add(lbPrecio);
        panel.add(lbStock);
        //panel.add(fcreacion);
        panel.add(lbEstado);
        panel.add(lbEstado);
        //panel.add(nstok);
        //panel.add(aprox);
        panel.add(jbtnGuardar);
        panel.add(jbtnActualizar);
        panel.add(jbtnLimpiar);

        this.getContentPane().add(panel);
    }

    public static String LeerTex(String mensaje){
        return mensaje.toUpperCase();
    }


    public void cargarEventos(){

        jbtnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ventanas.ListarFlores ls = new Ventanas.ListarFlores("ACTUALIZAR",idVenta,idCliente,idVendedor,idFlor,PrecioTotal,Descuento);
                ls.setVisible(true);
                ls.setTitle("LAS FLORES");
                dispose();
            }
        });



        jbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat fI = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String fecha = fI.format(new Date());
//                ListarFlores lf = new ListarFlores();
//                lf.setVisible(true);
//                lf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                lf.setTitle("Flores existentes");
                String Nombre = LeerTex(jtfNombre.getText());
                String Aroma = LeerTex(jtfAroma.getText());
                String Color = LeerTex(jtfColor.getText());
                String P = jtfPrecio.getText();
                double Precio = 0.0;
                String S = jtfStock.getText();
                int Stock = 0;
                String Estado = LeerTex(jtfEstado.getText());
                if (Nombre.length() == 0 || Aroma.length() == 0 ||  Color.length() == 0 ||  P.length() == 0 ||  S.length() == 0 ||  Estado.length() == 0  ){
                    JOptionPane.showMessageDialog(mensage, "¡Debes rellenar TODOS los campos!");
                }else {
                    Precio = Double.parseDouble(jtfPrecio.getText());
                    Stock = Integer.parseInt(S);
                        if (crudFlor.this.flor.getIdflor() == 0){
                            flor.setNombre(Nombre);
                            flor.setAroma(Aroma);
                            flor.setColor(Color);
                            flor.setPrecio(Precio);
                            flor.setStock(Stock);
                            flor.setFcreacion(fecha);
                            flor.setEstado(Estado);
                            flor.save();
                        }else {
                            crudFlor.this.flor.setIdflor(Integer.parseInt(jlbIdFlor.getText()));
                            flor.setNombre(Nombre);
                            flor.setAroma(Aroma);
                            flor.setColor(Color);
                            flor.setPrecio(Precio);
                            flor.setStock(Stock);
                            flor.setFcreacion(fecha);
                            flor.setEstado(Estado);
                            flor.update();
                        }
                }
                jtfNombre.setText("");
                jtfAroma.setText("");
                jtfColor.setText("");
                jtfPrecio.setText("0.0");
                jtfStock.setText("0");
                jtfEstado.setText("");
                jtfNombre.grabFocus();
            }
        });


        jbtnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conector c = new conector();
                int Idflor =Integer.parseInt(jlbIdFlor.getText());

                if (Idflor == 0){
                    jtfNombre.setText("");
                    jtfAroma.setText("");
                    jtfColor.setText("");
                    jtfPrecio.setText("0.0");
                    jtfStock.setText("0");
                    jtfEstado.setText("");
                    jtfNombre.grabFocus();
                }else {
                    String Consulta = "CALL EliminarFlores("+ Idflor +");";
                    c.ejecutarProcedimientoSinDatos(Consulta);
                    jlbIdFlor.setText("..");
                    jtfNombre.setText("");
                    jtfAroma.setText("");
                    jtfColor.setText("");
                    jtfPrecio.setText("0.0");
                    jtfStock.setText("0");
                    jtfEstado.setText("");
                    jtfNombre.grabFocus();
                }

            }
        });
    }
    /**/
}

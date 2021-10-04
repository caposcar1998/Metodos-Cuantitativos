import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CentrosCuadradosPage  {

    JFrame frameCentrosCuadrados = new JFrame();
    JButton ejecutarCC = new JButton("Ejecutar");
    JButton regresar = new JButton("Regresar");
    JLabel semillaCcTexto = new JLabel("Ingresa tu semilla");
    JLabel tituloCC= new JLabel("Centros Cuadrados");
    JTextField semillaCcPoner = new JTextField();
    JTextField iteracionCcPoner = new JTextField();
    JLabel iteracionCcTexto = new JLabel("Ingresa las iteraciones");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    ArrayList<RandomNumber> resultado = new ArrayList<>();

    public void run(){
        frameCentrosCuadrados.setSize(1000,1000);
        frameCentrosCuadrados.setLayout(null);
        frameCentrosCuadrados.setVisible(false);

        ejecutarCC.setBounds(100,350,200,40);
        semillaCcTexto.setBounds(100,100,200,40);
        iteracionCcTexto.setBounds(100,200,200,40);
        tituloCC.setBounds(100,0,200,100);
        semillaCcPoner.setBounds(100,125,200,40);
        iteracionCcPoner.setBounds(100,225,200,40);
        regresar.setBounds(10, 10, 80, 30);

        semillaCcPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = semillaCcPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    semillaCcPoner.setEditable(true);
                    semillaCcTexto.setText("");
                } else {
                    semillaCcPoner.setEditable(false);
                    semillaCcTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        iteracionCcPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = iteracionCcPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    iteracionCcPoner.setEditable(true);
                    iteracionCcTexto.setText("");
                } else {
                    iteracionCcPoner.setEditable(false);
                    iteracionCcTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        //Tabla
        model.addColumn("No. iteración");
        model.addColumn("Semilla");
        model.addColumn("No. aleatorio");
        model.addColumn("Aleatorio real");
        table.setBounds(400,100,500,700);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"No. iteración", "Semilla", "No. aleatorio", "Aleatorio real"});



        frameCentrosCuadrados.add(ejecutarCC);
        frameCentrosCuadrados.add(tituloCC);
        frameCentrosCuadrados.add(semillaCcTexto);
        frameCentrosCuadrados.add(iteracionCcTexto);
        frameCentrosCuadrados.add(semillaCcPoner);
        frameCentrosCuadrados.add(iteracionCcPoner);
        frameCentrosCuadrados.add(table);
        frameCentrosCuadrados.add(regresar);

        ejecutarCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CentrosCuadrados cc = new CentrosCuadrados(Integer.parseInt(semillaCcPoner.getText()),Integer.parseInt(iteracionCcPoner.getText()));
                resultado = cc.run() ;
                for (RandomNumber valor: resultado) {
                    model.addRow(new Object[]{valor.iteration,valor.seed,valor.randomNum,valor.actualRandomNum});
                }
            }
        });

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCentrosCuadrados.setVisible(false);
                Page pg = new Page();
                pg.run();
            }
        });
    }

    public void setVisible(){
        frameCentrosCuadrados.setVisible(true);

    }




}

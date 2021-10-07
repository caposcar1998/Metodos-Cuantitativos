import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GeneradorMultiplicativoPage {

    JFrame frameGeneradorMultiplicativo = new JFrame();
    JButton ejecutarGM = new JButton("Ejecutar");
    JButton regresar = new JButton("Regresar");
    JLabel tituloGM= new JLabel("Generador Multiplicativo");
    JLabel semillaGMTexto = new JLabel("Ingresa tu semilla");
    JTextField semillaGMPoner = new JTextField();
    JLabel iteracionGMTexto = new JLabel("Ingresa las iteraciones");
    JTextField iteracionGMPoner = new JTextField();
    JLabel aGMTexto = new JLabel("Ingresa a");
    JTextField aGMPoner = new JTextField();
    JLabel mGMTexto = new JLabel("Ingresa m");
    JTextField mGMPoner = new JTextField();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    ArrayList<RandomNumber> resultado = new ArrayList<>();
    //Scroll
    JScrollPane scroll_table = new JScrollPane(table);

    public void run(){
        frameGeneradorMultiplicativo.setSize(1000,1000);
        frameGeneradorMultiplicativo.setLayout(null);
        frameGeneradorMultiplicativo.setVisible(false);

        ejecutarGM.setBounds(100,525,200,40);
        regresar.setBounds(10, 10, 80, 30);
        tituloGM.setBounds(100,15,200,100);
        tituloGM.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        semillaGMTexto.setBounds(100,100,200,40);
        semillaGMPoner.setBounds(100,125,200,40);
        iteracionGMTexto.setBounds(100,200,200,40);
        iteracionGMPoner.setBounds(100,225,200,40);
        aGMTexto.setBounds(100,300,200,40);
        aGMPoner.setBounds(100,325,200,40);
        mGMTexto.setBounds(100,400,200,40);
        mGMPoner.setBounds(100,425,200,40);

        semillaGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = semillaGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    semillaGMPoner.setEditable(true);
                    semillaGMTexto.setText("");
                } else {
                    semillaGMPoner.setEditable(false);
                    semillaGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        iteracionGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = iteracionGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    iteracionGMPoner.setEditable(true);
                    iteracionGMTexto.setText("");
                } else {
                    iteracionGMPoner.setEditable(false);
                    iteracionGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        aGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = aGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    aGMPoner.setEditable(true);
                    aGMTexto.setText("");
                } else {
                    aGMPoner.setEditable(false);
                    aGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        mGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = mGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    mGMPoner.setEditable(true);
                    mGMTexto.setText("");
                } else {
                    mGMPoner.setEditable(false);
                    mGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        //Tabla
        model.addColumn("No. iteración");
        model.addColumn("Semilla");
        model.addColumn("No. aleatorio");
        model.addColumn("Aleatorio real");
        scroll_table.setBounds(400,100,500,700);

        frameGeneradorMultiplicativo.add(ejecutarGM);
        frameGeneradorMultiplicativo.add(tituloGM);
        frameGeneradorMultiplicativo.add(semillaGMTexto);
        frameGeneradorMultiplicativo.add(iteracionGMTexto);
        frameGeneradorMultiplicativo.add(semillaGMPoner);
        frameGeneradorMultiplicativo.add(iteracionGMPoner);
        frameGeneradorMultiplicativo.add(regresar);
        frameGeneradorMultiplicativo.add(aGMTexto);
        frameGeneradorMultiplicativo.add(aGMPoner);
        frameGeneradorMultiplicativo.add(mGMTexto);
        frameGeneradorMultiplicativo.add(mGMPoner);
        frameGeneradorMultiplicativo.add(scroll_table);

        ejecutarGM.addActionListener(e -> {
            GeneradorMultiplicativo gm = new GeneradorMultiplicativo(Integer.parseInt(semillaGMPoner.getText()),Integer.parseInt(aGMPoner.getText()), Integer.parseInt(mGMPoner.getText()));
            resultado = gm.run(Integer.parseInt(iteracionGMPoner.getText()));
            for (RandomNumber valor: resultado) {
                model.addRow(new Object[]{valor.iteration,valor.seed,valor.randomNum,valor.actualRandomNum});
            }
        });

        regresar.addActionListener(e -> {
            frameGeneradorMultiplicativo.setVisible(false);
            Page pg = new Page();
            pg.run();
        });


    }

    public void setVisible(){
        frameGeneradorMultiplicativo.setVisible(true);
    }


}

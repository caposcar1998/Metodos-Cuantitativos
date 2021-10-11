import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class CongruencialLinealCombinadoPage {

    JFrame frameCongruencialMixtoPage = new JFrame();
    JButton ejecutarGM = new JButton("Ejecutar");
    JButton regresar = new JButton("Regresar");
    JLabel tituloGM= new JLabel("Congruencial Lineal Combinado");
    JLabel iteracionGMTexto = new JLabel("Ingresa las iteraciones");
    JTextField iteracionGMPoner = new JTextField();
    JLabel aGMTexto = new JLabel("Ingresa a1");
    JTextField aGMPoner = new JTextField();
    JLabel mGMTexto = new JLabel("Ingresa m1");
    JTextField mGMPoner = new JTextField();
    JLabel a2GMTexto = new JLabel("Ingresa a2");
    JTextField a2GMPoner = new JTextField();
    JLabel m2GMTexto = new JLabel("Ingresa m2");
    JTextField m2GMPoner = new JTextField();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane scroll_table = new JScrollPane(table);
    ArrayList<ComplexRandomNumber> resultado = new ArrayList<>();

    JButton ejecutarChi = new JButton("Calcular chi cuadrada");
    JButton ejecutarKolmogorov = new JButton("Calcular Komogorov");
    JLabel tituloChiCuadrada = new JLabel("Chi cuadrada");
    JLabel textoChiCuadrada = new JLabel("Significancia");
    JLabel tituloKolmogorov = new JLabel("Kolmogorov-Smirnov");
    JTextField chiPoner = new JTextField();

    public void run(){
        frameCongruencialMixtoPage.setSize(1000,1000);
        frameCongruencialMixtoPage.setLayout(null);
        frameCongruencialMixtoPage.setVisible(false);

        ejecutarGM.setBounds(100,475,200,40);
        regresar.setBounds(10, 10, 100, 30);
        tituloGM.setBounds(100,15,250,100);
        tituloGM.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        iteracionGMTexto.setBounds(100,100,200,40);
        iteracionGMPoner.setBounds(100,125,200,40);
        aGMTexto.setBounds(100,175,200,40);
        aGMPoner.setBounds(100,200,200,40);
        mGMTexto.setBounds(100,250,200,40);
        mGMPoner.setBounds(100,275,200,40);
        a2GMTexto.setBounds(100,300,200,40);
        a2GMPoner.setBounds(100,325,200,40);
        m2GMTexto.setBounds(100,350,200,40);
        m2GMPoner.setBounds(100,375,200,40);
        tituloChiCuadrada.setBounds(100,535,200,40);
        textoChiCuadrada.setBounds(100,575,200,40);
        chiPoner.setBounds(100,615,200,40);
        ejecutarChi.setBounds(100, 670,200,40);
        tituloKolmogorov.setBounds(100,710,200,40);
        ejecutarKolmogorov.setBounds(100,760,200,40);

        iteracionGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = iteracionGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    iteracionGMPoner.setEditable(true);
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
                } else {
                    aGMPoner.setEditable(false);
                    aGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        a2GMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = a2GMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    a2GMPoner.setEditable(true);
                } else {
                    a2GMPoner.setEditable(false);
                    a2GMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        mGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = mGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    mGMPoner.setEditable(true);
                } else {
                    mGMPoner.setEditable(false);
                    mGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        m2GMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = m2GMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    m2GMPoner.setEditable(true);
                } else {
                    m2GMPoner.setEditable(false);
                    m2GMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        //Tabla
        model.addColumn("No. iteración");
        model.addColumn("Semilla 1");
        model.addColumn("Semilla 2");
        model.addColumn("Aleatorio real");
        scroll_table.setBounds(400,100,500,700);


        frameCongruencialMixtoPage.add(ejecutarGM);
        frameCongruencialMixtoPage.add(tituloGM);
        frameCongruencialMixtoPage.add(iteracionGMTexto);
        frameCongruencialMixtoPage.add(iteracionGMPoner);
        frameCongruencialMixtoPage.add(scroll_table);
        frameCongruencialMixtoPage.add(regresar);
        frameCongruencialMixtoPage.add(aGMTexto);
        frameCongruencialMixtoPage.add(aGMPoner);
        frameCongruencialMixtoPage.add(mGMTexto);
        frameCongruencialMixtoPage.add(mGMPoner);
        frameCongruencialMixtoPage.add(a2GMTexto);
        frameCongruencialMixtoPage.add(a2GMPoner);
        frameCongruencialMixtoPage.add(m2GMTexto);
        frameCongruencialMixtoPage.add(m2GMPoner);
        frameCongruencialMixtoPage.add(chiPoner);
        frameCongruencialMixtoPage.add(textoChiCuadrada);
        frameCongruencialMixtoPage.add(tituloKolmogorov);
        frameCongruencialMixtoPage.add(ejecutarKolmogorov);
        frameCongruencialMixtoPage.add(tituloChiCuadrada);
        frameCongruencialMixtoPage.add(ejecutarChi);

        ejecutarGM.addActionListener(e -> {
            CongruencialLinealCombinado lm = null;
            try {
                lm = new CongruencialLinealCombinado(Integer.parseInt(aGMPoner.getText()),Integer.parseInt(mGMPoner.getText()), Integer.parseInt(a2GMPoner.getText()), Integer.parseInt(m2GMPoner.getText()));
            } catch (Exception ex) {
                showMessageDialog(null, "Favor de llenar todos los campos");
            }
            model.setRowCount(0);
            resultado = lm.run(Integer.parseInt(iteracionGMPoner.getText()));

            for (ComplexRandomNumber valor: resultado) {
                model.addRow(new Object[]{valor.iteration,valor.seed1,valor.seed2,valor.actualRandomNum});
            }

        });

        regresar.addActionListener(e -> {
            frameCongruencialMixtoPage.setVisible(false);
            Page pg = new Page();
            pg.run();
        });

        ejecutarChi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!chiPoner.getText().isEmpty()){
                    java.util.List<Double> chiList=new ArrayList<Double>();
                    for (ComplexRandomNumber valor: resultado) {
                        chiList.add(valor.actualRandomNum);
                    }
                    Double chiValue = Double.parseDouble(chiPoner.getText());
                    ChiCuadrada chi = new ChiCuadrada(chiList, chiValue);
                    double chiSquare = chi.run();
                    if (chiSquare < chi.getChiSquareFromTable()) {
                        JOptionPane.showMessageDialog(null, "Chi cuadrada: Se acepta hipótesis nula, con valor de: "+ chiSquare  + "\n" + "valor en la tabla: " + chi.getChiSquareFromTable());
                        chiPoner.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Chi cuadrada: Se rechaza hipótesis nula, con valor de: "+ chiSquare  + "\n" + "valor en la tabla: " + chi.getChiSquareFromTable());
                        chiPoner.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Chi cuadrada tiene que tener un valor");
                }


            }
        });

        ejecutarKolmogorov.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Double> kList=new ArrayList<Double>();
                for (ComplexRandomNumber valor: resultado) {
                    kList.add(valor.actualRandomNum);
                }
                KolmogorovSmirnov ks = new KolmogorovSmirnov(kList);
                ks.run();
                JOptionPane.showMessageDialog(null, "D+: "+ ks.getDPlus()+ "\n" + "D-: "+ ks.getDMinus()  );
            }
        });



    }

    public void setVisible(){
        frameCongruencialMixtoPage.setVisible(true);
    }

}
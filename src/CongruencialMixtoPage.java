import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class CongruencialMixtoPage {

    JFrame frameCongruencialMixtoPage = new JFrame();
    JButton ejecutarGM = new JButton("Ejecutar");
    JButton regresar = new JButton("Regresar");
    JLabel tituloGM= new JLabel("Congruencial Mixto");
    JLabel semillaGMTexto = new JLabel("Ingresa tu semilla");
    JTextField semillaGMPoner = new JTextField();
    JLabel iteracionGMTexto = new JLabel("Ingresa las iteraciones");
    JTextField iteracionGMPoner = new JTextField();
    JLabel aGMTexto = new JLabel("Ingresa a");
    JTextField aGMPoner = new JTextField();
    JLabel mGMTexto = new JLabel("Ingresa m");
    JTextField mGMPoner = new JTextField();
    JLabel cGMTexto = new JLabel("Ingresa c");
    JTextField cGMPoner = new JTextField();
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane scroll_table = new JScrollPane(table);
    ArrayList<RandomNumber> resultado = new ArrayList<>();

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
        tituloGM.setBounds(100,15,200,100);
        tituloGM.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        semillaGMTexto.setBounds(100,100,200,40);
        semillaGMPoner.setBounds(100,125,200,40);
        iteracionGMTexto.setBounds(100,200,200,40);
        iteracionGMPoner.setBounds(100,225,200,40);
        aGMTexto.setBounds(100,275,200,40);
        aGMPoner.setBounds(100,300,200,40);
        mGMTexto.setBounds(100,350,200,40);
        mGMPoner.setBounds(100,375,200,40);
        cGMTexto.setBounds(100,400,200,40);
        cGMPoner.setBounds(100,425,200,40);
        tituloChiCuadrada.setBounds(100,535,200,40);
        textoChiCuadrada.setBounds(100,575,200,40);
        chiPoner.setBounds(100,615,200,40);
        ejecutarChi.setBounds(100, 670,200,40);
        tituloKolmogorov.setBounds(100,710,200,40);
        ejecutarKolmogorov.setBounds(100,760,200,40);

        semillaGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = semillaGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    semillaGMPoner.setEditable(true);
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

        cGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = cGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    cGMPoner.setEditable(true);
                } else {
                    cGMPoner.setEditable(false);
                    cGMTexto.setText("* Enter only numeric digits(0-9)");
                }
            }
        });

        //Tabla
        model.addColumn("No. iteración");
        model.addColumn("Semilla");
        model.addColumn("No. aleatorio");
        model.addColumn("Aleatorio real");
        scroll_table.setBounds(400,100,500,700);


        frameCongruencialMixtoPage.add(ejecutarGM);
        frameCongruencialMixtoPage.add(tituloGM);
        frameCongruencialMixtoPage.add(semillaGMTexto);
        frameCongruencialMixtoPage.add(iteracionGMTexto);
        frameCongruencialMixtoPage.add(semillaGMPoner);
        frameCongruencialMixtoPage.add(iteracionGMPoner);
        frameCongruencialMixtoPage.add(scroll_table);
        frameCongruencialMixtoPage.add(regresar);
        frameCongruencialMixtoPage.add(aGMTexto);
        frameCongruencialMixtoPage.add(aGMPoner);
        frameCongruencialMixtoPage.add(mGMTexto);
        frameCongruencialMixtoPage.add(mGMPoner);
        frameCongruencialMixtoPage.add(cGMTexto);
        frameCongruencialMixtoPage.add(cGMPoner);
        frameCongruencialMixtoPage.add(chiPoner);
        frameCongruencialMixtoPage.add(textoChiCuadrada);
        frameCongruencialMixtoPage.add(tituloKolmogorov);
        frameCongruencialMixtoPage.add(ejecutarKolmogorov);
        frameCongruencialMixtoPage.add(tituloChiCuadrada);
        frameCongruencialMixtoPage.add(ejecutarChi);

        ejecutarGM.addActionListener(e -> {
            CongruencialMixto gm = null;
            try {
            gm = new CongruencialMixto(Integer.parseInt(semillaGMPoner.getText()),Integer.parseInt(aGMPoner.getText()), Integer.parseInt(cGMPoner.getText()), Integer.parseInt(mGMPoner.getText()));
            } catch (Exception ex) {
                showMessageDialog(null, "Favor de llenar todos los campos");
            }
            model.setRowCount(0);
            ArrayList<String> hullDobell = gm.checkHullDobell();
            StringBuilder hdString = new StringBuilder();
            for(String cond: hullDobell)
            {
                hdString.append("\n");
                hdString.append(cond);
            }
            resultado = gm.run(Integer.parseInt(iteracionGMPoner.getText()));
            if (hullDobell.size() != 0) {
                int hdAlert = JOptionPane.showConfirmDialog(
                    null, "No cumple con el Teorema de Hull Dobell:" + hdString.toString() ,
                    "Seguro que deseas continuar?",
                    JOptionPane.YES_NO_OPTION);
                if (hdAlert == JOptionPane.NO_OPTION || hdAlert == JOptionPane.CLOSED_OPTION) {
                    resultado = new ArrayList<>();
                }
            }
            for (RandomNumber valor: resultado) {
                model.addRow(new Object[]{valor.iteration,valor.seed,valor.randomNum,valor.actualRandomNum});
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
                    List<Double> chiList=new ArrayList<Double>();
                    for (RandomNumber valor: resultado) {
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
                for (RandomNumber valor: resultado) {
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

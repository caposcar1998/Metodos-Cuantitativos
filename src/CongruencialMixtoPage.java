import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
    ArrayList<RandomNumber> resultado = new ArrayList<>();

    public void run(){
        frameCongruencialMixtoPage.setSize(1000,1000);
        frameCongruencialMixtoPage.setLayout(null);
        frameCongruencialMixtoPage.setVisible(false);

        ejecutarGM.setBounds(100,575,200,40);
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
        cGMTexto.setBounds(100,500,200,40);
        cGMPoner.setBounds(100,525,200,40);

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

        cGMPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = cGMPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    cGMPoner.setEditable(true);
                    cGMTexto.setText("");
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
        table.setBounds(400,100,500,700);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"No. iteración", "Semilla", "No. aleatorio", "Aleatorio real"});

        frameCongruencialMixtoPage.add(ejecutarGM);
        frameCongruencialMixtoPage.add(tituloGM);
        frameCongruencialMixtoPage.add(semillaGMTexto);
        frameCongruencialMixtoPage.add(iteracionGMTexto);
        frameCongruencialMixtoPage.add(semillaGMPoner);
        frameCongruencialMixtoPage.add(iteracionGMPoner);
        frameCongruencialMixtoPage.add(table);
        frameCongruencialMixtoPage.add(regresar);
        frameCongruencialMixtoPage.add(aGMTexto);
        frameCongruencialMixtoPage.add(aGMPoner);
        frameCongruencialMixtoPage.add(mGMTexto);
        frameCongruencialMixtoPage.add(mGMPoner);
        frameCongruencialMixtoPage.add(cGMTexto);
        frameCongruencialMixtoPage.add(cGMPoner);

        ejecutarGM.addActionListener(e -> {
            CongruencialMixto gm = null;
            try {
            gm = new CongruencialMixto(Integer.parseInt(semillaGMPoner.getText()),Integer.parseInt(aGMPoner.getText()), Integer.parseInt(cGMPoner.getText()), Integer.parseInt(mGMPoner.getText()));
            } catch (Exception ex) {
                showMessageDialog(null, "Favor de llenar todos los campos");
            }

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


    }

    public void setVisible(){
        frameCongruencialMixtoPage.setVisible(true);
    }
}

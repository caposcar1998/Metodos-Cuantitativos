import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        //Tabla
        model.addColumn("No. iteración");
        model.addColumn("Semilla");
        model.addColumn("No. aleatorio");
        model.addColumn("Aleatorio real");
        table.setBounds(400,100,500,700);
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"No. iteración", "Semilla", "No. aleatorio", "Aleatorio real"});

        frameGeneradorMultiplicativo.add(ejecutarGM);
        frameGeneradorMultiplicativo.add(tituloGM);
        frameGeneradorMultiplicativo.add(semillaGMTexto);
        frameGeneradorMultiplicativo.add(iteracionGMTexto);
        frameGeneradorMultiplicativo.add(semillaGMPoner);
        frameGeneradorMultiplicativo.add(iteracionGMPoner);
        frameGeneradorMultiplicativo.add(table);
        frameGeneradorMultiplicativo.add(regresar);
        frameGeneradorMultiplicativo.add(aGMTexto);
        frameGeneradorMultiplicativo.add(aGMPoner);
        frameGeneradorMultiplicativo.add(mGMTexto);
        frameGeneradorMultiplicativo.add(mGMPoner);

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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CentrosCuadradosPage  {

    JFrame frameCentrosCuadrados = new JFrame();
    JButton ejecutarCC = new JButton("Ejecutar");
    JButton regresar = new JButton("Regresar");
    JButton ejecutarChi = new JButton("Calcular chi cuadrada");
    JLabel semillaCcTexto = new JLabel("Ingresa tu semilla");
    JLabel tituloCC= new JLabel("Centros Cuadrados");
    JLabel tituloChiCuadrada = new JLabel("Chi cuadrada");
    JTextField chiPoner = new JTextField();
    JTextField semillaCcPoner = new JTextField();
    JTextField iteracionCcPoner = new JTextField();
    JLabel iteracionCcTexto = new JLabel("Ingresa las iteraciones");
    JLabel textoChiCuadrada = new JLabel("Valor");
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    JScrollPane scroll_table = new JScrollPane(table);
    ArrayList<RandomNumber> resultado = new ArrayList<>();

    public void run(){
        frameCentrosCuadrados.setSize(1000,1000);
        frameCentrosCuadrados.setLayout(null);
        frameCentrosCuadrados.setVisible(false);


        frameCentrosCuadrados.add(ejecutarCC);
        frameCentrosCuadrados.add(tituloCC);
        frameCentrosCuadrados.add(semillaCcTexto);
        frameCentrosCuadrados.add(iteracionCcTexto);
        frameCentrosCuadrados.add(semillaCcPoner);
        frameCentrosCuadrados.add(iteracionCcPoner);
        frameCentrosCuadrados.add(scroll_table);
        frameCentrosCuadrados.add(regresar);
        frameCentrosCuadrados.add(chiPoner);
        frameCentrosCuadrados.add(textoChiCuadrada);

        frameCentrosCuadrados.add(tituloChiCuadrada);
        frameCentrosCuadrados.add(ejecutarChi);


        ejecutarCC.setBounds(100,350,200,40);
        semillaCcTexto.setBounds(100,100,200,40);
        iteracionCcTexto.setBounds(100,200,200,40);
        tituloCC.setBounds(100,0,200,100);
        semillaCcPoner.setBounds(100,125,200,40);
        iteracionCcPoner.setBounds(100,225,200,40);
        regresar.setBounds(10, 10, 100, 30);
        tituloChiCuadrada.setBounds(100,400,200,40);
        textoChiCuadrada.setBounds(100,450,200,40);
        chiPoner.setBounds(100,500,200,40);
        ejecutarChi.setBounds(100, 550,200,40);


        semillaCcPoner.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = semillaCcPoner.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    semillaCcPoner.setEditable(true);
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
        scroll_table.setBounds(400,100,500,700);




        ejecutarCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(semillaCcPoner.getText().length() == 4){
                    if(iteracionCcPoner.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Pon cuantas iteraciones vas a hacer");
                    }else{
                        //Resetear tabla
                        model.setRowCount(0);
                        CentrosCuadrados cc = new CentrosCuadrados(Integer.parseInt(semillaCcPoner.getText()),Integer.parseInt(iteracionCcPoner.getText()));
                        resultado = cc.run() ;
                        for (RandomNumber valor: resultado) {
                            model.addRow(new Object[]{valor.iteration,valor.seed,valor.randomNum,valor.actualRandomNum});
                        }
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "La semilla tiene que ser de 4 caracteres");
                }

            }
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
                        JOptionPane.showMessageDialog(null, "Chi cuadrada: Se acepta hipótesis nula");
                        chiPoner.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Chi cuadrada: Se rechaza hipótesis nula");
                        chiPoner.setText("");
                    }
                }else{
                        JOptionPane.showMessageDialog(null, "Chi cuadrada tiene que tener un valor");
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

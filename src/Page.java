import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Page {
    JFrame frameInicial=new JFrame("GENERADORES DE NUMEROS RANDOM");//creating instance of JFrame
    CentrosCuadradosPage ccp = new CentrosCuadradosPage();
    GeneradorMultiplicativoPage gmp = new GeneradorMultiplicativoPage();
    CongruencialMixtoPage cmp = new CongruencialMixtoPage();
    CongruenciaLinealPage clp = new CongruenciaLinealPage();
    CongruencialLinealCombinadoPage clcp = new CongruencialLinealCombinadoPage();
    JButton centrosC=new JButton("Centros Cuadrados");//creating instance of JButton
    JLabel tituloInicial= new JLabel("Tecnológico de Monterrey", SwingConstants.CENTER);
    JLabel tituloProyecto= new JLabel("Proyecto 1 - Métodos Cuantitativos y Simulación", SwingConstants.CENTER);
    JLabel tituloNumeros = new JLabel("Simulador de Números Random", SwingConstants.CENTER);
    JLabel labelEquipo = new JLabel("Miembros del equipo: Oscar Contreras, Jorge Akio Olvera, Miguel Hernández, Mónica Lara & Rafael Rojas.", SwingConstants.CENTER);
    JLabel labelExplicacion = new JLabel("<html><p>Este programa muestra la funcionalidad de los métodos más usados para la generación de números random. " +
            "Se encuentra el Método de los Centros Cuadrados, Congruencial Lineal, Congruencial Mixto c/ validación HULL-DOBELL, Generador Multiplicativo y Congruencial Lineal Combinado. " +
            "Los casos MC, MCM y GM cuentan con la opción de validación de Chi-Cuadrada y Kolmogorov-Smirnov.</p></html>");
    JButton congruenciaL= new JButton("Congruencia Lineal");
    JButton congruenciaM= new JButton("Congruencia Mixto");
    JButton congruencialLC= new JButton("Congruencial Lineal Combinado");
    JButton generadorM= new JButton("Generador Multiplicativo");

    public void run(){

        centrosC.setBounds(700,250,260, 50);//x axis, y axis, width, height
        centrosC.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        ccp.run();
        centrosC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicial.setVisible(false);
                ccp.setVisible();
            }
        });

        //Inicial
        tituloInicial.setBounds(375,0,250,100);
        tituloInicial.setFont(new Font("Helvetica Neue", Font.BOLD, 18));
        tituloInicial.setForeground(new Color(4,88,166));
        tituloProyecto.setBounds(310,30,400,100);
        tituloProyecto.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        tituloNumeros.setBounds(100,150,250,100);
        tituloNumeros.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        labelEquipo.setBounds(80,710,800,100);
        labelEquipo.setFont(new Font("Helvetica Neue", Font.ITALIC, 14));
        labelExplicacion.setBounds(70,180,400,300);
        labelExplicacion.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));

        // Buttons
        congruenciaL.setBounds(700,310,260, 50);
        congruenciaL.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        clp.run();
        congruenciaL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicial.setVisible(false);
                clp.setVisible();
            }
        });
        congruenciaM.setBounds(700,370,260, 50);
        congruenciaM.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        cmp.run();
        congruenciaM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicial.setVisible(false);
                cmp.setVisible();
            }
        });

        congruencialLC.setBounds(700,430,260, 50);
        congruencialLC.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        clcp.run();
        congruencialLC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frameInicial.setVisible(false);
                clcp.setVisible();
            }
        });

        generadorM.setBounds(700,490,260, 50);
        generadorM.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
        gmp.run();
        generadorM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicial.setVisible(false);
                gmp.setVisible();
            }
        });

        
        frameInicial.add(centrosC);//adding button in JFrame
        frameInicial.add(congruenciaL);
        frameInicial.add(congruenciaM);
        frameInicial.add(congruencialLC);
        frameInicial.add(generadorM);
        frameInicial.add(tituloInicial);
        frameInicial.add(tituloProyecto);
        frameInicial.add(tituloNumeros);
        frameInicial.add(labelEquipo);
        frameInicial.add(labelExplicacion);

        //Full page
        frameInicial.setSize(1000,1000);//400 width and 500 height
        frameInicial.setLayout(null);//using no layout managers
        frameInicial.setVisible(true);//making the frame visible

    }

    public void setVisible(){
        frameInicial.setVisible(true);
    }

}

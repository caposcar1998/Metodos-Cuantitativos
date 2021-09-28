import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Page {
    JFrame frameInicial=new JFrame("Fullscreen");//creating instance of JFrame
    CentrosCuadradosPage ccp = new CentrosCuadradosPage();
    JButton centrosC=new JButton("Centros Cuadrados");//creating instance of JButton
    JLabel tituloInicial= new JLabel("Tecnológico de Monterrey");
    JButton congruenciaL= new JButton("Congruencia Lineal");
    JButton congruenciaM= new JButton("Congruencia Mixto");
    JButton rafa= new JButton("El de rafa");
    JButton moni= new JButton("El de moni");

    public void run(){

        centrosC.setBounds(100,100,200, 40);//x axis, y axis, width, height
        ccp.run();
        centrosC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameInicial.setVisible(false);
                ccp.setVisible();

            }
        });

        //Inicial


        tituloInicial.setBounds(100,0,200,100);
        congruenciaL.setBounds(100,150,200, 40);
        congruenciaM.setBounds(100,200,200, 40);
        rafa.setBounds(100,250,200, 40);
        moni.setBounds(100,300,200, 40);

        frameInicial.add(centrosC);//adding button in JFrame
        frameInicial.add(congruenciaL);
        frameInicial.add(congruenciaM);
        frameInicial.add(rafa);
        frameInicial.add(moni);
        frameInicial.add(tituloInicial);

        //Full page
        frameInicial.setSize(1000,1000);//400 width and 500 height
        frameInicial.setLayout(null);//using no layout managers
        frameInicial.setVisible(true);//making the frame visible





    }

    public void setVisible(){
        frameInicial.setVisible(true);
    }




}

package edu.gorilas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Hello world!
 *
 */
public class App extends JFrame
{
    private App(){
        super("Yatzi !!");
    }

    private void ejecuta() {
        Container contenedor = getContentPane();
        JPanel panelNorte = new JPanel();
        panelNorte.add(new JButton("Norte 1"));
        panelNorte.add(new JButton("Norte 2"));
        panelNorte.add(new JButton("Norte 3"));
        contenedor.add(panelNorte, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.PAGE_AXIS));
        JButton boton = new JButton("Centro 1");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(boton);
        boton = new JButton("Centro 2");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(boton);
        boton = new JButton("Centro 3");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(boton);
        contenedor.add(panelCentro);
        /* setSize(800, 600); */
        pack(); // Ajusta el tamaño de la ventana a sus componentes
        setVisible(true);
    }
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new App().ejecuta();
        }
        });
    }
}

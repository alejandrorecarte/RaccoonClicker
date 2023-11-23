package view;

import model.Generador;
import model.Generadores.Puntero;
import model.Generadores.Runas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    protected ArrayList<Generador> generadores;
    protected JFrame f;
    protected JPanel p;
    protected JPanel p1;
    protected JPanel p2;
    protected JLabel lDinero;
    protected JButton bMapache;
    protected ArrayList<JButton> botonesMejoras;
    private JPanel pMejoras;
    protected JScrollPane scrollPane;


    public GUI() {

        generadores = new ArrayList<Generador>();
        f = new JFrame();
        p = new JPanel(new GridLayout(1, 2));

        p1 = new JPanel(new GridBagLayout());
        p2 = new JPanel(new GridBagLayout());

        f.add(p);
        p.add(p1);
        p.add(p2);

        lDinero = new JLabel("0 PM");
        p1.add(lDinero, new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(10,10,3,3), 0, 0));
        bMapache = new JButton ();
        bMapache.setIcon(new ImageIcon("src/mapacheMago-icon.png"));
        p1.add(bMapache, new GridBagConstraints(0,1, 1, 1,1.0,10.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,10,10,3), 0, 0));

        ArrayList<JButton> botonesMejoras = new ArrayList<>();

        generadores.add(new Puntero());
        botonesMejoras.add(new JButton(generadores.get(0).getNombre()+ " | " + generadores.get(0).getPrecio() +"PM | " + generadores.get(0).getCantidad()));
        generadores.add(new Runas());
        botonesMejoras.add(new JButton (generadores.get(1).getNombre()+ " | " + generadores.get(1).getPrecio() +"PM | " + generadores.get(1).getCantidad()));

        pMejoras = new JPanel(new GridLayout(2,0));

        scrollPane = new JScrollPane(pMejoras);
        p2.add(scrollPane, new GridBagConstraints(0,0, 1, 1,1.0,1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10,3,10,10), 0, 0));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0, 0,500, 500);
        f.setVisible(true);
        f.setResizable(false);

    }


}

package view;

import model.Generador;
import model.Generadores.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private final static int[] COD_PRINCIPAL = {117,158,255};
    private final static int[] COD_BOTON = {255,95,124};
    private final static int[] COD_BOTON_HOVER = {128,73,106};

    protected final static Color COLOR_PRINCIPAL = new Color(COD_PRINCIPAL[0], COD_PRINCIPAL[1], COD_PRINCIPAL[2]);
    protected final static Color COLOR_BOTON = new Color(COD_BOTON[0], COD_BOTON[1], COD_BOTON[2]);
    protected final static Color COLOR_BOTON_HOVER = new Color(COD_BOTON_HOVER[0], COD_BOTON_HOVER[1], COD_BOTON_HOVER[2]);

    protected ArrayList<Generador> generadores;
    protected JFrame f;
    protected JPanel p;
    protected JPanel p1;
    protected JPanel p2;
    protected JLabel lDinero;
    protected JLabel bMapache;
    protected JPanel pMapache;
    protected ArrayList<JPanel> botonesMejoras;
    private JPanel pMejoras;
    protected JScrollPane scrollPane;


    public GUI() {

        generadores = new ArrayList<Generador>();
        f = new JFrame("Raccoon Clicker");
        f.setBackground(COLOR_PRINCIPAL);

        p = new JPanel(new GridLayout(1, 2));
        p.setBackground(COLOR_PRINCIPAL);

        p1 = new JPanel(new GridBagLayout());
        p2 = new JPanel(new GridBagLayout());
        p1.setBackground(COLOR_PRINCIPAL);
        p2.setBackground(COLOR_PRINCIPAL);

        f.add(p);
        p.add(p1);
        p.add(p2);

        lDinero = new JLabel("0 PM");
        lDinero.setFont(new Font("Arial", Font.PLAIN, 24));
        p1.add(lDinero, new GridBagConstraints(0,0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(10,10,3,3), 0, 0));
        bMapache = new JLabel();
        pMapache = new JPanel();
        pMapache.setBackground(COLOR_BOTON);
        pMapache.setBorder(new LineBorder(COLOR_BOTON_HOVER,2));
        bMapache.setIcon(new ImageIcon("src/mapacheMago-icon.png"));

        pMapache.add(bMapache);

        p1.add(pMapache, new GridBagConstraints(0,1, 1, 1,1.0,10.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(3,10,10,3), 0, 0));

        botonesMejoras = new ArrayList<>();

        generadores.add(new Puntero());
        generadores.add(new Runa());
        generadores.add(new Palantir());
        generadores.add(new Aprendiz());
        generadores.add(new Ritual());
        generadores.add(new Altar());
        generadores.add(new Portal());
        generadores.add(new TorreMago());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());
        generadores.add(new Puntero());

        pMejoras = new JPanel(new GridLayout(18,0));
        pMejoras.setBackground(COLOR_PRINCIPAL);
        pMejoras.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));

        for(int i = 0; i < generadores.size(); i++) {
            JPanel p = new JPanel();
            JLabel b = new JLabel(generadores.get(i).getText());
            p.add(b);
            p.setBackground(COLOR_PRINCIPAL);
            p.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));
            botonesMejoras.add(p);
            pMejoras.add(botonesMejoras.get(i));
        }

        JLabel lMejoras = new JLabel("Mejoras:");
        lMejoras.setFont(new Font("Arial", Font.PLAIN, 24));;
        scrollPane = new JScrollPane(pMejoras);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(COLOR_BOTON_HOVER);
        scrollBar.setUI(new CustomScrollBarUI());
        scrollBar.setBorder(new LineBorder(COLOR_PRINCIPAL, 1));
        scrollPane.setVerticalScrollBar(scrollBar);
        scrollPane.setBorder(new LineBorder(COLOR_BOTON_HOVER, 1));
        scrollPane.setBackground(COLOR_BOTON);

        p2.add(lMejoras, new GridBagConstraints(0,0, 1, 1,1.0,1.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(10,3,3,10), 0, 0));
        p2.add(scrollPane, new GridBagConstraints(0,1, 1, 1,1.0,10.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,3,10,10), 0, 0));

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(0, 0,1000, 500);
        f.setVisible(true);
        f.setResizable(false);

    }

    static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = COLOR_BOTON;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            Dimension zeroDim = new Dimension(0, 0);
            button.setPreferredSize(zeroDim);
            button.setMinimumSize(zeroDim);
            button.setMaximumSize(zeroDim);
            return button;
        }
    }

}

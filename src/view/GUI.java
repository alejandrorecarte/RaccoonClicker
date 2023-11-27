package view;

import model.Generador;
import model.Generadores.*;
import model.Mejora;

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
    protected ArrayList<Mejora> mejoras;
    protected ArrayList<Mejora> mejorasComprados;
    protected JFrame f;
    protected JPanel p;
    protected JPanel p1;
    protected JPanel p2;
    protected JLabel lDinero;
    protected JLabel bMapache;
    protected JPanel pMapache;
    protected ArrayList<JPanel> botonesGeneradores;
    protected JPanel pGeneradores;
    protected JScrollPane spGeneradores;
    protected JLabel lMejoras;
    protected JScrollPane spMejoras;
    protected ArrayList<JPanel> botonesMejoras;
    protected JLabel lGeneradores;
    protected JPanel pMejoras;
    protected ArrayList<JPanel> botonesMejorasComprados;


    public GUI() {

        generadores = new ArrayList<Generador>();
        mejoras = new ArrayList<Mejora>();
        mejorasComprados = new ArrayList<Mejora>();
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
        bMapache.setIcon(new ImageIcon("src/view/icons/raccoon_icon.png"));

        pMapache.add(bMapache);

        p1.add(pMapache, new GridBagConstraints(0,1, 1, 1,1.0,10.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(3,10,10,3), 0, 0));

        botonesGeneradores = new ArrayList<>();

        generadores.add(new Puntero());
        generadores.add(new Runa());
        generadores.add(new Varita());
        generadores.add(new Palantir());
        generadores.add(new Aprendiz());
        generadores.add(new Ritual());
        generadores.add(new Altar());
        generadores.add(new Portal());
        generadores.add(new TorreMago());

        pGeneradores = new JPanel(new GridLayout(18,0));
        pGeneradores.setBackground(COLOR_PRINCIPAL);
        pGeneradores.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));

        for(int i = 0; i < generadores.size(); i++) {
            JPanel p = new JPanel();
            JLabel b = new JLabel(generadores.get(i).getText());
            p.add(b);
            p.setBackground(COLOR_PRINCIPAL);
            p.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));
            botonesGeneradores.add(p);
            pGeneradores.add(botonesGeneradores.get(i));
        }

        lGeneradores = new JLabel("Generadores:");
        lGeneradores.setFont(new Font("Arial", Font.PLAIN, 24));;
        JScrollBar scrollBarGeneradores = new JScrollBar();
        scrollBarGeneradores.setBackground(COLOR_BOTON_HOVER);
        scrollBarGeneradores.setUI(new CustomScrollBarUI());
        scrollBarGeneradores.setBorder(new LineBorder(COLOR_PRINCIPAL, 1));
        spGeneradores = new JScrollPane(pGeneradores);
        spGeneradores.setVerticalScrollBar(scrollBarGeneradores);
        spGeneradores.setBorder(new LineBorder(COLOR_BOTON_HOVER, 1));
        spGeneradores.setBackground(COLOR_BOTON);

        botonesMejoras = new ArrayList<>();
        botonesMejorasComprados = new ArrayList<>();

        mejoras.add(new Mejora("Puntero ágil", 2, generadores.get(0), 500));
        mejoras.add(new Mejora("Puntero de habilidad", 3, generadores.get(0), 1000));
        mejoras.add(new Mejora("Runa brillante", 2, generadores.get(0), 5000));
        mejoras.add(new Mejora("Runa poderosa", 3, generadores.get(0), 10000));

        pMejoras = new JPanel(new GridLayout(4,0));
        pMejoras.setBackground(COLOR_PRINCIPAL);
        pMejoras.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));

        for(int i = 0; i < mejoras.size(); i++) {
            JPanel p = new JPanel();
            JLabel b = new JLabel(mejoras.get(i).getText());
            p.add(b);
            p.setBackground(COLOR_PRINCIPAL);
            p.setBorder(new LineBorder(COLOR_BOTON_HOVER,1));
            botonesMejoras.add(p);
            pMejoras.add(botonesMejoras.get(i));
        }

        lMejoras = new JLabel ("Mejoras:");
        lMejoras.setFont(new Font("Arial", Font.PLAIN, 24));;
        JScrollBar scrollBarEvoluciones = new JScrollBar();
        scrollBarEvoluciones.setBackground(COLOR_BOTON_HOVER);
        scrollBarEvoluciones.setUI(new CustomScrollBarUI());
        scrollBarEvoluciones.setBorder(new LineBorder(COLOR_PRINCIPAL, 1));
        spMejoras = new JScrollPane(pMejoras);
        spMejoras.setBorder(new LineBorder(COLOR_PRINCIPAL, 1));
        spMejoras.setVerticalScrollBar(scrollBarEvoluciones);
        spMejoras.setBackground(COLOR_BOTON);

        p2.add(lGeneradores, new GridBagConstraints(0,0, 1, 1,1.0,1.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(10,3,3,10), 0, 0));
        p2.add(spGeneradores, new GridBagConstraints(0,1, 1, 1,1.0,3.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(3,3,3,10), 0, 0));
        p2.add(lMejoras, new GridBagConstraints(0,2, 1, 1,1.0,1.0, GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(3,3,3,10), 0, 0));
        p2.add(spMejoras, new GridBagConstraints(0,3, 1, 1,1.0,3.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
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

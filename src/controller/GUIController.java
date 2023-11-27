package controller;

import view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static controller.xml.EscribirXML.escribirXML;
import static controller.xml.LeerXML.*;

public class GUIController extends GUI {

    private long dineroTotal;
    private boolean parar = false;

    public GUIController() {
        dineroTotal = leerDineroTotalXML();

        generadores = leerGeneradoresXML(generadores);

        mejorasComprados = leerMejorasXML(mejoras);

        for(int i = 0; i < mejoras.size(); i++) {
            for (int j = 0; j < mejorasComprados.size(); j++) {
                System.out.println(mejorasComprados.get(j).getNombre());
                botonesMejorasComprados.add(botonesMejoras.get(i));
                botonesMejoras.remove(botonesMejorasComprados.get(j));
                mejoras.remove(mejorasComprados.get(j));
            }
            pMejoras.setLayout(new GridLayout(mejorasComprados.size(), 1));
        }

        for(int i = 0; i < botonesGeneradores.size(); i++) {
            JLabel l = (JLabel) botonesGeneradores.get(i).getComponents()[0];
            l.setText(generadores.get(i).getText());
            int finalI = i;
            botonesGeneradores.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (generadores.get(finalI).getPrecio() <= dineroTotal) {
                        dineroTotal -= generadores.get(finalI).getPrecio();
                        generadores.get(finalI).comprarMejora(1);
                        JLabel l = (JLabel) botonesGeneradores.get(finalI).getComponents()[0];
                        l.setText(generadores.get(finalI).getText());
                        comprobarBotones();
                    }
                }
            });
        }
        for(int i = 0; i < botonesMejoras.size(); i++) {
            int finalI = i;
            botonesMejoras.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (mejoras.get(finalI).getPrecio() <= dineroTotal) {
                        dineroTotal -= mejoras.get(finalI).getPrecio();
                        JLabel l = (JLabel) botonesMejoras.get(finalI).getComponents()[0];
                        l.setText(mejoras.get(finalI).getText());
                        mejorasComprados.add(mejoras.get(finalI));
                        mejoras.remove(finalI);
                        botonesMejorasComprados.add(botonesMejoras.get(finalI));
                        botonesMejoras.remove(finalI);
                        pMejoras.remove(finalI);
                        pMejoras.setLayout(new GridLayout(botonesMejoras.size(), 0));
                        comprobarBotones();
                    }
                }
            });
        }


        pMapache.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dineroTotal += 1;
                lDinero.setText(formatearNumero(dineroTotal) + " Puntos Mágicos");
                cambiarDeColorMapache();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    escribirXML(dineroTotal, generadores, mejorasComprados);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        clock();
    }

    public void cambiarDeColorMapache(){
        bMapache.setIcon(new ImageIcon("src/view/icons/raccoon_icon_pressed.png"));

        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            bMapache.setIcon(new ImageIcon("src/view/icons/raccoon_icon.png"));
        });
    }

    public void clock() {
        while (parar == false) {
            try {
                dineroTotal += comprobarBotones();
                lDinero.setText(formatearNumero(dineroTotal)+ " Puntos Mágicos");
                Thread.sleep(250);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String formatearNumero(long numero) {
        if (numero < 1000) {
            return String.valueOf(numero);
        } else {
            String[] sufijos = {"", "K", "M", "B", "T"};
            double numeroDecimal = (double) numero;
            int indice = 0;
            while (Math.abs(numeroDecimal) >= 1000 && indice < sufijos.length - 1) {
                numeroDecimal /= 1000;
                indice++;
            }
            return String.format("%.1f%s", numeroDecimal, sufijos[indice]);
        }
    }

    public long comprobarBotones(){
        long dinero = 0;
        for (int i = 0; i < generadores.size(); i++) {

            long dineroGenerador = generadores.get(i).getDineroPorSeg();

            for (int j = 0; j < mejorasComprados.size(); j++) {
                if(mejorasComprados.get(j).getGenerador().equals(generadores.get(i))){
                    dineroGenerador = dineroGenerador * mejorasComprados.get(j).getMultiplicador();
                }
            }

            dinero += dineroGenerador;

            if(dineroTotal < generadores.get(i).getPrecio()) {
                botonesGeneradores.get(i).setBackground(COLOR_BOTON_HOVER);
                JLabel l = (JLabel) botonesGeneradores.get(i).getComponent(0);
                l.setForeground(Color.LIGHT_GRAY);
                botonesGeneradores.get(i).repaint();
                botonesGeneradores.get(i).revalidate();
            }else{
                botonesGeneradores.get(i).setBackground(COLOR_BOTON);
                JLabel l = (JLabel) botonesGeneradores.get(i).getComponent(0);
                l.setForeground(Color.WHITE);
                botonesGeneradores.get(i).repaint();
                botonesGeneradores.get(i).revalidate();
                }
        }

        for (int j= 0; j < mejoras.size(); j++){
            botonesMejoras.get(j).repaint();
            botonesMejoras.get(j).revalidate();
            spMejoras.repaint();
            spMejoras.revalidate();
            pMejoras.repaint();
            pMejoras.revalidate();

            if(dineroTotal < mejoras.get(j).getPrecio()) {
                botonesMejoras.get(j).setBackground(COLOR_BOTON_HOVER);
                JLabel l = (JLabel) botonesMejoras.get(j).getComponent(0);
                l.setForeground(Color.LIGHT_GRAY);
                botonesMejoras.get(j).repaint();
                botonesMejoras.get(j).revalidate();
            } else {
                botonesMejoras.get(j).setBackground(COLOR_BOTON);
                JLabel l = (JLabel) botonesMejoras.get(j).getComponent(0);
                l.setForeground(Color.WHITE);
                botonesMejoras.get(j).repaint();
                botonesMejoras.get(j).revalidate();
            }
        }

        return dinero;
    }
}

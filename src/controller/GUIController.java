package controller;

import view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIController extends GUI {

    private long dineroTotal = 0;
    private boolean parar = false;

    public GUIController() {
        for(int i = 0; i < botonesMejoras.size(); i++) {
            int finalI = i;
            botonesMejoras.get(i).addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (generadores.get(finalI).getPrecio() <= dineroTotal) {
                        dineroTotal -= generadores.get(finalI).getPrecio();
                        generadores.get(finalI).comprarMejora(1);
                        JLabel l = (JLabel) botonesMejoras.get(finalI).getComponents()[0];
                                l.setText(generadores.get(finalI).getText());
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

        clock();
    }

    public void cambiarDeColorMapache(){
        pMapache.setBackground(COLOR_BOTON_HOVER);

        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            pMapache.setBackground(COLOR_BOTON);
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

            dinero += generadores.get(i).getDineroPorSeg();

            if(dineroTotal < generadores.get(i).getPrecio()) {
                botonesMejoras.get(i).setBackground(COLOR_BOTON_HOVER);
                JLabel l = (JLabel) botonesMejoras.get(i).getComponent(0);
                l.setForeground(Color.LIGHT_GRAY);
                botonesMejoras.get(i).repaint();
                botonesMejoras.get(i).revalidate();
            }else{
                botonesMejoras.get(i).setBackground(COLOR_BOTON);
                JLabel l = (JLabel) botonesMejoras.get(i).getComponent(0);
                l.setForeground(Color.WHITE);
                botonesMejoras.get(i).repaint();
                botonesMejoras.get(i).revalidate();
                }
        }
        return dinero;
    }
}

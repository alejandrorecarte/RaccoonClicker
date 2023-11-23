package controller;


import view.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class GUIController extends GUI {

    private int dineroTotal = 0;
    private boolean parar = false;

    public GUIController() {
        listaDeBotones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JList<String> list = (JList<String>) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                if (index >= 0 && index < botonesMejoras.size() && generadores.get(index).getPrecio() <= dineroTotal) {
                    dineroTotal -= generadores.get(index).getPrecio();
                    generadores.get(index).comprarMejora(1);
                    botonesMejoras.remove(index);
                    botonesMejoras.add(index, generadores.get(index).getNombre()+ " | " + generadores.get(index).getPrecio() +" PM | " + generadores.get(index).getCantidad());
                    comprobarBotones();
                }
            }
        });

        bMapache.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineroTotal += 1;
                lDinero.setText(dineroTotal + " Puntos Mágicos");
            }
        });

        clock();
    }

    public void clock() {
        while (parar == false) {
            try {
                dineroTotal += comprobarBotones();
                lDinero.setText(dineroTotal + " Puntos Mágicos");
                Thread.sleep(250);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public int comprobarBotones(){
        int dinero = 0;
        for (int i = 0; i < generadores.size(); i++) {

            dinero += generadores.get(i).getDineroPorSeg();
            Component componente = listaDeBotones.getCellRenderer().getListCellRendererComponent(listaDeBotones,
                    listaModelo.getElementAt(i), i, false, false);

            if (componente instanceof JButton) {
                JButton boton = (JButton) componente;
                if(dineroTotal < generadores.get(i).getPrecio()) {
                    boton.setEnabled(false);
                    listaDeBotones.repaint();
                    listaDeBotones.revalidate();
                }else{
                    boton.setEnabled(true);
                    listaDeBotones.repaint();
                    listaDeBotones.revalidate();
                }
            }
        }
        return dinero;
    }
}

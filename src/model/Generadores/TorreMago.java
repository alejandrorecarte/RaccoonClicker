package model.Generadores;

import model.Generador;

public class TorreMago extends Generador {
    private final String[] NOMBRES = {"Torre pequeña", "Torre media", "Torre mágica", "Torre arcana", "Torre de Sauron"};
    private int dineroBase = 100000;
    private int precio = 100000000;

    public TorreMago() {
        this.setNombre(NOMBRES[0]);
        this.setDineroBase(dineroBase);
        this.setCantidad(0);
        this.setPrecio(precio);
    }

    public void comprarMejora(int cantidad) {
        this.setCantidad(this.getCantidad() + cantidad);
        for(int i = 0; i < cantidad; i++) {
            this.setPrecio((int) (this.getPrecio() + (this.getPrecio() * 0.25)));
        }
        if (this.getCantidad() >= 100){
            this.setNombre(NOMBRES[1]);
        }else if(this.getCantidad() >= 200){
            this.setNombre(NOMBRES[2]);
        }else if(this.getCantidad() >= 300){
            this.setNombre(NOMBRES[3]);
        }else if(this.getCantidad() >= 400){
            this.setNombre(NOMBRES[4]);
        }
    }

    public String getText() {
        return getNombre() + " | " + controller.GUIController.formatearNumero(getPrecio()) + " PM | " + getCantidad();
    }
}

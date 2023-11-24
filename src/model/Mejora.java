package model;

public class Mejora {

    private String nombre;
    private int multiplicador;
    private Generador generador;
    private long precio;

    public Mejora(String nombre, int multiplicador, Generador generador, long precio) {
        this.nombre = nombre;
        this.multiplicador = multiplicador;
        this.generador = generador;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Generador getGenerador() {
        return generador;
    }

    public void setGenerador(Generador generador) {
        this.generador = generador;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }


    public String getText() {
        return getNombre();
    }
}

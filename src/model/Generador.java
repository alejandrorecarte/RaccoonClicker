package model;

public abstract class Generador {

    private String nombre;
    private int dineroPorSeg;
    private int dineroBase;
    private int cantidad;
    private int precio;

    public Generador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDineroBase() {
        return dineroBase;
    }

    public void setDineroBase(int dineroBase) {
        this.dineroBase = dineroBase;
        this.dineroPorSeg = cantidad * dineroBase;
    }

    public int getDineroPorSeg() {
        return dineroPorSeg;
    }

    public void setDineroPorSeg(int dineroPorSeg) {
        this.dineroPorSeg = dineroPorSeg;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.dineroPorSeg = cantidad * dineroBase;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public abstract void comprarMejora(int cantidad);
}

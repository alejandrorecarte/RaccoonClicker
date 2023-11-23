package model;

public abstract class Generador {

    private String nombre;
    private long dineroPorSeg;
    private long dineroBase;
    private int cantidad;
    private long precio;

    public Generador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDineroBase() {
        return dineroBase;
    }

    public void setDineroBase(long dineroBase) {
        this.dineroBase = dineroBase;
        this.dineroPorSeg = cantidad * dineroBase;
    }

    public long getDineroPorSeg() {
        return dineroPorSeg;
    }

    public void setDineroPorSeg(long dineroPorSeg) {
        this.dineroPorSeg = dineroPorSeg;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.dineroPorSeg = cantidad * dineroBase;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public abstract void comprarMejora(int cantidad);

    public abstract String getText();
}

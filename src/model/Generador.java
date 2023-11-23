package model;

public abstract class Generadores {

    private double dineroPorSeg;
    private double dineroBase;
    private int cantidad;

    public Generadores(double dineroPorSeg, double dineroBase, int cantidad) {
        this.dineroPorSeg = dineroPorSeg;
        this.dineroBase = dineroBase;
        this.cantidad = cantidad;
    }

    public double getDineroBase() {
        return dineroBase;
    }

    public void setDineroBase(double dineroBase) {
        this.dineroBase = dineroBase;
        this.dineroPorSeg = cantidad * dineroBase;
    }

    public double getDineroPorSeg() {
        return dineroPorSeg;
    }

    public void setDineroPorSeg(double dineroPorSeg) {
        this.dineroPorSeg = dineroPorSeg;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        this.dineroPorSeg = cantidad * dineroBase;
    }
}

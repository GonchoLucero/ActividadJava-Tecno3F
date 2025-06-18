public abstract class Arma {

    protected int municiones;
    protected double alcanceMetros;
    protected String marca;
    protected double calibre;
    protected String estado;
    protected Policia policia;

    public Arma(int municiones, double alcanceMetros, String marca, double calibre, String estado,  Policia policia) {
        this.municiones = municiones;
        this.alcanceMetros = alcanceMetros;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
        this.policia = policia;
    }

    public int getMuniciones() {
        return municiones;
    }

    public double getAlcanceMetros() {
        return alcanceMetros;
    }

    public String getMarca() {
        return marca;
    }

    public double getCalibre() {
        return calibre;
    }

    public String getEstado() {
        return estado;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // METODO PARA VERIFICAR SI EL ARMA ESTA EN CONDICIONES O NO //
    public boolean estaEnCondiciones() {
        return estado.equals("EN USO") && calibre >= 9;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Calibre: " + calibre + ", Estado: " + estado +
                ", Municiones: " + municiones + ", Alcance: " + alcanceMetros + "m";
    }
}

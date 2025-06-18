public class ArmaLarga extends Arma implements Comparable<ArmaLarga> {
    private boolean tieneSelloRENAR;
    private String descripcionUso;
    private int nivel;

    public ArmaLarga(int municiones, double alcanceMetros, String marca, double calibre, String estado, Policia policia,
                     boolean tieneSelloRENAR, String descripcionUso, int nivel) {
        super(municiones, alcanceMetros, marca, calibre, estado, policia);
        this.tieneSelloRENAR = tieneSelloRENAR;
        this.descripcionUso = descripcionUso;

        if (nivel >= 1 && nivel <= 5){
            this.nivel = nivel;
        } else {
            throw new Error("El nivel debe estar entre 1 y 5");
        }
    }

    public boolean tieneSelloRENAR() {
        return tieneSelloRENAR;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public int compareTo(ArmaLarga otraArma) {
        return Integer.compare(this.nivel, otraArma.nivel);
    }

    @Override
    public String toString() {
        return "ARMA LARGA - " + super.toString() +
                ", Nivel: " + nivel + ", Sello RENAR: " + (tieneSelloRENAR ? "Sí" : "No") +
                ", Uso: " + descripcionUso;
    }

}

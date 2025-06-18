public class ArmaCorta extends Arma {
    private boolean esAutomatica;

    public ArmaCorta(int municiones, double alcanceMetros, String marca, double calibre, String estado, Policia policia, boolean esAutomatica) {
        super(municiones, alcanceMetros, marca, calibre, estado, policia);
        this.esAutomatica = esAutomatica;
    }

    public boolean siEsAutomatica() {
        return esAutomatica;
    }

    public boolean puedeDispararLargoAlcance() {
        return alcanceMetros > 200;
    }

    @Override
    public String toString() {
        return "ARMA CORTA - " + super.toString() +
                ", Automática: " + (esAutomatica ? "Sí" : "No");
    }
}

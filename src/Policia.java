public class Policia {

    private String nombre;
    private String apellido;
    private int legajo;
    private String escuadron;
    private Arma armaAsignada;

    public Policia(String nombre, String apellido, int legajo, String escuadron) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.escuadron = escuadron;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getEscuadron() {
        return escuadron;
    }

    public Arma getArmaAsignada() {
        return armaAsignada;
    }

    public void setArmaAsignada(Arma armaAsignada) {
        this.armaAsignada = armaAsignada;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (Legajo: " + legajo + ")";
    }
}

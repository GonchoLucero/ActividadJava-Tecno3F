import java.util.ArrayList;


public class Escuadron {
    private String nombre;
    private String comisaria;
    private ArrayList<Policia> policias;
    private ArrayList<Arma> armas;

    public Escuadron(String nombre, String comisaria) {
        this.nombre = nombre;
        this.comisaria = comisaria;
        this.policias = new ArrayList<>();
        this.armas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getComisaria() {
        return comisaria;
    }

    public ArrayList<Policia> getPolicias() {
        return policias;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    // AGREGAR POLICIA AL ESCUADRON //
    public void agregarPolicia(Policia policia) {
        policias.add(policia);
    }

    // AGREGAR ARMA //
    public void agregarArma(Arma arma) {
        armas.add(arma);
    }

    // OBTENER CANTIDAD DE INTEGRANTES
    public int getCantidadIntegrantes() {
        return policias.size();
    }

    // OBTENER CANTIDAD DE ARMAS
    public int getCantidadDeArmas(){
        return armas.size();
    }

    public int contarArmasEnCondiciones() {
        int contar = 0;
        for (Arma arma : armas) {
            if (arma.estaEnCondiciones()) {
                contar++;
            }
        }
        return contar;
    }

    public void mostrarInformacion() {
        System.out.println("\n=== INFORMACIÓN DEL ESCUADRÓN ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Comisaría: " + comisaria);
        System.out.println("Cantidad de integrantes: " + getCantidadIntegrantes());
        System.out.println("Cantidad de armas: " + getCantidadDeArmas());
        System.out.println("Armas en condiciones: " + contarArmasEnCondiciones());

        System.out.println("\n--- POLICÍAS Y SUS ARMAS ---");
        for (Policia policia : policias) {
            System.out.println("• " + policia);
            if (policia.getArmaAsignada() != null) {
                System.out.println("  Arma: " + policia.getArmaAsignada());
            } else {
                System.out.println("  Sin arma asignada");
            }
        }
    }

}

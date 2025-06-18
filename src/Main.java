import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static final ArrayList<Escuadron> escuadrones = new ArrayList<>();

    public static void main(String[] args) {

        DatosDeEjemplos();

        int opcionUsuario = 0;

        while (opcionUsuario != 6) {

            System.out.print("""
                    ===== SISTEMA DE GESTIÓN  =====
                    1) Mostrar información de escuadrones
                    2) Verificar armas en condiciones 
                    3) Comparar armas largas  
                    4) Verificar alcance armas cortas 
                    5) Mostrar estadísticas generales 
                    6) Salir
                    
                    Elija una opcion: """);

            opcionUsuario = entrada.nextInt();


            switch (opcionUsuario) {
                case 1 -> mostrarEscuadrones();
                case 2 -> verificarArmasEnCondiciones();
                case 3 -> compararArmasLargas();
                case 4 -> verificarAlcanceArmasCortas();
                case 5 -> mostrarEstadisticas();
                case 6 -> System.out.println("Saliendo... Gracias por usar el simulador!");
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void DatosDeEjemplos() {

        Escuadron escuadron1 = new Escuadron("Aguilas", "1ra Comisaría");
        Escuadron escuadron2 = new Escuadron("Halcones", "2da Comisaría");

        Policia policia1 = new Policia("Tobias", "Baez", 2358, "Aguilas");
        Policia policia2 = new Policia("Thaiel", "Rodriguez", 6321, "Aguilas");
        Policia policia3 = new Policia("Mia", "Dominguez", 8414, "Aguilas");
        Policia policia4 = new Policia("Pilar", "Gimenez", 2626, "Halcones");
        Policia policia5 = new Policia("Gonzalo", "Perez", 3740, "Halcones");

        escuadron1.agregarPolicia(policia1);
        escuadron1.agregarPolicia(policia2);
        escuadron1.agregarPolicia(policia3);
        escuadron2.agregarPolicia(policia4);
        escuadron2.agregarPolicia(policia5);

        ArmaCorta pistola1 = new ArmaCorta(40, 70, "Glock", 9, "EN USO", policia1, false);
        ArmaLarga fusil1 = new ArmaLarga(55, 850, "Ak-47", 12, "EN USO", policia2, true, "Patrullaje urbano", 4);
        ArmaCorta pistola2 = new ArmaCorta(34, 320, "Beretta", 10, "NUEVA", policia3, true);
        ArmaLarga fusil2 = new ArmaLarga(25, 630, "M16", 11, "EN MANTENIMIENTO", policia4, false, "Operaciones especiales", 3);

        policia1.setArmaAsignada(pistola1);
        policia2.setArmaAsignada(fusil1);
        policia3.setArmaAsignada(pistola2);
        policia4.setArmaAsignada(fusil2);

        escuadron1.agregarArma(pistola1);
        escuadron1.agregarArma(fusil1);
        escuadron1.agregarArma(pistola2);
        escuadron2.agregarArma(fusil2);

        escuadrones.add(escuadron1);
        escuadrones.add(escuadron2);
    }

    private static void mostrarEscuadrones() {
        for (Escuadron escuadron : escuadrones) {
            escuadron.mostrarInformacion();
        }
    }

    private static void verificarArmasEnCondiciones() {
        System.out.println("\n=== VERIFICACIÓN DE ARMAS EN CONDICIONES ===");
        for (Escuadron escuadron : escuadrones) {
            System.out.println("\nEscuadrón: " + escuadron.getNombre());
            for (Arma arma : escuadron.getArmas()) {
                System.out.println("• " + arma.getPolicia() + " - " + arma.getMarca());
                System.out.println("  En condiciones: " + (arma.estaEnCondiciones() ? "SÍ" : "NO"));
                System.out.println("  Razón: Estado=" + arma.getEstado() + ", Calibre=" + arma.getCalibre());
            }
        }
    }

    private static void compararArmasLargas() {
        System.out.println("\n=== COMPARACIÓN DE ARMAS LARGAS ===");
        ArrayList<ArmaLarga> armasLargas = new ArrayList<>();

        for (Escuadron escuadron : escuadrones) {
            for (Arma arma : escuadron.getArmas()) {
                if (arma instanceof ArmaLarga) {
                    armasLargas.add((ArmaLarga) arma);
                }
            }
        }

        for (int i = 0; i < armasLargas.size(); i++) {
            for (int j = i + 1; j < armasLargas.size(); j++) {
                ArmaLarga arma1 = armasLargas.get(i);
                ArmaLarga arma2 = armasLargas.get(j);

                System.out.println("\nComparación:");
                System.out.println("Arma 1: " + arma1.getMarca() + " (Nivel " + arma1.getNivel() + ")");
                System.out.println("Arma 2: " + arma2.getMarca() + " (Nivel " + arma2.getNivel() + ")");

                int comparacion = arma1.compareTo(arma2);
                if (comparacion > 0) {
                    System.out.println("Resultado: " + arma1.getMarca() + " es MAYOR que " + arma2.getMarca());
                } else if (comparacion < 0) {
                    System.out.println("Resultado: " + arma1.getMarca() + " es MENOR que " + arma2.getMarca());
                } else {
                    System.out.println("Resultado: Ambas armas tienen el MISMO nivel");
                }
            }
        }
    }

    private static void verificarAlcanceArmasCortas() {
        System.out.println("\n=== VERIFICACIÓN ALCANCE ARMAS CORTAS ===");
        for (Escuadron escuadron : escuadrones) {
            System.out.println("\nEscuadrón: " + escuadron.getNombre());
            for (Arma arma : escuadron.getArmas()) {
                if (arma instanceof ArmaCorta armaCorta) {
                    System.out.println("• " + arma.getMarca() + " (Alcance: " + arma.getAlcanceMetros() + "m)");
                    System.out.println("  ¿Puede disparar a más de 200m? " +
                            (armaCorta.puedeDispararLargoAlcance() ? "SÍ" : "NO"));
                }
            }
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        int totalPolicias = 0;
        int totalArmas = 0;
        int armasEnCondiciones = 0;

        for (Escuadron escuadron : escuadrones) {
            totalPolicias += escuadron.getCantidadIntegrantes();
            totalArmas += escuadron.getCantidadDeArmas();
            armasEnCondiciones += escuadron.contarArmasEnCondiciones();
        }

        System.out.println("Total de escuadrones: " + escuadrones.size());
        System.out.println("Total de policías: " + totalPolicias);
        System.out.println("Total de armas: " + totalArmas);
        System.out.println("Armas en condiciones: " + armasEnCondiciones);
    }
}

import java.util.Scanner;

public class App {
    
    static String estudiante = "";
    static double nota1, nota2, nota3;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        menu(sc);

    }

    public static void menu(Scanner sc) {
        int opcion;
        do {
            System.out.println("==================================");
            System.out.println("Bienvenido a el Sistema de Estudiantes");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Mostrar Estudiante");
            System.out.println("3. Calcular Promedio Estudiante");
            System.out.println("4. Salir");
            System.out.println("==================================");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarEstudiante(sc);
                    break;

                case 2:
                    mostrarInfoEstudiante();
                    break;

                case 3:
                    calcularPromedioNotaEstudiante();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Opcion no valida. Ingrese de nuevo");
                    break;
            }
        } while (opcion != 4);

    }

    public static void registrarEstudiante(Scanner sc) {
        System.out.println("---Registro de Estudiante---");
        do {
            System.out.print("ingrese el nombre del estudiante: ");
            estudiante = sc.nextLine();
        } while (estudiante.isEmpty());
        registrarNotas(sc, estudiante);
    }

    public static void registrarNotas(Scanner sc, String nombre) {
        do {
            System.out.print("ingrese Nota 1 de " + nombre + ": ");
            nota1 = sc.nextDouble();
        } while (nota1 > 5 || nota1 < 0);

        do {
            System.out.print("ingrese Nota 2 de " + nombre + ": ");
            nota2 = sc.nextDouble();
        } while (nota1 > 5 || nota1 < 0);

        do {
            System.out.print("ingrese Nota 3 de " + nombre + ": ");
            nota3 = sc.nextDouble();
        } while (nota1 > 5 || nota1 < 0);
    }

    public static void mostrarInfoEstudiante() {
        if (estudiante.isEmpty()) {
            System.out.println("N/A");
        } else
            System.out.println("\tEstudiante: " + estudiante + "\n\tnota 1: " + nota1 + "\n\tnota 2: " + nota2
                    + "\n\tnota 3: " + nota3);
    }

    public static void calcularPromedioNotaEstudiante(){
        double promedio = (nota1 + nota2 + nota3)/3;
        if (promedio == 0) {
            System.out.println("N/A");
        }
        System.out.printf("El promedio de " + estudiante + " es: " + promedio);
    }

}

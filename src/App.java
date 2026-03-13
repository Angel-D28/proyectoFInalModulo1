import java.util.Scanner;
import java.util.Locale;

public class App {

    // Variables de alcance de clase
    static String estudiante = "N/A";
    static double nota1, nota2, nota3;

    public static void main(String[] args) throws Exception {
        // El main es responsable de crear y cerrar el Scanner
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US); // Para usar punto en el decimal
        //El main dirige el funcionamiento del sistema, llamando los metodos dependiendo lo que se desee hacer
        int opcion;
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

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

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("==================================");
        System.out.println("Bienvenido al Sistema de Estudiantes");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Mostrar Estudiante");
        System.out.println("3. Calcular Promedio Estudiante");
        System.out.println("4. Salir");
        System.out.println("==================================");
    }

    public static void registrarEstudiante(Scanner sc) {
        System.out.println("---Registro de Estudiante---");
        // Variables locales primero
        String nombreLocal;
        double n1, n2, n3;

        do {
            System.out.print("ingrese el nombre del estudiante: ");
            nombreLocal = sc.nextLine();
        } while (!validarNombre(nombreLocal));

        // Validación de cada nota usando el metodo solicitar Nota
        n1 = solicitarNota(sc, "Nota 1", nombreLocal);
        n2 = solicitarNota(sc, "Nota 2", nombreLocal);
        n3 = solicitarNota(sc, "Nota 3", nombreLocal);

        // Almacenar en variables de alcance de clase
        estudiante = nombreLocal;
        nota1 = n1;
        nota2 = n2;
        nota3 = n3;
    }

    public static double solicitarNota(Scanner sc, String etiqueta, String nombre) {
        double valor;
        do {
            System.out.print("ingrese " + etiqueta + " de " + nombre + ": ");
            valor = sc.nextDouble();
            if (!validarNota(valor)) {
                System.out.println("Nota inválida. Debe estar entre 0 y 100.");
            }
        } while (!validarNota(valor));
        return valor;
    }

    public static void mostrarInfoEstudiante() {
        if (estudiante.equals("N/A")) {
            System.out.println("Estudiante actual: N/A");
        } else {
            System.out.println("\tEstudiante: " + estudiante + "\n\tnota 1: " + nota1 +
                    "\n\tnota 2: " + nota2 + "\n\tnota 3: " + nota3);
        }
    }

    public static void calcularPromedioNotaEstudiante() {
        if (estudiante.equals("N/A")) {
            System.out.println("Error: No hay ningún estudiante registrado.");
        } else {
            double promedio = (nota1 + nota2 + nota3) / 3.0;
            // Se usa printf para los dos decimales como pide el requisito
            System.out.printf("El promedio de %s es: %.2f%n", estudiante, promedio);
        }
    }

    // Validar nota
    public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    // Validar nombre
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}
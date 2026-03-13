import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        menu();

    }

    public static void menu() {
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
            
            switch (opcion) {
                case 1:
                    //registrarEstudiante();
                    break;
                
                    case 2 :
                    //mostrarEstudiante();
                    break;

                    case 3:
                    //calcularPromedioNotasEStudiante();
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
}

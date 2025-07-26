import java.util.Scanner;

public class App {
    static String estudianteActualNombre ; // Definicion de variables estaticas
    static double nota1 = 0.0;
    static double nota2 = 0.0;
    static double nota3 = 0.0;

    public static void main(String[] args) {

        var input = new Scanner(System.in);

        do {
            mostrarMenu(); // Muestra el menú en cada iteración

            int opcion = input.nextInt(); // Lee la opción ingresada por el usuario
            input.nextLine(); // Limpia el bufer después de nextInt()

            switch (opcion) {
                case 1:
                    Registrarestudiante(input);
                    break;
                case 2:
                    Mostrardatosestudianteactual();
                    break;
                case 3:

                    if (validarNombre(estudianteActualNombre)) { // Asegúrate de manejar el caso si no hay estudiante
                                                                 // registrado
                        System.out.println("No hay un estudiante registrado para calcular el promedio.");
                    } else {
                        double promedio = promedionotasestudianteactual();
                        System.out.printf("El promedio del estudiante %s es: %.2f%n", estudianteActualNombre, promedio);
                    }

                    break;
                case 0:
                    System.out.print("Hasta luego.! gracias por utilizar el programa");
                    System.exit(0);
                    break;
                default:
                    System.out.print("Opcion no valida.por favor intente de nuevo ");
                    break;
            }

        } while (true);

    }

    public static void mostrarMenu() {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---");
        System.out.println("1.Registrar datos de un estudiante");
        System.out.println("2.Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas del estudiante actual");
        System.out.println("0.Salir ");
        System.out.print("Ingrese su opcion: ");

    }

    public static void Registrarestudiante(Scanner input) {

        do {
            System.out.print("Digite el nombre del estudiante: ");
            estudianteActualNombre = input.nextLine();
            if (validarNombre(estudianteActualNombre)) {
                System.out.println("Nombre incorrecto");
            }
        } while (validarNombre(estudianteActualNombre));
        do {
            System.out.println("Ingrese la nota 1: ");
            nota1 = input.nextDouble();
            if (!validarNota(nota1)) {
                System.out.println("Nota fuera de rango");

            }
        } while (!validarNota(nota1));
        do {

            System.out.println("Ingrese la nota 2: ");
            nota2 = input.nextDouble();
            if (!validarNota(nota2)) {
                System.out.println("Nota fuera de rango");

            }
        } while (!validarNota(nota2));
        do {

            System.out.println("Ingrese la nota 3: ");
            nota3 = input.nextDouble();
            if (!validarNota(nota3)) {
                System.out.println("Nota fuera de rango");

            }
        } while (!validarNota(nota3));

        System.out.println("Datos del estudante registrados correctamente");

    }

    public static void Mostrardatosestudianteactual() {
        if (!validarNombre(estudianteActualNombre)) { // Verifica si hay un estudiante registrado
            System.out.println("Nombre: " + estudianteActualNombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        } else {
            System.out.println("Aún no se ha registrado ningún estudiante.");
        }
    }

    public static double promedionotasestudianteactual() { // Cambiar 'void' por 'double' y quitar 'Scanner input'

        return (nota1 + nota2 + nota3) / 3.0; // Calcula y retorna el promedio
    }

    public static boolean validarNota(double nota) {
        if (nota >= 0 && nota <= 5) {
            return true;

        } else {
            return false;
        }

    }

    public static boolean validarNombre(String nombre) {
        return (nombre == null) || nombre.equals("");

    }

}

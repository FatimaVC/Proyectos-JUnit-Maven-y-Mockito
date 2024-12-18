package src;

import java.util.Scanner;

public class Calificacion {
    // Se crea un objeto Scanner estático llamado lecturaDato para leer datos de la entrada estándar (teclado).
    public static Scanner lecturaDato = new Scanner(System.in);

    public static void main(String[] args) {
        // Llama al método obtenerPuntuacion para obtener la puntuación del usuario.
        Integer puntuacionIngresada = obtenerPuntuacion();
        // Luego, llama al método mensajePuntuacion para generar el mensaje correspondiente a la puntuación y lo imprime en la consola.
        System.out.println(mensajePuntuacion(puntuacionIngresada));
    }

    public static Integer obtenerPuntuacion() {
        // Imprime un mensaje solicitando al usuario que ingrese una puntuación.
        System.out.println("Ingrese una puntuación para calificar");
        // Lee la puntuación ingresada usando Scanner y la devuelve.
        return lecturaDato.nextInt();
    }

    public static String mensajePuntuacion(Integer puntuacionIngresada) {
        // Construye y devuelve un mensaje que incluye la puntuación ingresada y su correspondiente calificación (letra).
        return "La clasificación correspondiente a la puntuación " + puntuacionIngresada + " corresponde a la letra " + obtenerNota(puntuacionIngresada);
    }

    public static String obtenerNota(Integer puntuacionIngresada) {
        // Utiliza una estructura switch para determinar la calificación (letra) basada en la puntuación ingresada.
        return switch (puntuacionIngresada) {
            case 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 -> "A";
            case 80, 81, 82, 83, 84, 85, 86, 87, 88, 89 -> "B";
            case 70, 71, 72, 73, 74, 75, 76, 77, 78, 79 -> "C";
            case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 -> "D";
            default -> {
                // Devuelve la letra correspondiente a la puntuación, o un mensaje de error si la puntuación está fuera del rango válido (0-100).
                if (puntuacionIngresada < 0 || puntuacionIngresada > 100) {
                    yield ": Error - El número ingresado está fuera del rango válido.";
                } else {
                    yield "F";
                }
            }
        };
    }

}

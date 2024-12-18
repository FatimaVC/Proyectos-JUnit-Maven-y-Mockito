package src;
import java.util.Scanner;

public class Ejercicio06 {

    public static Scanner lecturaDato = new Scanner(System.in);

    public static void main(String[] args) {
        Integer numeroMes = obtenerNumero();
        System.out.println(mensajeMes(numeroMes));
    }

    public static Integer obtenerNumero() {
        System.out.println("Ingrese un número de mes");
        return lecturaDato.nextInt();
    }

    public static String mensajeMes(Integer numeroMes) {

        return "El número " + numeroMes + " corresponde al mes de " +

                obtenerMes(numeroMes);
    }

    public static String obtenerMes(Integer numeroMes) {
        return switch (numeroMes) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";

            default -> "Error";
        };
    }
}
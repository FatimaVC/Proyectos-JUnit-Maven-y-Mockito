package src;
/* ✏️  Actividad: Generación de números aleatorios
Tu programa debe generar y mostrar en pantalla un número aleatorio en el rango del 1 al 355 utilizando el método random() de la clase Math. 

Crea un método "numeroAleatorio()" que no requiera parámetros y devuelva un "int" dentro del rango especificado.

Crea una clase para testear esa actividad, incluyendo cada uno de los métodos.  */

public class GeneracionDeNumerosAleatorios {
    public static void main(String[] args) {
        
    }

    // método para generar números aleatorios
    public static Integer numeroAleaotrio(){
        return (int) (Math.random() * 355) + 1;
    }

}


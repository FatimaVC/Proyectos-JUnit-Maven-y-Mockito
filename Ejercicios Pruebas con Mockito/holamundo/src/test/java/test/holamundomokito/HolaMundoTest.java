package test.holamundomokito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.holamundomokito.HolaMundo;

public class HolaMundoTest {
    // Configuracion output
    // Configuración de la captura de salida del sistema
    private final PrintStream standarOut = System.out; // Guarda la salida estándar original.
    // Inicializa un ByteArrayOutputStream para capturar la salida.
    private final ByteArrayOutputStream ouutputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach // Redirige la salida estándar al ByteArrayOutputStream antes de cada prueba.
    public void setUp() { 
        System.setOut(new PrintStream(ouutputStreamCaptor));
    }

    @AfterEach // Restaura la salida estándar original después de cada prueba.
    public void tearDown() {
        System.setOut(standarOut);
    }

    @Test
    void testMain() {// Ejecuta el método main de Ejercicio03.
        HolaMundo.main(new String[1]);// Captura la salida del sistema.
        String salida = ouutputStreamCaptor.toString();
        // Compara el primer argumento (esperado) con el segundo argumento (salida) y lanza una excepción si no son iguales
        assertEquals("Hola Mundo\r\n", salida); 
    }
}

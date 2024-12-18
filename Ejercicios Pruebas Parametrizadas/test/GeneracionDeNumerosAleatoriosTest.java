package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.GeneracionDeNumerosAleatorios;

public class GeneracionDeNumerosAleatoriosTest {
    @Test // Anotación que indica que este método es del tipo "Test"
    void testNumeroAleaotrio() {
        // Invocamos al método, se almacena en una variable el resultado de ejecutar el método
    
        Integer resultado = GeneracionDeNumerosAleatorios.numeroAleaotrio();

        // 💡En este caso, en lugar de verificar un número específico, debes asegurarte de que el número generado esté dentro del rango especificado en el método.
        
        Assertions.assertTrue(resultado >= 1 && resultado <= 355);

    }
}

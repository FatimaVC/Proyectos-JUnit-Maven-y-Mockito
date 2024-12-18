package test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import src.Ejercicio06;

public class Ejercicio06Test {
    private InputStream standarIn = System.in;

    @AfterEach
    public void tearDown() {
        System.setIn(standarIn);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/csv/mensaje-mes.csv", numLinesToSkip = 1)
    // Pruebo el metodo, con los casos q //
    // desee, cargando un archivo csv
    void testMensajeMes(Integer numeroMes, String valorEsperado) {
        String resultado = Ejercicio06.mensajeMes(numeroMes);
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({ "1, Enero", "2, Febrero" }) // Pruebo el metodo, con 2 casos,cargando de manera manual.
    @CsvFileSource(resources = "/test/csv/meses-numeros.csv", numLinesToSkip = 1) 
    // Pruebo el metodo, con los casos que desee, cargando un archivo csv
    void testObtenerMes(Integer numeroMes, String valorEsperado) {
        String resultado = Ejercicio06.obtenerMes(numeroMes);
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({ "'1\n',1", "'2\n',2" })
    void testObtenerNumero(String input, Integer valorEsperado) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Ejercicio06.lecturaDato = new Scanner(System.in);
        Integer resultado = Ejercicio06.obtenerNumero();
        Assertions.assertEquals(valorEsperado, resultado);
    }
}

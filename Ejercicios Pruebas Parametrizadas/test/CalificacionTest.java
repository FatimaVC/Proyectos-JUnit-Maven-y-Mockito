package test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import src.Calificacion;

public class CalificacionTest {

    private InputStream standarIn = System.in;

    @AfterEach
    public void tearDown() {
        System.setIn(standarIn);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/csv/mensaje-puntuacion.csv", numLinesToSkip = 1)
    void testMensajePuntuacionn(Integer puntuacionIngresada, String valorEsperado) {
        String resultado = Calificacion.mensajePuntuacion(puntuacionIngresada);
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/csv/puntuacion-calificacion.csv", numLinesToSkip = 1)
    void testObtenerNota(Integer puntuacionIngresada, String valorEsperado) {
        String resultado = Calificacion.obtenerNota(puntuacionIngresada);
        Assertions.assertEquals(valorEsperado, resultado);

    }

    void testObtenerPuntuacion(String input, Integer valorEsperado) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Calificacion.lecturaDato = new Scanner(System.in);
        Integer resultado = Calificacion.obtenerPuntuacion();
        Assertions.assertEquals(valorEsperado, resultado);
    }
}

package com.calificacion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


class ApplicationTest {

    private InputStream standarIn = System.in;

    @AfterEach
    public void tearDown() {
        System.setIn(standarIn);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/mensaje-puntuacion.csv", numLinesToSkip = 1)
    void testMensajePuntuacionn(Integer puntuacionIngresada, String valorEsperado) {
        String resultado = Application.mensajePuntuacion(puntuacionIngresada);
        Assertions.assertEquals(valorEsperado, resultado);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/puntuacion-calificacion.csv", numLinesToSkip = 1)
    void testObtenerNota(Integer puntuacionIngresada, String valorEsperado) {
        String resultado = Application.obtenerNota(puntuacionIngresada);
        Assertions.assertEquals(valorEsperado, resultado);

    }

    void testObtenerPuntuacion(String input, Integer valorEsperado) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Application.lecturaDato = new Scanner(System.in);
        Integer resultado = Application.obtenerPuntuacion();
        Assertions.assertEquals(valorEsperado, resultado);
    }

}

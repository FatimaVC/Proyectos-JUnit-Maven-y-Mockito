package com.nombreyedad;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class NombreyEdadTestMocks {
    private final PrintStream standarOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new

    ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standarOut);
    }

    @Test
    void testMainWithMocks() {
        // Creamos un mock de PrintStream
        PrintStream mockedPrintStream = mock(PrintStream.class);
        // Redirigimos System.out a nuestro mock
        System.setOut(mockedPrintStream);
        // Llamamos al método main de la clase NombreyEdad
        NombreYEdad.main(new String[0]);
        // Verificamos que el método println haya sido invocado correctamente con el mensaje esperado
        verify(mockedPrintStream).println("Me llamo Pedro y tengo 70 años");
    }
}

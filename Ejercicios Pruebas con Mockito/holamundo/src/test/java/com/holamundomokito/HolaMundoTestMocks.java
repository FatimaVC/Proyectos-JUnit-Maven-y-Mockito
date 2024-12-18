package com.holamundomokito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class HolaMundoTestMocks {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standarOut = System.out;

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
        // Redirigir la salida estándar
        System.setOut(new PrintStream(outputStreamCaptor));
        // Llamar al método main
        HolaMundo.main(new String[1]);
        // Verificar la salida
        assertEquals("Hola Mundo\r\n", outputStreamCaptor.toString());
    }

    @Test
    void testMainWithMockito() {
        // Creamos un mock de System.out
        PrintStream mockedPrintStream = mock(PrintStream.class);
        // Redirigimos System.out a nuestro mock
        System.setOut(mockedPrintStream);
        // Ejecutamos el método main
        HolaMundo.main(new String[1]);
        // Verificamos que se haya invocado println con "Hola Mundo"
        verify(mockedPrintStream).println("Hola Mundo");
    }
}

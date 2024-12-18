package com.primermokitosize;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    // En la clase test creada por defecto, crea un método, llamado
    // createMockObject, e indica con la anotación correspondiente que es un Test.

    @SuppressWarnings("unchecked") // Para que no me de sugerencias. al declarar mockedList

    public void createMockObject() {
        // Crear un objeto simulado de la clase List
        List<String> mockedList = Mockito.mock(List.class);
        // Llamar al método size() del objeto simulado
        int size = mockedList.size();
        // Verificar que el tamaño de la lista es 0
        assertEquals(0, size);
    }

    @Test
    @SuppressWarnings("unchecked") // Para q no me de sugerencias. al declarar mockedList
    public void configureMockObject2() {
        // Crear un objeto simulado de la clase List
        List<String> mockedList = Mockito.mock(List.class);
        // Configurar el objeto simulado para que el método size() devuelva un valor
        // distinto
        int expectedSize = 5;
        when(mockedList.size()).thenReturn(expectedSize);
        // Llamar al método size() del objeto simulado
        int size = mockedList.size();
        // Verificar que el tamaño de la lista es el valor configurado
        assertEquals(expectedSize, size);
    }
    
    @Test
    @SuppressWarnings("unchecked") // Para q no me de sugerencias. al declarar mockedList

    public void verificarMetodo() {
        // Crear un objeto simulado de la clase List
        List<String> mockedList = Mockito.mock(List.class);
        // Llamar al método add() del objeto simulado con un elemento
        mockedList.add("elementoAgregado");
        // Verificar que el método add() ha sido llamado "PASA PRUEBA"
        verify(mockedList).add("elementoAgregado");
        // Verificar que el método add() ha sido llamado "NO PASA PRUEBA"
        // verify(mockedList).add("elementoNOexiste");
    }

    @Test
    public void crearObjetoEspia() {
        // Crear un objeto espía de la clase ArrayList
        List<String> spyList = Mockito.spy(new ArrayList<>());
        // Añadir un elemento al objeto espía
        spyList.add("elementoAgregado");
        // Verificar que el método add() ha sido llamado
        Mockito.verify(spyList).add("elementoAgregado");
        // Verificar que el tamaño de la lista es 1
        assertEquals(1, spyList.size());
    }
}

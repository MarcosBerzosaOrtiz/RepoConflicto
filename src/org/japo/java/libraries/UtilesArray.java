/*
 * Copyright 2023 alumnoT.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author alumnoT
 */
public class UtilesArray {

    public static final String[] letra = {"Abel", "Puri", "Oscar", "Pako", "Francisco", "Nikola", "Pancracia"};

    public static final String obtenerNombreAleatorio() {
        Random rnd = new Random();
        return letra[rnd.nextInt(letra.length)];
    }

    public static final void mostrarArrayI(int[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf("%s %d ..: %d%n", nombre, i + 1, lista[i]);
        }
    }

    public static final void mostrarArrayD(double[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf("%s %d ..: %.2f%n", nombre, i + 1, lista[i]);
        }
    }

    public static final void mostrarArrayS(String[] lista, String nombre) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf("%s %d ..: %s%n", nombre, i + 1, lista[i]);
        }
    }

    public static final void StringEnArray(String[] a, String b) {
        boolean encontrado = false;
        try {

            for (int i = 0; i < a.length; i++) {
                System.out.printf("Nombre %d ...: %s%n", i + 1, a[i]);
            }
            System.out.println("---");

            for (int i = 0; i < letra.length; i++) {
                if (a[i].equals(b)) {
                    System.out.printf("Nombre .....: %s - SI encontrado – Posición %d%n", letra[i], i + 1);
                    encontrado = true;
                }
                if (encontrado == false && i == letra.length - 1) {
                    System.out.printf("Nombre .....: %s - NO encontrado%n", b);
                }
            }
        } catch (Exception e) {
            System.out.println("Por favor introduzca un array correcto");
        }

    }

    public static final boolean StringEnArray2(String[] a, String b) {
        boolean encontrado = false;
        try {
            for (int i = 0; i < letra.length; i++) {
                if (a[i].equals(b)) {
                    encontrado = true;
                    i = letra.length;
                }
            }
        } catch (Exception e) {
        }

        return encontrado;
    }

    public static final int intEnArray2(int[] a, int b) {
        int numero = -1;
        try {
            for (int i = 0; i < letra.length; i++) {
                if (a[i] == b) {
                    numero = i;
                }
            }
        } catch (Exception e) {
        }

        return numero;
    }

    public static final int doubleEnArray2(double[] a, double b) {
        int numero = -1;
        try {
            for (int i = 0; i < letra.length; i++) {
                if (a[i] == b) {
                    numero = i;
                }
            }
        } catch (Exception e) {
        }

        return numero;
    }

    public static double[] generarArrayAleatorio(int longitud) {
        double[] lista = new double[longitud];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = UtilesRandom.DoubleAleatorio(0, longitud - 1);
        }
        return lista;
    }

    public static double acumular(double[] lista) {
        double suma = 0;
        for (int i = 0; i < lista.length; i++) {
            suma += lista[i];
        }
        return suma;
    }

    public static final int maximo(double[] lista) {
        int posicionMaximo = 0;

        for (int i = 0; i < lista.length; i++) {
            if (posicionMaximo < lista[i]) {
                posicionMaximo = i;
            }
        }
        return posicionMaximo;
    }

    public static final int[] ordenarArray(int[] lista) {
        int max = 0;
        int[] listaOrdenada = new int[lista.length];
        for (int o = 0; o < lista.length; o++) {
            int i = 0;
            for (i = 0; i < lista.length; i++) {
                if (lista[i] > max) {
                    max = i;
                }
            }
            listaOrdenada[o] = max;
            lista[max] = 0;
            max = 0;
        }
        return listaOrdenada;
    }

}

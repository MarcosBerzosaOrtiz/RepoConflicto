/*
 * Copyright 2022 Marcos Berzosa Ortiz - marcos.berzosa.ortiz@gmail.com.
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

/**
 *
 * @author Marcos Berzosa Ortiz - marcos.berzosa.ortiz@gmail.com
 */
public final class UtilesOperacion {

    private UtilesOperacion() {
    }

    private static double sumar(double n1, double n2) {
        return n1 + n2;

    }

    private static double restar(double n1, double n2) {
        return n1 - n2;

    }

    private static double multiplicar(double n1, double n2) {
        return n1 * n2;

    }

    private static double dividir(double n1, double n2) {
        return n1 / n2;

    }

    private static double resto(double n1, double n2) {
        return n1 % n2;

    }

    private static double media(double n1, double n2) {
        return (n1 + n2) / 2;

    }

    private static double mayor(double n1, double n2) {
        double r;
        if (n1 >= n2) {
            r = n1;
        } else {
            r = n2;
        }
        return r;

    }

    private static double menor(double n1, double n2) {
        double r;
        if (n1 <= n2) {
            r = n1;
        } else {
            r = n2;
        }
        return r;

    }

    public static final int calcularFactorial(int n) {
        int max = 19;
        int fact = 1;

        if (n > 0) {
            if (n <= max) {
                for (int i = 1; i <= n; i++) {
                    fact = fact * i;
                }
            } else {
                System.out.println("ERROR: Fallo de cálculo");
            }
        } else if (n < 0) {
            System.out.println("ERROR: Factorial no definido");

        } else {
            fact = 1;
        }
        return fact;
    }

    public static final int OP_SUM = 0;
    public static final int OP_RES = 1;
    public static final int OP_MUL = 2;
    public static final int OP_DIV = 3;
    public static final int OP_MOD = 4;
    public static final int OP_MED = 5;
    public static final int OP_MAY = 6;
    public static final int OP_MEN = 7;

    public static final double operar(double n1, double n2, int op) {
        double n;
        switch (op) {
            case OP_SUM:
                n = sumar(n1, n2);
                break;
            case OP_RES:
                n = restar(n1, n2);
                break;
            case OP_MUL:
                n = multiplicar(n1, n2);
                break;
            case OP_DIV:
                n = dividir(n1, n2);
                break;
            case OP_MOD:
                n = resto(n1, n2);
                break;
            case OP_MED:
                n = media(n1, n2);
                break;
            case OP_MAY:
                n = mayor(n1, n2);
                break;
            case OP_MEN:
                n = menor(n1, n2);
                break;

            default:
                n = 0;
        }
        return n;
    }

}

/*
 * Copyright 2023 Marcos Berzosa Ortiz - marcos.berzosa.ortiz@gmail.com.
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

import java.util.Random;

/**
 *
 * @author Marcos Berzosa Ortiz - marcos.berzosa.ortiz@gmail.com
 */
public class UtilesGenerador {

    public static final Random RND = new Random();

    public static final String generarAcronimoDirecto(String s) {
        String resto = s;
        String a = s.charAt(0) + "";
        int posicion;
        do {
            posicion = resto.indexOf(" ");
            if (posicion >= 0) {
                resto = resto.substring(posicion + 1);
                a = a + resto.charAt(0);
            }
        } while (posicion >= 0);
        return a;
    }

    public static final String generarAcronimoInverso(String s) {
        String resto = s;
        String a = resto.charAt(resto.length() - 1) + "";
        int posicion;
        do {
            posicion = resto.lastIndexOf(" ");
            if (posicion >= 0) {
                resto = resto.substring(0, posicion);
                a = resto.charAt(resto.length() - 1) + a;
            }
        } while (posicion >= 0);
        return a.toUpperCase();
    }
}

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

/**
 *
 * @author Marcos Berzosa Ortiz - marcos.berzosa.ortiz@gmail.com
 */
public final class UtilesPassword {

    // Categorias
    public static final int CAT_MIN = 0;
    public static final int CAT_MAY = 1;
    public static final int CAT_NUM = 2;
    public static final int CAT_CAR = 3;

    // Caracteres
    public static final String MIN = "abcdefghijklmnopqrstuvwxyz";
    public static final String MAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUM = "0123456789";
    public static final String CAR = "@#~$%&()[]{}=?¿¡!+-*/";

    // Longitudes Predeterminadas
    public static final int LONG_MIN = 8;
    public static final int LONG_MAX = 24;

    public static final String generarPassword() {
        return generarPassword(LONG_MIN, LONG_MAX);
    }

    private UtilesPassword() {
    }

    public static final char obtenerMin() {
        return MIN.charAt(UtilesAleatorio.obtenerEntero(0, MIN.length() - 1));
    }

    public static final char obtenerMay() {
        return MAY.charAt(UtilesAleatorio.obtenerEntero(0, MAY.length() - 1));
    }

    public static final char obtenerNum() {
        return NUM.charAt(UtilesAleatorio.obtenerEntero(0, NUM.length() - 1));
    }

    public static final char obtenerCar() {
        return CAR.charAt(UtilesAleatorio.obtenerEntero(0, CAR.length() - 1));
    }

    public static final String intercambiar(String s, int ini, int fin) {
        // Obtener Caracteres
        char carIni = s.charAt(ini);
        char carFin = s.charAt(fin);

        // Reemplazo Caracter Inicial
        String strIni = s.substring(0, fin);
        String strFin = s.substring(fin + 1);
        String aux = strIni + carIni + strFin;

        // Reemplazo Caracter Final
        strIni = aux.substring(0, ini);
        strFin = aux.substring(ini + 1);

        // Retorno
        return strIni + carFin + strFin;
    }

    public static final String aleatorizar(String s) {
        String aux = s;
        for (int i = 0; i < aux.length(); i++) {
            int f = UtilesAleatorio.obtenerEntero(0, aux.length() - 1);
            aux = intercambiar(aux, i, f);
        }
        return aux;
    }

    public static final String generarPassword(int min, int max) {
        // Acumulador
        String pass = "";

        if (min >= 4 && max >= min) {

            // Predeterminados
            pass += obtenerMin();
            pass += obtenerMay();
            pass += obtenerNum();
            pass += obtenerCar();

            // Longitud Aleatoria
            int lonRnd = UtilesAleatorio.obtenerEntero(min, max);

            // Resto de caracteres
            for (int i = 4; i < lonRnd - 1; i++) {
                int cat = UtilesAleatorio.obtenerEntero(0, 3);

                switch (cat) {
                    case CAT_MIN:
                        pass += obtenerMin();
                        break;
                    case CAT_MAY:
                        pass += obtenerMay();
                        break;
                    case CAT_NUM:
                        pass += obtenerNum();
                        break;
                    case CAT_CAR:
                        pass += obtenerCar();
                }
            }

            // Aleatorizar
            pass = aleatorizar(pass);
        }
        // Retorno
        return pass;
    }
}

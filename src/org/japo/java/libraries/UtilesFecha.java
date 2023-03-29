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
public final class UtilesFecha {

    private UtilesFecha() {
    }

    //Compruba si es bisiesto
    public static final boolean validarBisiesto(int any) {
        return any % 400 == 0 || any % 100 != 0 && any % 4 == 0;
    }

    //Compruba si el dia es correcto
    public static final boolean validarDia(int dia, int mes, int any) {
        //Semáforo
        boolean diaOK;

        if (mes < 1 && mes > 12) {
            diaOK = false;
        } else {
            diaOK = dia >= 1 && dia <= calcularDiasMes(mes, any);
        }

        return diaOK;
    }

    //Calcula los dias que tiene el mes
    public static final int calcularDiasMes(int mes, int any) {
        // Dias Calculados
        int dias;

        // Discriminación
        if (mes == 1 || mes == 3 || mes == 5
                || mes == 7 || mes == 8 || mes == 10
                || mes == 12) {
            dias = 31;
        } else if (mes == 4 || mes == 6
                || mes == 9 || mes == 11) {
            dias = 30;
        } else if (mes == 2 && validarBisiesto(any)) {
            dias = 29;
        } else if (mes == 2) {
            dias = 28;
        } else {
            dias = 0;
        }

        // Retorno
        return dias;
    }

    //Calcula la distancia entre dos dias del mismo mes
    public static final int calcularDiasFechasMes(int diaIni, int diaFin, int mes, int any) {
        int dias;
        if (!validarDia(diaIni, mes, any)) {
            //Situación de error
            dias = 0;
        } else if (!validarDia(diaFin, mes, any)) {
            //Situación de error
            dias = 0;
        } else if (diaFin <= diaIni) {
            //Situación de error
            dias = 0;
        } else {
            //Situación nominal
            dias = diaFin - diaIni;
        }
        return dias;
    }

    //Calcula los dias que quedan desde una fecha hasta el final del mes
    public static final int calcularDiasRestantesMes(int dia, int mes, int any) {
        //Acumulador
        int dias;

        //Discrimación
        if (!validarDia(dia, mes, any)) {
            dias = 0;
        } else if (mes < 1 || mes > 12) {
            dias = 0;
        } else {
            dias = calcularDiasMes(mes, any) - dia;
        }

        return dias;
    }

    //Calcula los dias entre dos fechas de meses adyacentes 
    public static final int calcularDiasEntreFechasMesesAdyacentes(int diaIni, int diaFin, int mes, int any) {
        int dias;

        //Discriminación
        if (!validarDia(diaIni, mes, any)) {
            dias = 0;
        } else if (!validarDia(diaFin, mes, any)) {
            dias = 0;
        } else if (mes < 1 || mes > 12) {
            dias = 0;
        } else {
            dias = calcularDiasRestantesMes(diaIni, mes, any) + diaFin;
        }

        return dias;
    }

    //Calcula los dias que hay entre dos meses en el mismo año
    public static final int calcularDiasEntreMesesAny(int mesIni, int mesFin, int any) {
        int dias = 0;

        if (mesIni < 1 || mesIni > 12) {
            dias = 0;
        } else if (mesFin < 1 || mesFin > 12) {
            dias = 0;

        } else {
            for (int mes = mesIni; mes <= mesFin; mes++) {
                dias += calcularDiasMes(mes, any);
            }
        }
        return dias;
    }

    //Calcula los dias entre fechas del mismo año
    public static final int calcularDiasEntreFechasAny(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
        int dias = calcularDiasRestantesMes(diaIni, mesIni, any);

        if (mesFin > mesIni + 1) {
            dias += calcularDiasEntreMesesAny(mesIni + 1, mesFin - 1, any);

        }
        if (mesFin != mesIni) {
            dias += diaFin;
        }

        return dias;
    }

    //Calcula los dias que quedan para que se acabe el año
    public static final int calcularDiasRestantesAny(int dia, int mes, int any) {
        return calcularDiasEntreFechasAny(dia, 31, mes, 12, any);
    }

    //Calcula los dias que llevamos de año
    public static final int calcularDiasLlevadosAny(int dia, int mes, int any) {
        return calcularDiasEntreFechasAny(1, dia, 1, mes, any);
    }

    //Calcula los dias que hay entre dos fechas de años adyacentes
    public static final int calcularDiasFechasAnysAdyacentes(int diaIni, int diaFin, int mesIni, int mesFin, int any) {
        return calcularDiasRestantesAny(diaIni, mesIni, any) + calcularDiasLlevadosAny(diaFin, mesFin, any + 1) + 1;
    }

    //Calcula los dias entre dos años que no son adyacentes
    public static final int calcularDiasAnysNoAdyacentes(int anyIni, int anyFin) {
        int dias = 0;

        for (int i = anyIni; i < anyFin; i++) {
            if (validarBisiesto(i) == true) {
                dias = dias + 366;
            } else {
                dias = dias + 365;
            }
        }
        return dias;

    }

    //Calcula los dias entre dos fechas
    public static final int calcularDiasEntreFechas(
            int diaIni, int mesIni, int anyIni,
            int diaFin, int mesFin, int anyFin) {

        int dias;
        int dias1;
        int dias2;
        int dias3;

        dias1 = calcularDiasRestantesAny(diaIni, mesIni, anyIni);
        dias2 = calcularDiasAnysNoAdyacentes(anyIni + 1, anyFin);
        dias3 = calcularDiasLlevadosAny(diaFin, mesFin, anyFin);
        dias = dias1 + dias2 + dias3 + 1;

        return dias;
    }
}

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

import java.util.Random;

/**
 *
 * @author alumnoT
 */
public class UtilesRandom {

    private static final Random RND = new Random();

    public static final int intAleatorio(int min, int max) {
        return RND.nextInt(max - min + 1) + min;
    }

    public static final double DoubleAleatorio(double min, double max) {
        return RND.nextDouble(max - min + 1) + min;
    }

}

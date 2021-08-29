/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package joptsimple.internal;

public final class Strings {
    public static final String LINE_SEPARATOR = System.getProperty((String)"line.separator");

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
        {
        }
    }

    public static String repeat(char c2, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }
}


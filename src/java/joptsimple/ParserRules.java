/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package joptsimple;

public final class ParserRules {
    public static final String HYPHEN = String.valueOf((char)'-');

    public static boolean isLongOptionToken(String string) {
        return string.startsWith("--") && !"--".equals((Object)string);
    }
}


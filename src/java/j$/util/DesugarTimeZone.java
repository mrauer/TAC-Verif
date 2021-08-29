/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.TimeZone
 */
package j$.util;

import java.util.TimeZone;

public class DesugarTimeZone {
    private DesugarTimeZone() {
    }

    public static TimeZone getTimeZone(String string) {
        return TimeZone.getTimeZone((String)string);
    }
}


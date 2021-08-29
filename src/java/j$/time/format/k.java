/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package j$.time.format;

public final class k
extends Enum<k> {
    public static final /* enum */ k LENIENT;
    public static final /* enum */ k SMART;
    public static final /* enum */ k STRICT;
    private static final /* synthetic */ k[] a;

    static {
        k k2;
        k k3;
        k k4;
        STRICT = k2 = new k();
        SMART = k3 = new k();
        LENIENT = k4 = new k();
        a = new k[]{k2, k3, k4};
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])a.clone();
    }
}


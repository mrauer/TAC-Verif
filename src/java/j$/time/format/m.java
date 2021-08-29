/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package j$.time.format;

public final class m
extends Enum<m> {
    public static final /* enum */ m FULL;
    public static final /* enum */ m FULL_STANDALONE;
    public static final /* enum */ m NARROW;
    public static final /* enum */ m NARROW_STANDALONE;
    public static final /* enum */ m SHORT;
    public static final /* enum */ m SHORT_STANDALONE;
    private static final /* synthetic */ m[] a;
    private final int b;

    static {
        m m2;
        m m3;
        m m4;
        m m5;
        m m6;
        m m7;
        FULL = m3 = new m(2, 0);
        FULL_STANDALONE = m4 = new m(32770, 0);
        SHORT = m7 = new m(1, 1);
        SHORT_STANDALONE = m2 = new m(32769, 1);
        NARROW = m6 = new m(4, 1);
        NARROW_STANDALONE = m5 = new m(32772, 1);
        a = new m[]{m3, m4, m7, m2, m6, m5};
    }

    private m(int n3, int n4) {
        this.b = n4;
    }

    public static m valueOf(String string) {
        return (m)Enum.valueOf(m.class, (String)string);
    }

    public static m[] values() {
        return (m[])a.clone();
    }

    int e() {
        return this.b;
    }
}


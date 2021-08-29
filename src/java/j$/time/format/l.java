/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package j$.time.format;

public final class l
extends Enum<l> {
    public static final /* enum */ l ALWAYS;
    public static final /* enum */ l EXCEEDS_PAD;
    public static final /* enum */ l NEVER;
    public static final /* enum */ l NORMAL;
    public static final /* enum */ l NOT_NEGATIVE;
    private static final /* synthetic */ l[] a;

    static {
        l l2;
        l l3;
        l l4;
        l l5;
        l l6;
        NORMAL = l3 = new l();
        ALWAYS = l4 = new l();
        NEVER = l6 = new l();
        NOT_NEGATIVE = l2 = new l();
        EXCEEDS_PAD = l5 = new l();
        a = new l[]{l3, l4, l6, l2, l5};
    }

    public static l valueOf(String string) {
        return (l)Enum.valueOf(l.class, (String)string);
    }

    public static l[] values() {
        return (l[])a.clone();
    }

    boolean e(boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        block8 : {
            block7 : {
                int n2 = this.ordinal();
                if (n2 != 0) {
                    if (n2 != 1 && n2 != 4) {
                        boolean bl5 = false;
                        if (!bl2) {
                            bl5 = false;
                            if (!bl3) {
                                bl5 = true;
                            }
                        }
                        return bl5;
                    }
                    return true;
                }
                if (!bl) break block7;
                bl4 = false;
                if (bl2) break block8;
            }
            bl4 = true;
        }
        return bl4;
    }
}


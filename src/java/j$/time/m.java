/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package j$.time;

import j$.time.ZoneId;
import j$.time.g;
import j$.time.zone.c;
import j$.time.zone.d;
import j$.time.zone.e;
import java.io.Serializable;

final class m
extends ZoneId
implements Serializable {
    private final String b;
    private final transient c c;

    m(String string, c c2) {
        this.b = string;
        this.c = c2;
    }

    static m K(String string, boolean bl) {
        int n2 = string.length();
        if (n2 >= 2) {
            d d22;
            block5 : {
                c c2;
                for (int i2 = 0; i2 < n2; ++i2) {
                    char c4 = string.charAt(i2);
                    if (c4 >= 'a' && c4 <= 'z' || c4 >= 'A' && c4 <= 'Z' || c4 == '/' && i2 != 0 || c4 >= '0' && c4 <= '9' && i2 != 0 || c4 == '~' && i2 != 0 || c4 == '.' && i2 != 0 || c4 == '_' && i2 != 0 || c4 == '+' && i2 != 0 || c4 == '-' && i2 != 0) {
                        continue;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid ID for region-based ZoneId, invalid format: ");
                    stringBuilder.append(string);
                    throw new g(stringBuilder.toString());
                }
                try {
                    c2 = e.b(string, true);
                }
                catch (d d22) {
                    c2 = null;
                    if (bl) break block5;
                }
                return new m(string, c2);
            }
            throw d22;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid ID for region-based ZoneId, invalid format: ");
        stringBuilder.append(string);
        throw new g(stringBuilder.toString());
    }

    @Override
    public c G() {
        c c2 = this.c;
        if (c2 != null) {
            return c2;
        }
        return e.b(this.b, false);
    }

    @Override
    public String m() {
        return this.b;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package com.scandit.datacapture.tools.internal.a.a;

import java.util.Arrays;

public final class e$a {
    public final String a;
    public final a b;
    public a c;

    public e$a(String string, byte by) {
        a a2;
        this.b = a2 = new a(0);
        this.c = a2;
        this.a = string;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.a);
        stringBuilder.append('{');
        a a2 = this.b.c;
        String string = "";
        while (a2 != null) {
            Object object = a2.b;
            stringBuilder.append(string);
            String string2 = a2.a;
            if (string2 != null) {
                stringBuilder.append(string2);
                stringBuilder.append('=');
            }
            if (object != null && object.getClass().isArray()) {
                String string3 = Arrays.deepToString((Object[])new Object[]{object});
                stringBuilder.append((CharSequence)string3, 1, string3.length() - 1);
            } else {
                stringBuilder.append(object);
            }
            a2 = a2.c;
            string = ", ";
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static final class a {
        public String a;
        public Object b;
        public a c;

        public a(byte by) {
        }
    }

}


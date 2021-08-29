/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package com.scandit.datacapture.tools.internal.a.a;

import com.google.android.material.R;
import com.scandit.datacapture.tools.internal.a.a.d;
import com.scandit.datacapture.tools.internal.a.a.e$a;
import java.util.logging.Level;
import java.util.logging.Logger;

public class c {
    public boolean a;
    public d.l d;
    public d.l e;

    public static String a(String string) {
        int n2 = string.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            boolean bl = c2 >= 'A' && c2 <= 'Z';
            if (!bl) continue;
            char[] arrc = string.toCharArray();
            while (i2 < n2) {
                char c3 = arrc[i2];
                boolean bl2 = c3 >= 'A' && c3 <= 'Z';
                if (bl2) {
                    arrc[i2] = (char)(c3 ^ 32);
                }
                ++i2;
            }
            return String.valueOf((char[])arrc);
        }
        return string;
    }

    public static void a(boolean bl, String string, Object object) {
        if (!bl) {
            int n2;
            int n3;
            Object[] arrobject = new Object[]{object};
            for (int i2 = 0; i2 <= 0; ++i2) {
                String string2;
                Object object2 = arrobject[0];
                try {
                    string2 = String.valueOf((Object)object2);
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(object2.getClass().getName());
                    stringBuilder.append('@');
                    stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)object2)));
                    String string3 = stringBuilder.toString();
                    Logger logger = Logger.getLogger((String)"com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    StringBuilder stringBuilder2 = new StringBuilder("Exception during lenientFormat for ");
                    stringBuilder2.append(string3);
                    logger.log(level, stringBuilder2.toString(), (Throwable)exception);
                    StringBuilder stringBuilder3 = new StringBuilder("<");
                    stringBuilder3.append(string3);
                    stringBuilder3.append(" threw ");
                    stringBuilder3.append(exception.getClass().getName());
                    stringBuilder3.append(">");
                    string2 = stringBuilder3.toString();
                }
                arrobject[0] = string2;
            }
            StringBuilder stringBuilder = new StringBuilder(16 + string.length());
            int n4 = 0;
            for (n2 = 0; n2 <= 0 && (n3 = string.indexOf("%s", 0)) != -1; ++n2) {
                stringBuilder.append((CharSequence)string, 0, n3);
                stringBuilder.append(arrobject[0]);
                n4 = n3 + 2;
            }
            stringBuilder.append((CharSequence)string, n4, string.length());
            if (n2 <= 0) {
                stringBuilder.append(" [");
                stringBuilder.append(arrobject[0]);
                stringBuilder.append(']');
            }
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public final d.l d() {
        return (d.l)((Object)R.style.a((Object)((Object)this.d), (Object)((Object)d.l.a)));
    }

    public final d.l f() {
        return (d.l)((Object)R.style.a((Object)((Object)this.e), (Object)((Object)d.l.a)));
    }

    public final String toString() {
        d.l l2;
        e$a e$a = new e$a(c.class.getSimpleName(), 0);
        d.l l3 = this.d;
        if (l3 != null) {
            e$a.a a2;
            String string = c.a(l3.toString());
            e$a.c.c = a2 = new e$a.a(0);
            e$a.c = a2;
            a2.b = string;
            a2.a = "keyStrength";
        }
        if ((l2 = this.e) != null) {
            e$a.a a3;
            String string = c.a(l2.toString());
            e$a.c.c = a3 = new e$a.a(0);
            e$a.c = a3;
            a3.b = string;
            a3.a = "valueStrength";
        }
        return e$a.toString();
    }
}


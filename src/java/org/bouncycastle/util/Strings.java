/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 */
package org.bouncycastle.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

public final class Strings {
    public static String LINE_SEPARATOR;

    public static {
        try {
            LINE_SEPARATOR = (String)AccessController.doPrivileged((PrivilegedAction)new PrivilegedAction<String>(){

                public Object run() {
                    return System.getProperty((String)"line.separator");
                }
            });
        }
        catch (Exception exception) {
            try {
                LINE_SEPARATOR = String.format((String)"%n", (Object[])new Object[0]);
            }
            catch (Exception exception2) {
                LINE_SEPARATOR = "\n";
            }
        }
    }

    public static String fromByteArray(byte[] arrby) {
        int n2 = arrby.length;
        char[] arrc = new char[n2];
        for (int i2 = 0; i2 != n2; ++i2) {
            arrc[i2] = (char)(255 & arrby[i2]);
        }
        return new String(arrc);
    }

    public static byte[] toByteArray(String string) {
        int n2 = string.length();
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 != n2; ++i2) {
            arrby[i2] = (byte)string.charAt(i2);
        }
        return arrby;
    }

    public static String toLowerCase(String string) {
        char[] arrc = string.toCharArray();
        boolean bl = false;
        for (int i2 = 0; i2 != arrc.length; ++i2) {
            char c2 = arrc[i2];
            if ('A' > c2 || 'Z' < c2) continue;
            arrc[i2] = (char)(97 + (c2 - 65));
            bl = true;
        }
        if (bl) {
            string = new String(arrc);
        }
        return string;
    }

    public static String toUpperCase(String string) {
        char[] arrc = string.toCharArray();
        boolean bl = false;
        for (int i2 = 0; i2 != arrc.length; ++i2) {
            char c2 = arrc[i2];
            if ('a' > c2 || 'z' < c2) continue;
            arrc[i2] = (char)(65 + (c2 - 97));
            bl = true;
        }
        if (bl) {
            string = new String(arrc);
        }
        return string;
    }

}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.UnsupportedOperationException
 *  java.security.AccessController
 *  java.security.PrivilegedAction
 */
package j$.util.stream;

import j$.util.stream.I0;
import java.security.AccessController;
import java.security.PrivilegedAction;

final class i3 {
    static final boolean a = (Boolean)AccessController.doPrivileged((PrivilegedAction)I0.a);

    static void a(Class class_, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)class_);
        stringBuilder.append(" tripwire tripped but logging not supported: ");
        stringBuilder.append(string);
        throw new UnsupportedOperationException(stringBuilder.toString());
    }
}


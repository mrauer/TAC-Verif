/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivilegedAction
 */
package j$.util.concurrent;

import java.security.PrivilegedAction;

class c
implements PrivilegedAction<Boolean> {
    c() {
    }

    public Object run() {
        return Boolean.getBoolean((String)"java.util.secureRandomSeed");
    }
}


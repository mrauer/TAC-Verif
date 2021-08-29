/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivilegedAction
 */
package j$.util;

import java.security.PrivilegedAction;

public final class i
implements PrivilegedAction {
    public static final /* synthetic */ i a;

    static /* synthetic */ {
        a = new i();
    }

    private /* synthetic */ i() {
    }

    public final Object run() {
        return Boolean.getBoolean((String)"org.openjdk.java.util.stream.tripwire");
    }
}


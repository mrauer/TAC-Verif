/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.PrivilegedAction
 */
package org.bouncycastle.util;

import java.security.PrivilegedAction;

public final class Properties$2
implements PrivilegedAction {
    public final /* synthetic */ String val$propertyName;

    public Properties$2(String string) {
        this.val$propertyName = string;
    }

    public Object run() {
        return System.getProperty((String)this.val$propertyName);
    }
}


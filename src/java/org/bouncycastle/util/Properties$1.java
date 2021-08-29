/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivilegedAction
 *  java.security.Security
 */
package org.bouncycastle.util;

import java.security.PrivilegedAction;
import java.security.Security;

public final class Properties$1
implements PrivilegedAction {
    public final /* synthetic */ String val$propertyName;

    public Properties$1(String string) {
        this.val$propertyName = string;
    }

    public Object run() {
        return Security.getProperty((String)this.val$propertyName);
    }
}


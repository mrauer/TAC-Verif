/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.security.PrivilegedAction
 */
package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.PrivilegedAction;

public final class ClassUtil$1
implements PrivilegedAction {
    public final /* synthetic */ String val$className;

    public ClassUtil$1(String string) {
        this.val$className = string;
    }

    public Object run() {
        try {
            Class class_ = Class.forName((String)this.val$className);
            return class_;
        }
        catch (Exception exception) {
            return null;
        }
    }
}


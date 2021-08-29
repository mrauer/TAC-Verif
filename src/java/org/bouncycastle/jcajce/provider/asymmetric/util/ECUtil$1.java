/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.security.PrivilegedAction
 *  java.security.spec.AlgorithmParameterSpec
 */
package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;
import java.security.spec.AlgorithmParameterSpec;

public final class ECUtil$1
implements PrivilegedAction {
    public final /* synthetic */ AlgorithmParameterSpec val$paramSpec;

    public ECUtil$1(AlgorithmParameterSpec algorithmParameterSpec) {
        this.val$paramSpec = algorithmParameterSpec;
    }

    public Object run() {
        try {
            Object object = this.val$paramSpec.getClass().getMethod("getName", new Class[0]).invoke((Object)this.val$paramSpec, new Object[0]);
            return object;
        }
        catch (Exception exception) {
            return null;
        }
    }
}


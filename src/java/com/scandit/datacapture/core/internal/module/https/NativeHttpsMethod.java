/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeHttpsMethod
extends Enum<NativeHttpsMethod> {
    public static final /* enum */ NativeHttpsMethod GET;
    public static final /* enum */ NativeHttpsMethod POST;
    private static final /* synthetic */ NativeHttpsMethod[] a;

    public static {
        NativeHttpsMethod nativeHttpsMethod;
        NativeHttpsMethod nativeHttpsMethod2;
        GET = nativeHttpsMethod = new NativeHttpsMethod();
        POST = nativeHttpsMethod2 = new NativeHttpsMethod();
        a = new NativeHttpsMethod[]{nativeHttpsMethod, nativeHttpsMethod2};
    }

    public static NativeHttpsMethod valueOf(String string) {
        return (NativeHttpsMethod)Enum.valueOf(NativeHttpsMethod.class, (String)string);
    }

    public static NativeHttpsMethod[] values() {
        return (NativeHttpsMethod[])a.clone();
    }
}


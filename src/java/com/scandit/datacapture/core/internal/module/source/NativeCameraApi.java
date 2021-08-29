/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeCameraApi
extends Enum<NativeCameraApi> {
    public static final /* enum */ NativeCameraApi CAMERA1;
    public static final /* enum */ NativeCameraApi CAMERA2;
    private static final /* synthetic */ NativeCameraApi[] a;

    public static {
        NativeCameraApi nativeCameraApi;
        NativeCameraApi nativeCameraApi2;
        CAMERA1 = nativeCameraApi2 = new NativeCameraApi();
        CAMERA2 = nativeCameraApi = new NativeCameraApi();
        a = new NativeCameraApi[]{nativeCameraApi2, nativeCameraApi};
    }

    public static NativeCameraApi valueOf(String string) {
        return (NativeCameraApi)Enum.valueOf(NativeCameraApi.class, (String)string);
    }

    public static NativeCameraApi[] values() {
        return (NativeCameraApi[])a.clone();
    }
}


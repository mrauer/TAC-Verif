/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeServerEndpoint
extends Enum<NativeServerEndpoint> {
    public static final /* enum */ NativeServerEndpoint NONE;
    public static final /* enum */ NativeServerEndpoint PRODUCTION_EVENTS;
    public static final /* enum */ NativeServerEndpoint PRODUCTION_IMAGE_COLLECTION;
    public static final /* enum */ NativeServerEndpoint STAGING_EVENTS;
    public static final /* enum */ NativeServerEndpoint STAGING_IMAGE_COLLECTION;
    private static final /* synthetic */ NativeServerEndpoint[] a;

    public static {
        NativeServerEndpoint nativeServerEndpoint;
        NativeServerEndpoint nativeServerEndpoint2;
        NativeServerEndpoint nativeServerEndpoint3;
        NativeServerEndpoint nativeServerEndpoint4;
        NativeServerEndpoint nativeServerEndpoint5;
        NONE = nativeServerEndpoint2 = new NativeServerEndpoint();
        PRODUCTION_EVENTS = nativeServerEndpoint3 = new NativeServerEndpoint();
        STAGING_EVENTS = nativeServerEndpoint5 = new NativeServerEndpoint();
        PRODUCTION_IMAGE_COLLECTION = nativeServerEndpoint4 = new NativeServerEndpoint();
        STAGING_IMAGE_COLLECTION = nativeServerEndpoint = new NativeServerEndpoint();
        a = new NativeServerEndpoint[]{nativeServerEndpoint2, nativeServerEndpoint3, nativeServerEndpoint5, nativeServerEndpoint4, nativeServerEndpoint};
    }

    public static NativeServerEndpoint valueOf(String string) {
        return (NativeServerEndpoint)Enum.valueOf(NativeServerEndpoint.class, (String)string);
    }

    public static NativeServerEndpoint[] values() {
        return (NativeServerEndpoint[])a.clone();
    }
}


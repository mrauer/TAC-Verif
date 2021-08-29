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
public final class NativeFeatureAvailability
extends Enum<NativeFeatureAvailability> {
    public static final /* enum */ NativeFeatureAvailability SUPPORTED;
    public static final /* enum */ NativeFeatureAvailability UNKNOWN;
    public static final /* enum */ NativeFeatureAvailability UNSUPPORTED;
    private static final /* synthetic */ NativeFeatureAvailability[] a;

    public static {
        NativeFeatureAvailability nativeFeatureAvailability;
        NativeFeatureAvailability nativeFeatureAvailability2;
        NativeFeatureAvailability nativeFeatureAvailability3;
        UNKNOWN = nativeFeatureAvailability3 = new NativeFeatureAvailability();
        SUPPORTED = nativeFeatureAvailability2 = new NativeFeatureAvailability();
        UNSUPPORTED = nativeFeatureAvailability = new NativeFeatureAvailability();
        a = new NativeFeatureAvailability[]{nativeFeatureAvailability3, nativeFeatureAvailability2, nativeFeatureAvailability};
    }

    public static NativeFeatureAvailability valueOf(String string) {
        return (NativeFeatureAvailability)Enum.valueOf(NativeFeatureAvailability.class, (String)string);
    }

    public static NativeFeatureAvailability[] values() {
        return (NativeFeatureAvailability[])a.clone();
    }
}


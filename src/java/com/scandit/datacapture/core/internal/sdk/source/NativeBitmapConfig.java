/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeBitmapConfig
extends Enum<NativeBitmapConfig> {
    public static final /* enum */ NativeBitmapConfig ARGB_8888;
    private static final /* synthetic */ NativeBitmapConfig[] a;

    public static {
        NativeBitmapConfig nativeBitmapConfig;
        ARGB_8888 = nativeBitmapConfig = new NativeBitmapConfig();
        a = new NativeBitmapConfig[]{nativeBitmapConfig};
    }

    public static NativeBitmapConfig valueOf(String string) {
        return (NativeBitmapConfig)Enum.valueOf(NativeBitmapConfig.class, (String)string);
    }

    public static NativeBitmapConfig[] values() {
        return (NativeBitmapConfig[])a.clone();
    }
}


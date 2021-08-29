/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui.video;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativePreviewShaderFormat
extends Enum<NativePreviewShaderFormat> {
    public static final /* enum */ NativePreviewShaderFormat BI_PLANAR_YUV;
    public static final /* enum */ NativePreviewShaderFormat OES_EXTERNAL;
    public static final /* enum */ NativePreviewShaderFormat RGBA;
    private static final /* synthetic */ NativePreviewShaderFormat[] a;

    public static {
        NativePreviewShaderFormat nativePreviewShaderFormat;
        NativePreviewShaderFormat nativePreviewShaderFormat2;
        NativePreviewShaderFormat nativePreviewShaderFormat3;
        BI_PLANAR_YUV = nativePreviewShaderFormat2 = new NativePreviewShaderFormat();
        OES_EXTERNAL = nativePreviewShaderFormat3 = new NativePreviewShaderFormat();
        RGBA = nativePreviewShaderFormat = new NativePreviewShaderFormat();
        a = new NativePreviewShaderFormat[]{nativePreviewShaderFormat2, nativePreviewShaderFormat3, nativePreviewShaderFormat};
    }

    public static NativePreviewShaderFormat valueOf(String string) {
        return (NativePreviewShaderFormat)Enum.valueOf(NativePreviewShaderFormat.class, (String)string);
    }

    public static NativePreviewShaderFormat[] values() {
        return (NativePreviewShaderFormat[])a.clone();
    }
}


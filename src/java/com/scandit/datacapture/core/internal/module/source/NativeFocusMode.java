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
public final class NativeFocusMode
extends Enum<NativeFocusMode> {
    public static final /* enum */ NativeFocusMode AUTO;
    public static final /* enum */ NativeFocusMode FIXED;
    private static final /* synthetic */ NativeFocusMode[] a;

    public static {
        NativeFocusMode nativeFocusMode;
        NativeFocusMode nativeFocusMode2;
        FIXED = nativeFocusMode2 = new NativeFocusMode();
        AUTO = nativeFocusMode = new NativeFocusMode();
        a = new NativeFocusMode[]{nativeFocusMode2, nativeFocusMode};
    }

    public static NativeFocusMode valueOf(String string) {
        return (NativeFocusMode)Enum.valueOf(NativeFocusMode.class, (String)string);
    }

    public static NativeFocusMode[] values() {
        return (NativeFocusMode[])a.clone();
    }
}


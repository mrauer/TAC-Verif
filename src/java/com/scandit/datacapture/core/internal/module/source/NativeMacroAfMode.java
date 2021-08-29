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
public final class NativeMacroAfMode
extends Enum<NativeMacroAfMode> {
    public static final /* enum */ NativeMacroAfMode MACRO;
    public static final /* enum */ NativeMacroAfMode MANUAL_THEN_CONTINUOUS;
    public static final /* enum */ NativeMacroAfMode OFF;
    private static final /* synthetic */ NativeMacroAfMode[] a;

    public static {
        NativeMacroAfMode nativeMacroAfMode;
        NativeMacroAfMode nativeMacroAfMode2;
        NativeMacroAfMode nativeMacroAfMode3;
        OFF = nativeMacroAfMode3 = new NativeMacroAfMode();
        MACRO = nativeMacroAfMode2 = new NativeMacroAfMode();
        MANUAL_THEN_CONTINUOUS = nativeMacroAfMode = new NativeMacroAfMode();
        a = new NativeMacroAfMode[]{nativeMacroAfMode3, nativeMacroAfMode2, nativeMacroAfMode};
    }

    public static NativeMacroAfMode valueOf(String string) {
        return (NativeMacroAfMode)Enum.valueOf(NativeMacroAfMode.class, (String)string);
    }

    public static NativeMacroAfMode[] values() {
        return (NativeMacroAfMode[])a.clone();
    }
}


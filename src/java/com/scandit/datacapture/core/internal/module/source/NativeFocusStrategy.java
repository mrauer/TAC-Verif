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
public final class NativeFocusStrategy
extends Enum<NativeFocusStrategy> {
    public static final /* enum */ NativeFocusStrategy AUTO;
    public static final /* enum */ NativeFocusStrategy CONTINUOUS_UNTIL_NO_SCAN;
    public static final /* enum */ NativeFocusStrategy FORCE_CONTINUOUS;
    public static final /* enum */ NativeFocusStrategy FORCE_RETRIGGER;
    public static final /* enum */ NativeFocusStrategy ONLY_ON_REQUEST;
    public static final /* enum */ NativeFocusStrategy RETRIGGER_UNTIL_SCAN;
    private static final /* synthetic */ NativeFocusStrategy[] a;

    public static {
        NativeFocusStrategy nativeFocusStrategy;
        NativeFocusStrategy nativeFocusStrategy2;
        NativeFocusStrategy nativeFocusStrategy3;
        NativeFocusStrategy nativeFocusStrategy4;
        NativeFocusStrategy nativeFocusStrategy5;
        NativeFocusStrategy nativeFocusStrategy6;
        AUTO = nativeFocusStrategy5 = new NativeFocusStrategy();
        ONLY_ON_REQUEST = nativeFocusStrategy3 = new NativeFocusStrategy();
        FORCE_CONTINUOUS = nativeFocusStrategy = new NativeFocusStrategy();
        FORCE_RETRIGGER = nativeFocusStrategy6 = new NativeFocusStrategy();
        RETRIGGER_UNTIL_SCAN = nativeFocusStrategy2 = new NativeFocusStrategy();
        CONTINUOUS_UNTIL_NO_SCAN = nativeFocusStrategy4 = new NativeFocusStrategy();
        a = new NativeFocusStrategy[]{nativeFocusStrategy5, nativeFocusStrategy3, nativeFocusStrategy, nativeFocusStrategy6, nativeFocusStrategy2, nativeFocusStrategy4};
    }

    public static NativeFocusStrategy valueOf(String string) {
        return (NativeFocusStrategy)Enum.valueOf(NativeFocusStrategy.class, (String)string);
    }

    public static NativeFocusStrategy[] values() {
        return (NativeFocusStrategy[])a.clone();
    }
}


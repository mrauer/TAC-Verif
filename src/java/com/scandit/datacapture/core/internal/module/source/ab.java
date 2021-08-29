/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.internal.module.serialization.NativeEnumSerializer;
import com.scandit.datacapture.core.internal.module.source.NativeFocusStrategy;
import kotlin.jvm.internal.Intrinsics;

public final class ab {
    public static final String a(NativeFocusStrategy nativeFocusStrategy) {
        Intrinsics.checkNotNullParameter((Object)((Object)nativeFocusStrategy), (String)"focusStrategy");
        Intrinsics.checkNotNullParameter((Object)((Object)nativeFocusStrategy), (String)"$this$toJson");
        String string = NativeEnumSerializer.focusStrategyToString(nativeFocusStrategy);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"NativeEnumSerializer.focusStrategyToString(this)");
        return string;
    }
}


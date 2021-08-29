/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.NativeGestureListener;
import com.scandit.datacapture.core.internal.module.ui.c;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.internal.Intrinsics;

public final class GestureListener {
    public final /* synthetic */ c a;

    public GestureListener(NativeGestureListener nativeGestureListener) {
        Intrinsics.checkNotNullParameter((Object)nativeGestureListener, (String)"impl");
        this.a = new c(nativeGestureListener, null, 2);
    }
}


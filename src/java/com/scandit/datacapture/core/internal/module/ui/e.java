/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.ui.e$a
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KClass
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.module.ui.GestureListener;
import com.scandit.datacapture.core.internal.module.ui.GestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureListener;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.NativeGestureType;
import com.scandit.datacapture.core.internal.module.ui.e;
import com.scandit.datacapture.tools.internal.sdk.GuavaMapMakerProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import com.scandit.datacapture.tools.internal.sdk.ProxyCacheKt;
import java.util.EnumSet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class e
extends NativeGestureRecognizer {
    public final GestureRecognizer a;
    public final ProxyCache b;

    public e(GestureRecognizer gestureRecognizer, ProxyCache proxyCache, int n2) {
        GuavaMapMakerProxyCache guavaMapMakerProxyCache = ProxyCacheKt.a;
        Intrinsics.checkNotNullParameter((Object)gestureRecognizer, (String)"_GestureRecognizer");
        Intrinsics.checkNotNullParameter((Object)guavaMapMakerProxyCache, (String)"proxyCache");
        this.a = gestureRecognizer;
        this.b = guavaMapMakerProxyCache;
    }

    @Override
    public final void setGestureListener(NativeGestureListener nativeGestureListener, EnumSet<NativeGestureType> enumSet) {
        Intrinsics.checkNotNullParameter((Object)nativeGestureListener, (String)"listener");
        Intrinsics.checkNotNullParameter(enumSet, (String)"gestures");
        GestureListener gestureListener = (GestureListener)this.b.getOrPut(Reflection.getOrCreateKotlinClass(NativeGestureListener.class), (Object)null, nativeGestureListener, new a(nativeGestureListener));
        this.a.a(gestureListener, enumSet);
    }
}


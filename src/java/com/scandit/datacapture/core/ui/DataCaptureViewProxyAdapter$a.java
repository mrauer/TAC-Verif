/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.core.internal.module.ui.GestureRecognizer;
import com.scandit.datacapture.core.internal.module.ui.e;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class DataCaptureViewProxyAdapter$a
extends Lambda
implements Function0<e> {
    public /* synthetic */ GestureRecognizer a;

    public DataCaptureViewProxyAdapter$a(GestureRecognizer gestureRecognizer) {
        this.a = gestureRecognizer;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new e(this.a, null, 2);
    }
}


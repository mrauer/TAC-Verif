/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListener;
import com.scandit.datacapture.core.internal.sdk.ui.NeedsRedrawListenerReversedAdapter;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class DataCaptureViewProxyAdapter$b
extends Lambda
implements Function0<NeedsRedrawListenerReversedAdapter> {
    public /* synthetic */ NeedsRedrawListener a;

    public DataCaptureViewProxyAdapter$b(NeedsRedrawListener needsRedrawListener) {
        this.a = needsRedrawListener;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return new NeedsRedrawListenerReversedAdapter(this.a, null, 2);
    }
}


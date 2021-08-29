/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.properties.ObservableProperty
 *  kotlin.reflect.KProperty
 */
package com.scandit.datacapture.core.ui;

import com.scandit.datacapture.core.internal.module.ui.ViewSize;
import com.scandit.datacapture.core.ui.DataCaptureView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

public final class DataCaptureView$$special$$inlined$distinctObservable$1
extends ObservableProperty<ViewSize> {
    public /* synthetic */ Object a;
    public /* synthetic */ DataCaptureView b;

    public DataCaptureView$$special$$inlined$distinctObservable$1(Object object, Object object2, DataCaptureView dataCaptureView) {
        this.a = object;
        this.b = dataCaptureView;
        super(object2);
    }

    public final void afterChange(KProperty<?> kProperty, ViewSize viewSize, ViewSize viewSize2) {
        Intrinsics.checkNotNullParameter(kProperty, (String)"property");
        if (true ^ Intrinsics.areEqual((Object)viewSize, (Object)viewSize2)) {
            ViewSize viewSize3 = viewSize2;
            int n2 = viewSize3.a;
            int n3 = viewSize3.b;
            this.b.a(n2, n3);
        }
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.barcode.capture.BarcodeCaptureSession$a
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Lazy
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.capture;

import com.google.android.material.R;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureSession;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureSession {
    public final Lazy a;

    public BarcodeCaptureSession(Function0<? extends NativeBarcodeCaptureSession> function0) {
        Intrinsics.checkNotNullParameter(function0, (String)"getImpl");
        this.a = R.style.lazy((Function0)new a(function0));
    }
}


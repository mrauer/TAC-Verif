/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.barcode.capture;

import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCaptureSession;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class BarcodeCapture$b
extends Lambda
implements Function0<NativeBarcodeCaptureSession> {
    public /* synthetic */ NativeBarcodeCapture a;

    public BarcodeCapture$b(NativeBarcodeCapture nativeBarcodeCapture) {
        this.a = nativeBarcodeCapture;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        NativeBarcodeCaptureSession nativeBarcodeCaptureSession = this.a.getSession();
        Intrinsics.checkNotNullExpressionValue((Object)nativeBarcodeCaptureSession, (String)"impl.session");
        return nativeBarcodeCaptureSession;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.android.material.R
 *  com.google.android.material.R$style
 *  com.scandit.datacapture.barcode.capture.BarcodeCapture
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.ui.overlay;

import com.google.android.material.R;
import com.scandit.datacapture.barcode.capture.BarcodeCapture;
import com.scandit.datacapture.barcode.capture.BarcodeCaptureProxyAdapter;
import com.scandit.datacapture.barcode.internal.module.capture.NativeBarcodeCapture;
import com.scandit.datacapture.barcode.internal.module.ui.NativeBarcodeCaptureOverlay;
import com.scandit.datacapture.barcode.ui.overlay.BarcodeCaptureOverlayProxyAdapter;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCaptureOverlay {
    public static final BarcodeCaptureOverlay Companion;
    public final /* synthetic */ BarcodeCaptureOverlayProxyAdapter c;

    public static {
        NativeBrush nativeBrush = NativeBarcodeCaptureOverlay.defaultBrushForRecognizedBarcodes();
        Intrinsics.checkNotNullExpressionValue((Object)nativeBrush, (String)"NativeBarcodeCaptureOver\u2026shForRecognizedBarcodes()");
        Intrinsics.checkNotNullParameter((Object)nativeBrush, (String)"nativeBrush");
        Intrinsics.checkNotNullParameter((Object)nativeBrush, (String)"source");
        NativeColor nativeColor = nativeBrush.getFillColor();
        Intrinsics.checkNotNullExpressionValue((Object)nativeColor, (String)"source.fillColor");
        R.style.toInt((NativeColor)nativeColor);
        NativeColor nativeColor2 = nativeBrush.getStrokeColor();
        Intrinsics.checkNotNullExpressionValue((Object)nativeColor2, (String)"source.strokeColor");
        R.style.toInt((NativeColor)nativeColor2);
        nativeBrush.getStrokeWidth();
    }

    public BarcodeCaptureOverlay(BarcodeCapture barcodeCapture, DefaultConstructorMarker defaultConstructorMarker) {
        NativeBarcodeCaptureOverlay nativeBarcodeCaptureOverlay = NativeBarcodeCaptureOverlay.create(barcodeCapture.e.b);
        Intrinsics.checkNotNullExpressionValue((Object)nativeBarcodeCaptureOverlay, (String)"NativeBarcodeCaptureOver\u2026e(barcodeCapture._impl())");
        Intrinsics.checkNotNullParameter((Object)nativeBarcodeCaptureOverlay, (String)"impl");
        this.c = new BarcodeCaptureOverlayProxyAdapter(nativeBarcodeCaptureOverlay, null, 2);
        new HashMap();
    }
}


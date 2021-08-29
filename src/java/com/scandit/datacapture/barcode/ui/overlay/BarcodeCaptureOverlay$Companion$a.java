/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package com.scandit.datacapture.barcode.ui.overlay;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class BarcodeCaptureOverlay$Companion$a
extends Lambda
implements Function0<Object> {
    public static final BarcodeCaptureOverlay$Companion$a a = new BarcodeCaptureOverlay$Companion$a();

    public BarcodeCaptureOverlay$Companion$a() {
        super(0);
    }

    public final Object invoke() {
        return "This overlay's mode and view are attached to different data capture contexts!";
    }
}


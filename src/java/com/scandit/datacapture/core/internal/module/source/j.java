/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureRequest$Key
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.source;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;

public final class j {
    public static final j a;
    @TargetApi(value=29)
    public static final CaptureRequest.Key<Integer> b;

    public static {
        b = new CaptureRequest.Key("samsung.android.control.setBarcodeApp", Integer.TYPE);
    }

    public static CaptureRequest.Key<Integer> a() {
        return b;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.data;

import com.scandit.datacapture.barcode.data.BarcodeProxyAdapter;
import com.scandit.datacapture.barcode.internal.sdk.data.NativeBarcode;
import com.scandit.datacapture.tools.internal.sdk.ProxyCache;
import kotlin.jvm.internal.Intrinsics;

public final class Barcode {
    public final /* synthetic */ BarcodeProxyAdapter a;

    public Barcode(NativeBarcode nativeBarcode) {
        Intrinsics.checkNotNullParameter((Object)nativeBarcode, (String)"impl");
        this.a = new BarcodeProxyAdapter(nativeBarcode, null, 2);
    }

    public final String getData() {
        return this.a.a.getUtf8String();
    }
}


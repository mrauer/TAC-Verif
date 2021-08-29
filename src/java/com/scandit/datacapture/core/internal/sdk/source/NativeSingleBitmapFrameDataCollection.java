/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.source.NativeSingleBitmapFrameDataCollection$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.source.NativeBitmapInfo;
import com.scandit.datacapture.core.internal.sdk.source.NativeSingleBitmapFrameDataCollection;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeSingleBitmapFrameDataCollection {
    public NativeSingleBitmapFrameDataCollection() {
    }

    public static NativeSingleBitmapFrameDataCollection create(NativeBitmapInfo nativeBitmapInfo) {
        return CppProxy.create((NativeBitmapInfo)nativeBitmapInfo);
    }

    public abstract NativeFrameData get(int var1);

    public abstract int getSize();
}


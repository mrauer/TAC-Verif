/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.data.NativeDataDecodingFactory$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.data;

import com.scandit.datacapture.core.internal.module.data.NativeDataDecoding;
import com.scandit.datacapture.core.internal.module.data.NativeDataDecodingFactory;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataDecodingFactory {
    public NativeDataDecodingFactory() {
    }

    public static NativeDataDecoding getDataDecoding() {
        return CppProxy.getDataDecoding();
    }

    public static void setDataDecoding(NativeDataDecoding nativeDataDecoding) {
        CppProxy.setDataDecoding((NativeDataDecoding)nativeDataDecoding);
    }
}


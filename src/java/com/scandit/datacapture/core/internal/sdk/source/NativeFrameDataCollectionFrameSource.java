/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.source.NativeFrameDataCollectionFrameSource$CppProxy
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.source;

import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSourceListener;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.core.internal.sdk.source.NativeFrameDataCollectionFrameSource;
import com.scandit.datacapture.core.internal.sdk.source.NativeSingleBitmapFrameDataCollection;
import com.scandit.datacapture.core.source.FrameSourceState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeFrameDataCollectionFrameSource {
    public NativeFrameDataCollectionFrameSource() {
    }

    public static NativeFrameDataCollectionFrameSource create(NativeSingleBitmapFrameDataCollection nativeSingleBitmapFrameDataCollection) {
        return CppProxy.create((NativeSingleBitmapFrameDataCollection)nativeSingleBitmapFrameDataCollection);
    }

    public abstract void addListenerAsync(NativeFrameSourceListener var1);

    public abstract NativeFrameSource asFrameSource();

    public abstract FrameSourceState getCurrentState();

    public abstract FrameSourceState getDesiredState();

    public abstract void removeListenerAsync(NativeFrameSourceListener var1);

    public abstract void setRepeatAsync(boolean var1);

    public abstract NativeWrappedFuture switchToDesiredStateAsyncAndroid(FrameSourceState var1);
}


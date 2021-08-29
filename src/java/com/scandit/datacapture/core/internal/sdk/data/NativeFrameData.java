/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.sdk.data;

import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeImageBuffer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameData {
    public abstract NativeImageBuffer getImageBuffer();

    public abstract int getOrientation();

    public abstract void release();

    public abstract void retain();
}


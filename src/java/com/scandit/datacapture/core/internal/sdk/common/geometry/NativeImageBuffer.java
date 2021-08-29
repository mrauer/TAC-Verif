/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.common.geometry.NativeImageBuffer$CppProxy
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.sdk.common.geometry;

import com.scandit.datacapture.core.common.graphic.ImagePlane;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeImageBuffer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeImageBuffer {
    public NativeImageBuffer() {
    }

    public static NativeImageBuffer create(int n2, int n3, ArrayList<ImagePlane> arrayList) {
        return CppProxy.create((int)n2, (int)n3, arrayList);
    }

    public abstract NativeImageBuffer deepCopy();

    public abstract int getHeight();

    public abstract ArrayList<ImagePlane> getPlanes();

    public abstract int getWidth();

    public abstract byte[] toBitmap();
}


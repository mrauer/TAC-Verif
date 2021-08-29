/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk;

import com.scandit.datacapture.core.data.FrameData;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import kotlin.jvm.internal.Intrinsics;

public final class CoreNativeTypeFactory$convert$1
implements FrameData {
    public final NativeFrameData a;
    public /* synthetic */ NativeFrameData b;

    public CoreNativeTypeFactory$convert$1(NativeFrameData nativeFrameData) {
        this.b = nativeFrameData;
        this.a = nativeFrameData;
    }

    @Override
    public final NativeFrameData _impl() {
        return this.a;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof FrameData)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.a, (Object)((FrameData)object)._impl());
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}


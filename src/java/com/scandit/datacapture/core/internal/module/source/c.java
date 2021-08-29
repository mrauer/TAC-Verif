/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  com.scandit.datacapture.core.internal.module.source.c$a
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.ad;
import com.scandit.datacapture.core.internal.module.source.c;
import com.scandit.datacapture.core.internal.module.source.d;
import com.scandit.datacapture.core.internal.module.source.f;
import com.scandit.datacapture.core.internal.module.source.w;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.CameraSettings;
import com.scandit.datacapture.core.source.FrameSourceState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class c
implements w {
    public final b a;
    public final f b;

    public c(b b2, f f2, int n2) {
        b b3 = com.scandit.datacapture.core.internal.module.b.a.a.c.a();
        ad ad2 = ad.a;
        Intrinsics.checkNotNullParameter((Object)b3, (String)"cameraProfile");
        Intrinsics.checkNotNullParameter((Object)ad2, (String)"cameraInfoProvider");
        this.a = b3;
        this.b = ad2;
    }

    @Override
    public final NativeCameraDelegate a(CameraPosition cameraPosition, CameraSettings cameraSettings, Function1<? super NativeCameraFrameData, Unit> function1, Function1<? super FrameSourceState, Unit> function12) {
        Intrinsics.checkNotNullParameter((Object)((Object)cameraPosition), (String)"position");
        Intrinsics.checkNotNullParameter(function1, (String)"frameCallback");
        Intrinsics.checkNotNullParameter(function12, (String)"errorCallback");
        CameraPosition cameraPosition2 = CameraPosition.UNSPECIFIED;
        boolean bl = cameraPosition != cameraPosition2;
        if (bl) {
            Object object2;
            block7 : {
                int n2;
                int n3 = d.a[cameraPosition.ordinal()];
                if (n3 != 1) {
                    if (n3 != 2) {
                        if (n3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        StringBuilder stringBuilder = new StringBuilder("Unsupported CameraPosition ");
                        stringBuilder.append((Object)cameraPosition2);
                        throw new AssertionError((Object)stringBuilder.toString());
                    }
                    n2 = 0;
                } else {
                    n2 = 1;
                }
                for (Object object2 : this.b.a()) {
                    boolean bl2 = ((Camera.CameraInfo)object2).facing == n2;
                    if (!bl2) continue;
                    break block7;
                }
                object2 = null;
            }
            Camera.CameraInfo cameraInfo = (Camera.CameraInfo)object2;
            if (cameraInfo == null) {
                return null;
            }
            return new com.scandit.datacapture.core.internal.module.source.a(cameraInfo, this.a, function1, (Function1<? super FrameSourceState, Unit>)a.a);
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}


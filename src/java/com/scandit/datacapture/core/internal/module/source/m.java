/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.camera2.CameraManager
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Integer
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
import android.hardware.camera2.CameraManager;
import com.scandit.datacapture.core.internal.module.b.a.a.b;
import com.scandit.datacapture.core.internal.module.b.a.a.c;
import com.scandit.datacapture.core.internal.module.source.NativeCameraDelegate;
import com.scandit.datacapture.core.internal.module.source.af;
import com.scandit.datacapture.core.internal.module.source.f;
import com.scandit.datacapture.core.internal.module.source.k;
import com.scandit.datacapture.core.internal.module.source.n;
import com.scandit.datacapture.core.internal.module.source.q;
import com.scandit.datacapture.core.internal.module.source.w;
import com.scandit.datacapture.core.internal.sdk.source.NativeCameraFrameData;
import com.scandit.datacapture.core.source.CameraPosition;
import com.scandit.datacapture.core.source.CameraSettings;
import com.scandit.datacapture.core.source.FrameSourceState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class m
implements w {
    public final CameraManager a;
    public final b b;
    public final f c;

    public m(CameraManager cameraManager, b b2, f f2, int n2) {
        b b3 = c.a();
        Intrinsics.checkNotNullParameter((Object)cameraManager, (String)"cameraManager");
        af af2 = new af(cameraManager);
        Intrinsics.checkNotNullParameter((Object)cameraManager, (String)"cameraManager");
        Intrinsics.checkNotNullParameter((Object)b3, (String)"cameraProfile");
        Intrinsics.checkNotNullParameter((Object)af2, (String)"cameraInfoProvider");
        this.a = cameraManager;
        this.b = b3;
        this.c = af2;
    }

    @Override
    public final NativeCameraDelegate a(CameraPosition cameraPosition, CameraSettings cameraSettings, Function1<? super NativeCameraFrameData, Unit> function1, Function1<? super FrameSourceState, Unit> function12) {
        Intrinsics.checkNotNullParameter((Object)((Object)cameraPosition), (String)"position");
        Intrinsics.checkNotNullParameter(function1, (String)"frameCallback");
        Intrinsics.checkNotNullParameter(function12, (String)"errorCallback");
        CameraPosition cameraPosition2 = CameraPosition.UNSPECIFIED;
        boolean bl = cameraPosition != cameraPosition2;
        if (bl) {
            q q2;
            String string;
            Boolean bl2;
            Object object = cameraSettings != null ? cameraSettings.getProperty("cameraId") : null;
            if (!(object instanceof String)) {
                object = null;
            }
            if ((string = (String)object) != null) {
                Object object22;
                block12 : {
                    for (Object object22 : this.c.a()) {
                        if (!Intrinsics.areEqual((Object)((q)object22).a(), (Object)string)) continue;
                        break block12;
                    }
                    object22 = null;
                }
                q2 = (q)object22;
            } else {
                Object object32;
                block13 : {
                    int n2;
                    int n3 = n.a[cameraPosition.ordinal()];
                    if (n3 != 1) {
                        if (n3 != 2) {
                            if (n3 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            StringBuilder stringBuilder = new StringBuilder("Unsupported CameraPosition ");
                            stringBuilder.append((Object)cameraPosition2);
                            throw new AssertionError((Object)stringBuilder.toString());
                        }
                        n2 = 1;
                    } else {
                        n2 = 0;
                    }
                    for (Object object32 : this.c.a()) {
                        Integer n4 = ((q)object32).b();
                        boolean bl3 = n4 != null && n4 == n2;
                        if (!bl3) continue;
                        break block13;
                    }
                    object32 = null;
                }
                q2 = (q)object32;
            }
            if (q2 == null) {
                return null;
            }
            CameraManager cameraManager = this.a;
            b b2 = this.b;
            Object object4 = cameraSettings != null ? cameraSettings.getProperty("disableManualLensPositionSupportCheck") : null;
            if (!(object4 instanceof Boolean)) {
                object4 = null;
            }
            boolean bl4 = (bl2 = (Boolean)object4) != null ? bl2 : false;
            Object object5 = cameraSettings != null ? cameraSettings.getProperty("xcoverInitialLensPosition") : null;
            Object object6 = !(object5 instanceof Integer) ? null : object5;
            Integer n5 = (Integer)object6;
            int n6 = n5 != null ? n5 : 0;
            k k2 = new k(cameraManager, q2, b2, function1, function12, bl4, n6);
            return k2;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraManager
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.source;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.scandit.datacapture.core.internal.module.source.ae;
import com.scandit.datacapture.core.internal.module.source.f;
import com.scandit.datacapture.core.internal.module.source.q;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class af
implements f {
    public final CameraManager a;

    public af(CameraManager cameraManager) {
        Intrinsics.checkNotNullParameter((Object)cameraManager, (String)"cameraManager");
        this.a = cameraManager;
    }

    public final Iterable<q> a() {
        String[] arrstring = this.a.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue((Object)arrstring, (String)"cameraManager.cameraIdList");
        ArrayList arrayList = new ArrayList(arrstring.length);
        for (String string : arrstring) {
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"it");
            CameraCharacteristics cameraCharacteristics = this.a.getCameraCharacteristics(string);
            Intrinsics.checkNotNullExpressionValue((Object)cameraCharacteristics, (String)"cameraManager.getCameraCharacteristics(it)");
            arrayList.add((Object)new ae(string, cameraCharacteristics));
        }
        return arrayList;
    }
}


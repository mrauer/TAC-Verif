/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.core.source.FocusGestureStrategy;
import com.scandit.datacapture.core.source.VideoResolution;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

public final class CameraSettings {
    public final HashMap<String, Object> b;
    public VideoResolution e;
    public FocusGestureStrategy h;

    public CameraSettings() {
        VideoResolution videoResolution = VideoResolution.AUTO;
        FocusGestureStrategy focusGestureStrategy = FocusGestureStrategy.MANUAL_UNTIL_CAPTURE;
        this.e = videoResolution;
        this.h = focusGestureStrategy;
        this.b = new HashMap();
    }

    public final Float a(String string) {
        Float f2;
        Object object = this.b.get((Object)string);
        Object object2 = !(object instanceof Float) ? null : object;
        Object object3 = (Float)object2;
        if (object3 == null) {
            Object object4 = !(object instanceof Double) ? null : object;
            Double d2 = (Double)object4;
            object3 = d2 != null ? Float.valueOf((float)((float)d2.doubleValue())) : null;
        }
        if (object3 == null) {
            if (!(object instanceof Integer)) {
                object = null;
            }
            Integer n2 = (Integer)object;
            f2 = null;
            if (n2 != null) {
                return Float.valueOf((float)n2.intValue());
            }
        } else {
            f2 = object3;
        }
        return f2;
    }

    public final Object getProperty(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return this.b.get((Object)string);
    }
}


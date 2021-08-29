/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.source;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class CameraPosition
extends Enum<CameraPosition> {
    public static final /* enum */ CameraPosition UNSPECIFIED;
    public static final /* enum */ CameraPosition USER_FACING;
    public static final /* enum */ CameraPosition WORLD_FACING;
    private static final /* synthetic */ CameraPosition[] a;

    public static {
        CameraPosition cameraPosition;
        CameraPosition cameraPosition2;
        CameraPosition cameraPosition3;
        WORLD_FACING = cameraPosition2 = new CameraPosition();
        USER_FACING = cameraPosition3 = new CameraPosition();
        UNSPECIFIED = cameraPosition = new CameraPosition();
        a = new CameraPosition[]{cameraPosition2, cameraPosition3, cameraPosition};
    }

    public static CameraPosition valueOf(String string) {
        return (CameraPosition)Enum.valueOf(CameraPosition.class, (String)string);
    }

    public static CameraPosition[] values() {
        return (CameraPosition[])a.clone();
    }
}


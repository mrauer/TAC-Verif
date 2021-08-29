/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.source.CameraPosition;

public final class d {
    public static final /* synthetic */ int[] a;

    public static /* synthetic */ {
        CameraPosition.values();
        int[] arrn = new int[3];
        a = arrn;
        arrn[CameraPosition.USER_FACING.ordinal()] = 1;
        arrn[CameraPosition.WORLD_FACING.ordinal()] = 2;
        arrn[CameraPosition.UNSPECIFIED.ordinal()] = 3;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.g;

import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.source.NativeCameraApi;

public final class a
extends d {
    public static final a a = new a();
    public static final String b = "algiz_rt8";

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final NativeCameraApi c() {
        return NativeCameraApi.CAMERA2;
    }
}


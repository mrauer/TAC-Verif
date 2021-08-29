/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.e;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

public final class a {
    public static final void a(Exception exception) {
        Intrinsics.checkNotNullParameter((Object)((Object)exception), (String)"e");
        exception.printStackTrace();
    }

    public static final void a(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Log.e((String)"sdc-core", (String)string);
    }

    public static final void a(String string, Exception exception) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Intrinsics.checkNotNullParameter((Object)((Object)exception), (String)"e");
        Log.e((String)"sdc-core", (String)string);
        exception.printStackTrace();
    }

    public static final void b(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Log.i((String)"sdc-core", (String)string);
    }
}


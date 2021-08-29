/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt__IndentKt
 */
package com.scandit.datacapture.core.internal.module.b.a.a.a;

import android.hardware.Camera;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

public class a
extends d {
    public final String a = ".*";

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public void a(Camera.Parameters parameters, float f2, float f3) {
        Intrinsics.checkNotNullParameter((Object)parameters, (String)"camParams");
        this.b(parameters, Math.max((float)this.b().d, (float)f3));
        String string = parameters.get("min-sharpness");
        Integer n2 = string != null ? StringsKt__IndentKt.toIntOrNull((String)string) : null;
        String string2 = parameters.get("max-sharpness");
        Integer n3 = null;
        if (string2 != null) {
            n3 = StringsKt__IndentKt.toIntOrNull((String)string2);
        }
        if (n2 == null || n3 == null || n2 <= 0 && n3 >= 0) {
            parameters.set("sharpness", "0");
        }
        if (this.b().g) {
            d.a(parameters, f2);
            return;
        }
        d.a(parameters, f2, false);
    }
}


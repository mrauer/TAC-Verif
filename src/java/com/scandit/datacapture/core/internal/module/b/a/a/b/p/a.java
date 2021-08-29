/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.p;

import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;

public final class a
extends com.scandit.datacapture.core.internal.module.b.a.a.a.a {
    public static final a a;
    public static final String b;
    public static final e c;

    public static {
        a a2;
        a = a2 = new a();
        b = "scandit-default-continuous-custom_metering_disabled.*";
        c = e.a(((d)a2).b, false, false, false, 0.0f, true, false, false, 109);
    }

    @Override
    public final String a() {
        return b;
    }

    @Override
    public final e b() {
        return c;
    }
}


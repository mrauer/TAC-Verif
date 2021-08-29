/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.b.a.a.b.p;

import com.scandit.datacapture.core.internal.module.b.a.a.a.a;
import com.scandit.datacapture.core.internal.module.b.a.a.d;
import com.scandit.datacapture.core.internal.module.b.a.a.e;

public final class b
extends a {
    public static final b a;
    public static final String b;
    public static final e c;

    public static {
        b b2;
        a = b2 = new b();
        b = "scandit-default-continuous.*";
        c = e.a(((d)b2).b, false, false, false, 0.0f, false, false, false, 125);
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


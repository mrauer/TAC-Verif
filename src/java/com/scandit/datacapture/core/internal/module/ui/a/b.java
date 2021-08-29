/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.a;

import com.scandit.datacapture.core.internal.module.ui.a.d;
import com.scandit.datacapture.core.internal.module.ui.a.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class b
implements d {
    @Override
    public final boolean a(e.b b2, List<? extends e.a> list) {
        Intrinsics.checkNotNullParameter((Object)((Object)b2), (String)"state");
        Intrinsics.checkNotNullParameter(list, (String)"operations");
        return b2 == e.b.a && true ^ list.isEmpty();
    }

    @Override
    public final boolean b(e.b b2, List<? extends e.a> list) {
        Intrinsics.checkNotNullParameter((Object)((Object)b2), (String)"state");
        Intrinsics.checkNotNullParameter(list, (String)"operations");
        return b2 == e.b.b && true ^ list.isEmpty();
    }
}


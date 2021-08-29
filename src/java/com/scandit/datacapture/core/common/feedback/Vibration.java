/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.common.feedback;

import com.scandit.datacapture.core.time.TimeInterval;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Vibration {
    public final TimeInterval a = new TimeInterval(0.001f * (float)300L, null);

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Vibration)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.a, (Object)((Vibration)object).a);
    }

    public final int hashCode() {
        return 31 * this.a.hashCode() + this.a.hashCode();
    }
}


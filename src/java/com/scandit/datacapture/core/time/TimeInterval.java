/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.time;

import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class TimeInterval {
    public final float a;

    public TimeInterval(float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = f2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Class class_ = object != null ? object.getClass() : null;
        if (true ^ Intrinsics.areEqual(TimeInterval.class, (Object)class_)) {
            return false;
        }
        Objects.requireNonNull((Object)object, (String)"null cannot be cast to non-null type com.scandit.datacapture.core.time.TimeInterval");
        return this.a == ((TimeInterval)object).a;
    }

    public final int hashCode() {
        return Float.valueOf((float)this.a).hashCode();
    }
}


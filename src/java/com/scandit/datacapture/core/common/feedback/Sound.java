/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.Objects
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.common.feedback;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

public class Sound {
    public final int a;

    public Sound(int n2) {
        this.a = n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Sound)) {
            return false;
        }
        int n2 = this.a;
        Sound sound = (Sound)object;
        if (n2 == sound.a) {
            Objects.requireNonNull((Object)sound);
            if (Intrinsics.areEqual(null, null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return 0 + 31 * this.a;
    }
}


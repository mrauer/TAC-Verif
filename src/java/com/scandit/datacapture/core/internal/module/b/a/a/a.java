/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.b.a.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.jvm.internal.Intrinsics;

public final class a {
    public final String a;
    public final String b;
    public final String c;

    public a() {
        this("continuous-picture", "continuous-video", "auto");
    }

    public a(String string, String string2, String string3) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"focusModeContinuousPicture");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"focusModeContinuousVideo");
        Intrinsics.checkNotNullParameter((Object)string3, (String)"focusModeAuto");
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof a)) break block3;
                a a2 = (a)object;
                if (Intrinsics.areEqual((Object)this.a, (Object)a2.a) && Intrinsics.areEqual((Object)this.b, (Object)a2.b) && Intrinsics.areEqual((Object)this.c, (Object)a2.c)) break block2;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String string = this.a;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.b;
        int n4 = string2 != null ? string2.hashCode() : 0;
        int n5 = 31 * (n3 + n4);
        String string3 = this.c;
        int n6 = 0;
        if (string3 != null) {
            n6 = string3.hashCode();
        }
        return n5 + n6;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("CameraParametersKeys(focusModeContinuousPicture=");
        stringBuilder.append(this.a);
        stringBuilder.append(", focusModeContinuousVideo=");
        stringBuilder.append(this.b);
        stringBuilder.append(", focusModeAuto=");
        return GeneratedOutlineSupport.outline21((StringBuilder)stringBuilder, (String)this.c, (String)")");
    }
}


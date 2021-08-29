/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.b.a.a;

public final class e {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public e() {
        this(false, false, false, 0.0f, false, false, false, 127);
    }

    public e(boolean bl, boolean bl2, boolean bl3, float f2, boolean bl4, boolean bl5, boolean bl6) {
        this.a = bl;
        this.b = bl2;
        this.c = bl3;
        this.d = f2;
        this.e = bl4;
        this.f = bl5;
        this.g = bl6;
    }

    public e(boolean bl, boolean bl2, boolean bl3, float f2, boolean bl4, boolean bl5, boolean bl6, int n2) {
        this.a = false;
        this.b = true;
        this.c = true;
        this.d = 0.0f;
        this.e = false;
        this.f = false;
        this.g = false;
    }

    public static /* synthetic */ e a(e e2, boolean bl, boolean bl2, boolean bl3, float f2, boolean bl4, boolean bl5, boolean bl6, int n2) {
        boolean bl7 = (n2 & 1) != 0 ? e2.a : bl;
        boolean bl8 = (n2 & 2) != 0 ? e2.b : bl2;
        boolean bl9 = (n2 & 4) != 0 ? e2.c : bl3;
        float f3 = (n2 & 8) != 0 ? e2.d : f2;
        boolean bl10 = (n2 & 16) != 0 ? e2.e : bl4;
        boolean bl11 = (n2 & 32) != 0 ? e2.f : bl5;
        boolean bl12 = (n2 & 64) != 0 ? e2.g : bl6;
        e e3 = new e(bl7, bl8, bl9, f3, bl10, bl11, bl12);
        return e3;
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof e)) break block3;
                e e2 = (e)object;
                if (this.a == e2.a && this.b == e2.b && this.c == e2.c && Float.compare((float)this.d, (float)e2.d) == 0 && this.e == e2.e && this.f == e2.f && this.g == e2.g) break block2;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int n2 = this.a;
        int n3 = 1;
        if (n2 != 0) {
            n2 = n3;
        }
        int n4 = n2 * 31;
        int n5 = this.b;
        if (n5 != 0) {
            n5 = n3;
        }
        int n6 = 31 * (n4 + n5);
        int n7 = this.c;
        if (n7 != 0) {
            n7 = n3;
        }
        int n8 = 31 * (31 * (n6 + n7) + Float.floatToIntBits((float)this.d));
        int n9 = this.e;
        if (n9 != 0) {
            n9 = n3;
        }
        int n10 = 31 * (n8 + n9);
        int n11 = this.f;
        if (n11 != 0) {
            n11 = n3;
        }
        int n12 = 31 * (n10 + n11);
        boolean bl = this.g;
        if (!bl) {
            n3 = bl ? 1 : 0;
        }
        return n12 + n3;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Settings(disableTorch=");
        stringBuilder.append(this.a);
        stringBuilder.append(", disableContinuous=");
        stringBuilder.append(this.b);
        stringBuilder.append(", disableMacro=");
        stringBuilder.append(this.c);
        stringBuilder.append(", minExposureTargetBias=");
        stringBuilder.append(this.d);
        stringBuilder.append(", disableCustomMeteringAndFocusArea=");
        stringBuilder.append(this.e);
        stringBuilder.append(", hasBrokenFullCropZoom=");
        stringBuilder.append(this.f);
        stringBuilder.append(", useFpsRangeWithBiggestSpread=");
        stringBuilder.append(this.g);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class ViewSize {
    public final int a;
    public final int b;

    public ViewSize(int n2, int n3) {
        this.a = n2;
        this.b = n3;
    }

    public final boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof ViewSize)) break block3;
                ViewSize viewSize = (ViewSize)object;
                if (this.a == viewSize.a && this.b == viewSize.b) break block2;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 31 * this.a + this.b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewSize(x=");
        stringBuilder.append(this.a);
        stringBuilder.append(", y=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.b, (String)")");
    }
}


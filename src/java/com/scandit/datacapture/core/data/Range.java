/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class Range {
    public final int maximum;
    public final int minimum;
    public final int step;

    public Range(int n2, int n3, int n4) {
        this.minimum = n2;
        this.maximum = n3;
        this.step = n4;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Range)) {
            return false;
        }
        Range range = (Range)object;
        return this.minimum == range.minimum && this.maximum == range.maximum && this.step == range.step;
    }

    public final int getMaximum() {
        return this.maximum;
    }

    public final int getMinimum() {
        return this.minimum;
    }

    public final int getStep() {
        return this.step;
    }

    public final int hashCode() {
        return 31 * (31 * (527 + this.minimum) + this.maximum) + this.step;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Range{minimum=");
        stringBuilder.append(this.minimum);
        stringBuilder.append(",maximum=");
        stringBuilder.append(this.maximum);
        stringBuilder.append(",step=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.step, (String)"}");
    }
}


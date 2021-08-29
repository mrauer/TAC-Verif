/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.common.buffer;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class EncodingRange {
    public final int endIndex;
    public final String ianaName;
    public final int startIndex;

    public EncodingRange(String string, int n2, int n3) {
        this.ianaName = string;
        this.startIndex = n2;
        this.endIndex = n3;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof EncodingRange)) {
            return false;
        }
        EncodingRange encodingRange = (EncodingRange)object;
        return this.ianaName.equals((Object)encodingRange.ianaName) && this.startIndex == encodingRange.startIndex && this.endIndex == encodingRange.endIndex;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final String getIanaName() {
        return this.ianaName;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int hashCode() {
        return 31 * (GeneratedOutlineSupport.outline3((String)this.ianaName, (int)527, (int)31) + this.startIndex) + this.endIndex;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("EncodingRange{ianaName=");
        stringBuilder.append(this.ianaName);
        stringBuilder.append(",startIndex=");
        stringBuilder.append(this.startIndex);
        stringBuilder.append(",endIndex=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.endIndex, (String)"}");
    }
}


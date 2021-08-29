/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.sdk.common.graphics;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeTextureBinding {
    public final int target;
    public final int texture;

    public NativeTextureBinding(int n2, int n3) {
        this.target = n2;
        this.texture = n3;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeTextureBinding)) {
            return false;
        }
        NativeTextureBinding nativeTextureBinding = (NativeTextureBinding)object;
        return this.target == nativeTextureBinding.target && this.texture == nativeTextureBinding.texture;
    }

    public final int getTarget() {
        return this.target;
    }

    public final int getTexture() {
        return this.texture;
    }

    public final int hashCode() {
        return 31 * (527 + this.target) + this.texture;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeTextureBinding{target=");
        stringBuilder.append(this.target);
        stringBuilder.append(",texture=");
        return GeneratedOutlineSupport.outline20((StringBuilder)stringBuilder, (int)this.texture, (String)"}");
    }
}


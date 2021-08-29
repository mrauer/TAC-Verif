/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.sdk.ocr;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public final class NativeTextRecognizerSettings {
    public final String charWhiteList;
    public final ArrayList<String> fonts;
    public final float maximumLineHeight;
    public final float minimumLineHeight;

    public NativeTextRecognizerSettings(String string, ArrayList<String> arrayList, float f2, float f3) {
        this.charWhiteList = string;
        this.fonts = arrayList;
        this.minimumLineHeight = f2;
        this.maximumLineHeight = f3;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof NativeTextRecognizerSettings)) {
            return false;
        }
        NativeTextRecognizerSettings nativeTextRecognizerSettings = (NativeTextRecognizerSettings)object;
        return this.charWhiteList.equals((Object)nativeTextRecognizerSettings.charWhiteList) && this.fonts.equals(nativeTextRecognizerSettings.fonts) && this.minimumLineHeight == nativeTextRecognizerSettings.minimumLineHeight && this.maximumLineHeight == nativeTextRecognizerSettings.maximumLineHeight;
    }

    public final String getCharWhiteList() {
        return this.charWhiteList;
    }

    public final ArrayList<String> getFonts() {
        return this.fonts;
    }

    public final float getMaximumLineHeight() {
        return this.maximumLineHeight;
    }

    public final float getMinimumLineHeight() {
        return this.minimumLineHeight;
    }

    public final int hashCode() {
        return 31 * (31 * (GeneratedOutlineSupport.outline3((String)this.charWhiteList, (int)527, (int)31) + this.fonts.hashCode()) + Float.floatToIntBits((float)this.minimumLineHeight)) + Float.floatToIntBits((float)this.maximumLineHeight);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeTextRecognizerSettings{charWhiteList=");
        stringBuilder.append(this.charWhiteList);
        stringBuilder.append(",fonts=");
        stringBuilder.append(this.fonts);
        stringBuilder.append(",minimumLineHeight=");
        stringBuilder.append(this.minimumLineHeight);
        stringBuilder.append(",maximumLineHeight=");
        stringBuilder.append(this.maximumLineHeight);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


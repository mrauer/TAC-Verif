/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.json;

import com.scandit.datacapture.core.common.geometry.FloatWithUnit;
import com.scandit.datacapture.core.common.geometry.MarginsWithUnit;
import com.scandit.datacapture.core.common.geometry.PointWithUnit;
import com.scandit.datacapture.core.internal.sdk.common.graphics.NativeColor;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.internal.sdk.ui.style.NativeBrush;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeJsonValue {
    public NativeJsonValue() {
    }

    public static NativeJsonValue fromString(String string) {
        return CppProxy.fromString((String)string);
    }

    public abstract NativeJsonValue asArray();

    public abstract boolean asBool();

    public abstract NativeBrush asBrush();

    public abstract NativeColor asColor();

    public abstract double asDouble();

    public abstract float asFloat();

    public abstract FloatWithUnit asFloatWithUnit();

    public abstract int asInt();

    public abstract MarginsWithUnit asMarginsWithUnit();

    public abstract NativeJsonValue asObject();

    public abstract PointWithUnit asPointWithUnit();

    public abstract String asString();

    public abstract boolean contains(String var1);

    public abstract String getAbsolutePath();

    public abstract NativeJsonValue getArrayForKey(String var1);

    public abstract NativeJsonValue getArrayForKeyOrDefault(String var1, NativeJsonValue var2);

    public abstract boolean getBoolForKey(String var1);

    public abstract boolean getBoolForKeyOrDefault(String var1, boolean var2);

    public abstract NativeBrush getBrushForKey(String var1);

    public abstract NativeBrush getBrushForKeyOrDefault(String var1, NativeBrush var2);

    public abstract NativeColor getColorForKey(String var1);

    public abstract NativeColor getColorForKeyOrDefault(String var1, NativeColor var2);

    public abstract double getDoubleForKey(String var1);

    public abstract double getDoubleForKeyOrDefault(String var1, double var2);

    public abstract float getFloatForKey(String var1);

    public abstract float getFloatForKeyOrDefault(String var1, float var2);

    public abstract FloatWithUnit getFloatWithUnitForKey(String var1);

    public abstract FloatWithUnit getFloatWithUnitForKeyOrDefault(String var1, FloatWithUnit var2);

    public abstract NativeJsonValue getForIndex(int var1);

    public abstract NativeJsonValue getForKey(String var1);

    public abstract int getIntForKey(String var1);

    public abstract int getIntForKeyOrDefault(String var1, int var2);

    public abstract MarginsWithUnit getMarginsWithUnitForKey(String var1);

    public abstract MarginsWithUnit getMarginsWithUnitForKeyOrDefault(String var1, MarginsWithUnit var2);

    public abstract NativeJsonValue getObjectForKey(String var1);

    public abstract NativeJsonValue getObjectForKeyOrDefault(String var1, NativeJsonValue var2);

    public abstract PointWithUnit getPointWithUnitForKey(String var1);

    public abstract PointWithUnit getPointWithUnitForKeyOrDefault(String var1, PointWithUnit var2);

    public abstract String getStringForKey(String var1);

    public abstract String getStringForKeyOrDefault(String var1, String var2);

    public abstract boolean isArray();

    public abstract boolean isBool();

    public abstract boolean isInt();

    public abstract boolean isNumeric();

    public abstract boolean isObject();

    public abstract boolean isString();

    public abstract boolean isUsed();

    public abstract void setUsed(boolean var1);

    public abstract long size();

    public abstract String toString();
}


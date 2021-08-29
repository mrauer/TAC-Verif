/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.internal.module.source.NativeFocusSettings;
import com.scandit.datacapture.core.internal.module.source.NativeNoiseReduction;
import com.scandit.datacapture.core.internal.module.source.NativeRegionStrategy;
import com.scandit.datacapture.core.internal.module.source.NativeTonemapCurve;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.core.source.VideoResolution;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeCameraSettings {
    public final int api;
    public final boolean colorCorrection;
    public final float exposureTargetBias;
    public final NativeFocusSettings focus;
    public final float maxFrameRate;
    public final float minFrameRate;
    public final NativeNoiseReduction noiseReductionMode;
    public final boolean overwriteWithHighestResolution;
    public final VideoResolution preferredResolution;
    public final NativeJsonValue properties;
    public final NativeRegionStrategy regionControlStrategy;
    public final NativeTonemapCurve toneMappingCurve;
    public final float torchLevel;
    public final float zoomFactor;
    public final float zoomGestureZoomFactor;

    public NativeCameraSettings(VideoResolution videoResolution, float f2, float f3, float f4, float f5, NativeFocusSettings nativeFocusSettings, int n2, boolean bl, float f6, boolean bl2, NativeTonemapCurve nativeTonemapCurve, NativeNoiseReduction nativeNoiseReduction, NativeRegionStrategy nativeRegionStrategy, float f7, NativeJsonValue nativeJsonValue) {
        this.preferredResolution = videoResolution;
        this.minFrameRate = f2;
        this.maxFrameRate = f3;
        this.zoomFactor = f4;
        this.zoomGestureZoomFactor = f5;
        this.focus = nativeFocusSettings;
        this.api = n2;
        this.overwriteWithHighestResolution = bl;
        this.exposureTargetBias = f6;
        this.colorCorrection = bl2;
        this.toneMappingCurve = nativeTonemapCurve;
        this.noiseReductionMode = nativeNoiseReduction;
        this.regionControlStrategy = nativeRegionStrategy;
        this.torchLevel = f7;
        this.properties = nativeJsonValue;
    }

    public final boolean equals(Object object) {
        NativeJsonValue nativeJsonValue;
        if (!(object instanceof NativeCameraSettings)) {
            return false;
        }
        NativeCameraSettings nativeCameraSettings = (NativeCameraSettings)object;
        return this.preferredResolution == nativeCameraSettings.preferredResolution && this.minFrameRate == nativeCameraSettings.minFrameRate && this.maxFrameRate == nativeCameraSettings.maxFrameRate && this.zoomFactor == nativeCameraSettings.zoomFactor && this.zoomGestureZoomFactor == nativeCameraSettings.zoomGestureZoomFactor && this.focus.equals(nativeCameraSettings.focus) && this.api == nativeCameraSettings.api && this.overwriteWithHighestResolution == nativeCameraSettings.overwriteWithHighestResolution && this.exposureTargetBias == nativeCameraSettings.exposureTargetBias && this.colorCorrection == nativeCameraSettings.colorCorrection && this.toneMappingCurve == nativeCameraSettings.toneMappingCurve && this.noiseReductionMode == nativeCameraSettings.noiseReductionMode && this.regionControlStrategy == nativeCameraSettings.regionControlStrategy && this.torchLevel == nativeCameraSettings.torchLevel && ((nativeJsonValue = this.properties) == null && nativeCameraSettings.properties == null || nativeJsonValue != null && nativeJsonValue.equals((Object)nativeCameraSettings.properties));
    }

    public final int getApi() {
        return this.api;
    }

    public final boolean getColorCorrection() {
        return this.colorCorrection;
    }

    public final float getExposureTargetBias() {
        return this.exposureTargetBias;
    }

    public final NativeFocusSettings getFocus() {
        return this.focus;
    }

    public final float getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public final float getMinFrameRate() {
        return this.minFrameRate;
    }

    public final NativeNoiseReduction getNoiseReductionMode() {
        return this.noiseReductionMode;
    }

    public final boolean getOverwriteWithHighestResolution() {
        return this.overwriteWithHighestResolution;
    }

    public final VideoResolution getPreferredResolution() {
        return this.preferredResolution;
    }

    public final NativeJsonValue getProperties() {
        return this.properties;
    }

    public final NativeRegionStrategy getRegionControlStrategy() {
        return this.regionControlStrategy;
    }

    public final NativeTonemapCurve getToneMappingCurve() {
        return this.toneMappingCurve;
    }

    public final float getTorchLevel() {
        return this.torchLevel;
    }

    public final float getZoomFactor() {
        return this.zoomFactor;
    }

    public final float getZoomGestureZoomFactor() {
        return this.zoomGestureZoomFactor;
    }

    public final int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + this.preferredResolution.hashCode()) + Float.floatToIntBits((float)this.minFrameRate)) + Float.floatToIntBits((float)this.maxFrameRate)) + Float.floatToIntBits((float)this.zoomFactor)) + Float.floatToIntBits((float)this.zoomGestureZoomFactor)) + this.focus.hashCode()) + this.api) + this.overwriteWithHighestResolution) + Float.floatToIntBits((float)this.exposureTargetBias)) + this.colorCorrection) + this.toneMappingCurve.hashCode()) + this.noiseReductionMode.hashCode()) + this.regionControlStrategy.hashCode()) + Float.floatToIntBits((float)this.torchLevel));
        NativeJsonValue nativeJsonValue = this.properties;
        int n3 = nativeJsonValue == null ? 0 : nativeJsonValue.hashCode();
        return n2 + n3;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeCameraSettings{preferredResolution=");
        stringBuilder.append((Object)this.preferredResolution);
        stringBuilder.append(",minFrameRate=");
        stringBuilder.append(this.minFrameRate);
        stringBuilder.append(",maxFrameRate=");
        stringBuilder.append(this.maxFrameRate);
        stringBuilder.append(",zoomFactor=");
        stringBuilder.append(this.zoomFactor);
        stringBuilder.append(",zoomGestureZoomFactor=");
        stringBuilder.append(this.zoomGestureZoomFactor);
        stringBuilder.append(",focus=");
        stringBuilder.append((Object)this.focus);
        stringBuilder.append(",api=");
        stringBuilder.append(this.api);
        stringBuilder.append(",overwriteWithHighestResolution=");
        stringBuilder.append(this.overwriteWithHighestResolution);
        stringBuilder.append(",exposureTargetBias=");
        stringBuilder.append(this.exposureTargetBias);
        stringBuilder.append(",colorCorrection=");
        stringBuilder.append(this.colorCorrection);
        stringBuilder.append(",toneMappingCurve=");
        stringBuilder.append((Object)this.toneMappingCurve);
        stringBuilder.append(",noiseReductionMode=");
        stringBuilder.append((Object)this.noiseReductionMode);
        stringBuilder.append(",regionControlStrategy=");
        stringBuilder.append((Object)this.regionControlStrategy);
        stringBuilder.append(",torchLevel=");
        stringBuilder.append(this.torchLevel);
        stringBuilder.append(",properties=");
        stringBuilder.append((Object)this.properties);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


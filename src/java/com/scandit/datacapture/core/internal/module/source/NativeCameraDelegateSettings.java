/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.scandit.datacapture.core.internal.module.source;

import com.scandit.datacapture.core.common.geometry.Size2;
import com.scandit.datacapture.core.internal.module.source.NativeEdgeEnhancement;
import com.scandit.datacapture.core.internal.module.source.NativeMacroAfMode;
import com.scandit.datacapture.core.internal.module.source.NativeNoiseReduction;
import com.scandit.datacapture.core.internal.module.source.NativeTonemapCurve;
import com.scandit.datacapture.core.source.TorchState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public final class NativeCameraDelegateSettings {
    public final boolean colorCorrection;
    public final NativeEdgeEnhancement edgeEnhancementMode;
    public final long exposureDuration;
    public final float exposureTargetBias;
    public final long frameDuration;
    public final Size2 frameResolution;
    public final NativeMacroAfMode macroAutofocusMode;
    public final float maxFrameRate;
    public final float minFrameRate;
    public final NativeNoiseReduction noiseReductionMode;
    public final boolean sceneChangeDetection;
    public final NativeTonemapCurve toneMappingCurve;
    public final TorchState torchState;
    public final boolean zoomAffectsMeteringArea;
    public final float zoomFactor;

    public NativeCameraDelegateSettings(Size2 size2, float f2, float f3, float f4, float f5, NativeEdgeEnhancement nativeEdgeEnhancement, boolean bl, TorchState torchState, NativeTonemapCurve nativeTonemapCurve, NativeNoiseReduction nativeNoiseReduction, boolean bl2, NativeMacroAfMode nativeMacroAfMode, boolean bl3, long l2, long l3) {
        this.frameResolution = size2;
        this.minFrameRate = f2;
        this.maxFrameRate = f3;
        this.zoomFactor = f4;
        this.exposureTargetBias = f5;
        this.edgeEnhancementMode = nativeEdgeEnhancement;
        this.colorCorrection = bl;
        this.torchState = torchState;
        this.toneMappingCurve = nativeTonemapCurve;
        this.noiseReductionMode = nativeNoiseReduction;
        this.zoomAffectsMeteringArea = bl2;
        this.macroAutofocusMode = nativeMacroAfMode;
        this.sceneChangeDetection = bl3;
        this.exposureDuration = l2;
        this.frameDuration = l3;
    }

    public final boolean getColorCorrection() {
        return this.colorCorrection;
    }

    public final NativeEdgeEnhancement getEdgeEnhancementMode() {
        return this.edgeEnhancementMode;
    }

    public final long getExposureDuration() {
        return this.exposureDuration;
    }

    public final float getExposureTargetBias() {
        return this.exposureTargetBias;
    }

    public final long getFrameDuration() {
        return this.frameDuration;
    }

    public final Size2 getFrameResolution() {
        return this.frameResolution;
    }

    public final NativeMacroAfMode getMacroAutofocusMode() {
        return this.macroAutofocusMode;
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

    public final boolean getSceneChangeDetection() {
        return this.sceneChangeDetection;
    }

    public final NativeTonemapCurve getToneMappingCurve() {
        return this.toneMappingCurve;
    }

    public final TorchState getTorchState() {
        return this.torchState;
    }

    public final boolean getZoomAffectsMeteringArea() {
        return this.zoomAffectsMeteringArea;
    }

    public final float getZoomFactor() {
        return this.zoomFactor;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NativeCameraDelegateSettings{frameResolution=");
        stringBuilder.append((Object)this.frameResolution);
        stringBuilder.append(",minFrameRate=");
        stringBuilder.append(this.minFrameRate);
        stringBuilder.append(",maxFrameRate=");
        stringBuilder.append(this.maxFrameRate);
        stringBuilder.append(",zoomFactor=");
        stringBuilder.append(this.zoomFactor);
        stringBuilder.append(",exposureTargetBias=");
        stringBuilder.append(this.exposureTargetBias);
        stringBuilder.append(",edgeEnhancementMode=");
        stringBuilder.append((Object)this.edgeEnhancementMode);
        stringBuilder.append(",colorCorrection=");
        stringBuilder.append(this.colorCorrection);
        stringBuilder.append(",torchState=");
        stringBuilder.append((Object)this.torchState);
        stringBuilder.append(",toneMappingCurve=");
        stringBuilder.append((Object)this.toneMappingCurve);
        stringBuilder.append(",noiseReductionMode=");
        stringBuilder.append((Object)this.noiseReductionMode);
        stringBuilder.append(",zoomAffectsMeteringArea=");
        stringBuilder.append(this.zoomAffectsMeteringArea);
        stringBuilder.append(",macroAutofocusMode=");
        stringBuilder.append((Object)this.macroAutofocusMode);
        stringBuilder.append(",sceneChangeDetection=");
        stringBuilder.append(this.sceneChangeDetection);
        stringBuilder.append(",exposureDuration=");
        stringBuilder.append(this.exposureDuration);
        stringBuilder.append(",frameDuration=");
        stringBuilder.append(this.frameDuration);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}


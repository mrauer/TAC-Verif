/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.sdk.ocr;

import com.scandit.datacapture.core.common.Direction;
import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.internal.sdk.common.geometry.NativeImageBuffer;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.ocr.NativeExternalOcrBackendResult;
import com.scandit.datacapture.core.internal.sdk.ocr.NativeTextRecognizerSettings;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeExternalOcrBackend {
    public abstract String getLastErrorMessage();

    public abstract ArrayList<NativeExternalOcrBackendResult> getLastResults();

    public abstract String getName();

    public abstract String getSpecificData(String var1);

    public abstract void onBeforeNextFrame(NativeFrameData var1);

    public abstract boolean processFrame(NativeImageBuffer var1);

    public abstract void setRecognitionArea(Rect var1, Direction var2);

    public abstract void updateSettings(NativeTextRecognizerSettings var1);
}


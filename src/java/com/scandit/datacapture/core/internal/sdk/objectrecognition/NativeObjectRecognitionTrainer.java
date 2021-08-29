/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.objectrecognition.NativeObjectRecognitionTrainer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.objectrecognition;

import com.scandit.datacapture.core.common.geometry.Rect;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.data.NativeFrameData;
import com.scandit.datacapture.core.internal.sdk.objectrecognition.NativeObjectRecognitionTrainer;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeObjectRecognitionTrainer {
    public NativeObjectRecognitionTrainer() {
    }

    public static NativeObjectRecognitionTrainer create(NativeDataCaptureContext nativeDataCaptureContext) {
        return CppProxy.create((NativeDataCaptureContext)nativeDataCaptureContext);
    }

    public abstract void addTrainingImage(NativeFrameData var1, Rect var2, String var3);

    public abstract void removeAllTrainingImages();

    public abstract void resetDefaultTrainingImages();

    public abstract void train();
}


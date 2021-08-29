/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializer$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureModeDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializerHelper;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializerListener;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataCaptureViewDeserializer {
    public NativeDataCaptureViewDeserializer() {
    }

    public static NativeDataCaptureViewDeserializer create(ArrayList<NativeDataCaptureModeDeserializer> arrayList) {
        return CppProxy.create(arrayList);
    }

    public abstract ArrayList<String> getWarnings();

    public abstract void setHelper(NativeDataCaptureViewDeserializerHelper var1);

    public abstract void setListener(NativeDataCaptureViewDeserializerListener var1);

    public abstract NativeDataCaptureView updateViewFromJson(NativeDataCaptureView var1, NativeJsonValue var2);

    public abstract NativeDataCaptureView viewFromJson(NativeDataCaptureContext var1, NativeJsonValue var2);
}


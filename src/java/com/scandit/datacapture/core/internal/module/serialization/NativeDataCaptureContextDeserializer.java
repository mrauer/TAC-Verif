/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializer$CppProxy
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureComponentDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializerHelper;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializerListener;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureContextDeserializerResult;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureModeDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeDataCaptureViewDeserializer;
import com.scandit.datacapture.core.internal.module.serialization.NativeFrameSourceDeserializer;
import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.component.NativeDataCaptureComponent;
import com.scandit.datacapture.core.internal.sdk.json.NativeJsonValue;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataCaptureContextDeserializer {
    public NativeDataCaptureContextDeserializer() {
    }

    public static NativeDataCaptureContextDeserializer create(NativeFrameSourceDeserializer nativeFrameSourceDeserializer, NativeDataCaptureViewDeserializer nativeDataCaptureViewDeserializer, ArrayList<NativeDataCaptureModeDeserializer> arrayList, ArrayList<NativeDataCaptureComponentDeserializer> arrayList2) {
        return CppProxy.create((NativeFrameSourceDeserializer)nativeFrameSourceDeserializer, (NativeDataCaptureViewDeserializer)nativeDataCaptureViewDeserializer, arrayList, arrayList2);
    }

    public abstract NativeDataCaptureContextDeserializerResult contextFromJson(NativeJsonValue var1);

    public abstract boolean getAvoidThreadDependencies();

    public abstract void setAvoidThreadDependencies(boolean var1);

    public abstract void setHelper(NativeDataCaptureContextDeserializerHelper var1);

    public abstract void setListener(NativeDataCaptureContextDeserializerListener var1);

    public abstract NativeDataCaptureContextDeserializerResult updateContextFromJson(NativeDataCaptureContext var1, NativeDataCaptureView var2, ArrayList<NativeDataCaptureComponent> var3, NativeJsonValue var4);
}


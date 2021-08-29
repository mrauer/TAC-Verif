/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.serialization;

import com.scandit.datacapture.core.internal.module.ui.NativeDataCaptureView;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.component.NativeDataCaptureComponent;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeDataCaptureContextDeserializerResult {
    public abstract ArrayList<NativeDataCaptureComponent> getComponents();

    public abstract NativeDataCaptureContext getContext();

    public abstract NativeDataCaptureView getView();

    public abstract ArrayList<String> getWarnings();
}


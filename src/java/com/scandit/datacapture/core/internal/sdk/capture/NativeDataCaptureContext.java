/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext$CppProxy
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.common.geometry.SizeWithUnit;
import com.scandit.datacapture.core.internal.module.capture.NativeRecognitionContextSettings;
import com.scandit.datacapture.core.internal.module.source.NativeFrameSource;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContext;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextFrameListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextListener;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureMode;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFeatureAvailability;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFrameOfReference;
import com.scandit.datacapture.core.internal.sdk.capture.NativeLicenseInfo;
import com.scandit.datacapture.core.internal.sdk.capture.NativeLicensedFeature;
import com.scandit.datacapture.core.internal.sdk.capture.NativeResourceLoader;
import com.scandit.datacapture.core.internal.sdk.common.async.NativeWrappedFuture;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataCaptureContext {
    public NativeDataCaptureContext() {
    }

    public static NativeDataCaptureContext createWithDeviceName(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, ArrayList<String> arrayList, NativeResourceLoader nativeResourceLoader, boolean bl, NativeDataCaptureContextSettings nativeDataCaptureContextSettings) {
        return CppProxy.createWithDeviceName((String)string, (String)string2, (String)string3, (String)string4, (String)string5, (String)string6, (String)string7, (String)string8, (String)string9, (String)string10, arrayList, (NativeResourceLoader)nativeResourceLoader, (boolean)bl, (NativeDataCaptureContextSettings)nativeDataCaptureContextSettings);
    }

    public static String getEngineCommitHash() {
        return CppProxy.getEngineCommitHash();
    }

    public static String getEngineVersionNumber() {
        return CppProxy.getEngineVersionNumber();
    }

    public static int getListenerPriorityPlatform() {
        return CppProxy.getListenerPriorityPlatform();
    }

    public static int getListenerPriorityUser() {
        return CppProxy.getListenerPriorityUser();
    }

    public static String getVersion() {
        return CppProxy.getVersion();
    }

    public abstract void addFrameListenerAsync(NativeDataCaptureContextFrameListener var1);

    public abstract void addListenerAsync(NativeDataCaptureContextListener var1, int var2);

    public abstract NativeWrappedFuture addModeAsyncWrapped(NativeDataCaptureMode var1);

    public abstract void applySettings(NativeDataCaptureContextSettings var1);

    public abstract void disposeAsync();

    public abstract NativeFeatureAvailability getFeatureAvailability(NativeLicensedFeature var1);

    public abstract NativeFrameOfReference getFrameOfReference();

    public abstract NativeFrameSource getFrameSource();

    public abstract NativeLicenseInfo getLicenseInfo();

    public abstract NativeRecognitionContextSettings getSettings();

    public abstract NativeWrappedFuture removeAllModesAsyncWrapped();

    public abstract void removeFrameListenerAsync(NativeDataCaptureContextFrameListener var1);

    public abstract void removeListenerAsync(NativeDataCaptureContextListener var1);

    public abstract NativeWrappedFuture removeModeAsyncWrapped(NativeDataCaptureMode var1);

    public abstract void setFrameOfReferenceViewSizeAndOrientation(SizeWithUnit var1, float var2, int var3);

    public abstract NativeWrappedFuture setFrameSourceAsyncWrapped(NativeFrameSource var1);
}


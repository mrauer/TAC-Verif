/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.capture;

import com.scandit.datacapture.core.internal.sdk.analytics.NativeAnalyticsSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeDataCaptureContextSettings;
import com.scandit.datacapture.core.internal.sdk.capture.NativeServerEndpoint;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeDataCaptureContextSettings {
    public NativeDataCaptureContextSettings() {
    }

    public static NativeDataCaptureContextSettings create() {
        return CppProxy.create();
    }

    public abstract NativeServerEndpoint getAnalyticsEndpoint();

    public abstract NativeAnalyticsSettings getAnalyticsSettings();

    public abstract String getEnabledCpusBitset();

    public abstract int getNumberOfEngineThreads();

    public abstract boolean getShouldEnableSubscriptionVerifierV2();

    public abstract void setAnalyticsEndpoint(NativeServerEndpoint var1);

    public abstract void setAnalyticsSettings(NativeAnalyticsSettings var1);

    public abstract void setEnabledCpusBitset(String var1);

    public abstract void setNumberOfEngineThreads(int var1);

    public abstract void setShouldEnableSubscriptionVerifierV2(boolean var1);
}


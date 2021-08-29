/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.analytics.NativeAnalyticsSettings$CppProxy
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.sdk.analytics;

import com.scandit.datacapture.core.internal.sdk.analytics.NativeAnalyticsSettings;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class NativeAnalyticsSettings {
    public NativeAnalyticsSettings() {
    }

    public static NativeAnalyticsSettings create() {
        return CppProxy.create();
    }

    public abstract void setBoolProperty(String var1, boolean var2);

    public abstract void setStringProperty(String var1, String var2);
}


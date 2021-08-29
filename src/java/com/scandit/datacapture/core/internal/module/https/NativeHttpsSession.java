/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsRequest;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionConfiguration;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionDelegate;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsTask;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeHttpsSession {
    public abstract NativeHttpsSessionConfiguration getConfiguration();

    public abstract NativeHttpsSessionDelegate getDelegate();

    public abstract void setDelegate(NativeHttpsSessionDelegate var1);

    public abstract void shouldAllowExpiredCertificates(boolean var1);

    public abstract NativeHttpsTask startRequest(NativeHttpsRequest var1);
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsError;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsRequest;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsResponse;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsTaskState;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeHttpsTask {
    public abstract void cancel();

    public abstract NativeHttpsError getError();

    public abstract int getId();

    public abstract float getProgress();

    public abstract NativeHttpsRequest getRequest();

    public abstract NativeHttpsResponse getResponse();

    public abstract NativeHttpsTaskState getState();

    public abstract void start();
}


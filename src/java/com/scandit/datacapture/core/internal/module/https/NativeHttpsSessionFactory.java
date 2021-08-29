/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.scandit.datacapture.core.internal.module.https;

import com.scandit.datacapture.core.internal.module.https.NativeHttpsSession;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionConfiguration;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeHttpsSessionFactory {
    public abstract NativeHttpsSession create(NativeHttpsSessionConfiguration var1);
}


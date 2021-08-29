/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.framesave;

import com.scandit.datacapture.core.internal.module.framesave.NativeFrameSaveSession;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;

@DjinniGenerated
public abstract class NativeFrameSaveSessionListener {
    public abstract void onFrameSaveFailure(NativeFrameSaveSession var1, String var2, long var3);

    public abstract void onFrameSaveSuccess(NativeFrameSaveSession var1, String var2, long var3);

    public abstract void onObservationStarted(NativeFrameSaveSession var1);

    public abstract void onObservationStopped(NativeFrameSaveSession var1);
}


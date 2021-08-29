/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.internal.sdk.common.NativeContextStatus;
import com.scandit.datacapture.core.internal.sdk.common.NativeError;
import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import java.util.ArrayList;

@DjinniGenerated
public abstract class NativeContextStatusListener {
    public abstract void onStatusChanged(NativeContextStatus var1);

    public abstract void onWarningsChanged(ArrayList<NativeError> var1);
}


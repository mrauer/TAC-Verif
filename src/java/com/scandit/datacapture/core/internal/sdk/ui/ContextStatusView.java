/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.scandit.datacapture.core.internal.sdk.ui;

import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.internal.sdk.common.NativeError;
import java.util.ArrayList;

public interface ContextStatusView {
    public void displayContextStatus(ContextStatus var1);

    public void displayWarnings(ArrayList<NativeError> var1);
}


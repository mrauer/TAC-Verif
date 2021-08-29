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
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusView;
import java.util.ArrayList;

public interface ContextStatusPresenter {
    public void onStatusChanged(ContextStatus var1);

    public void onWarningsChanged(ArrayList<NativeError> var1);

    public void setView(ContextStatusView var1);
}


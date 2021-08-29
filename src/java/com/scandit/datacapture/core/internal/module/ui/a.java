/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui;

import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.internal.sdk.common.NativeError;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusPresenter;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class a
implements ContextStatusPresenter {
    public ContextStatusView a;

    @Override
    public final void onStatusChanged(ContextStatus contextStatus) {
        Intrinsics.checkNotNullParameter((Object)contextStatus, (String)"status");
        ContextStatusView contextStatusView2 = this.a;
        if (contextStatusView2 != null) {
            contextStatusView2.displayContextStatus(contextStatus);
        }
    }

    @Override
    public final void onWarningsChanged(ArrayList<NativeError> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String)"warnings");
        ContextStatusView contextStatusView2 = this.a;
        if (contextStatusView2 != null) {
            contextStatusView2.displayWarnings(arrayList);
        }
    }

    @Override
    public final void setView(ContextStatusView contextStatusView2) {
        this.a = contextStatusView2;
    }
}


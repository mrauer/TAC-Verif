/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui;

import android.content.Context;
import com.scandit.datacapture.core.common.ContextStatus;
import com.scandit.datacapture.core.internal.sdk.common.NativeError;
import com.scandit.datacapture.core.internal.sdk.ui.ContextStatusView;
import com.scandit.datacapture.core.ui.DataCaptureView;
import com.scandit.datacapture.core.ui.DataCaptureView$contextStatusView$1;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class DataCaptureView$contextStatusView$1
implements ContextStatusView {
    public final /* synthetic */ DataCaptureView a;
    public final /* synthetic */ Context b;

    public DataCaptureView$contextStatusView$1(DataCaptureView dataCaptureView, Context context) {
        this.a = dataCaptureView;
        this.b = context;
    }

    @Override
    public final void displayContextStatus(ContextStatus contextStatus) {
        Intrinsics.checkNotNullParameter((Object)contextStatus, (String)"status");
        this.a.post(new Runnable(this, contextStatus){
            public /* synthetic */ DataCaptureView$contextStatusView$1 a;
            public /* synthetic */ ContextStatus b;
            {
                this.a = dataCaptureView$contextStatusView$1;
                this.b = contextStatus;
            }

            public final void run() {
                if (com.scandit.datacapture.core.internal.sdk.common.NativeContextStatusCompat.isSuccessOrUnknown(this.b.b)) {
                    com.scandit.datacapture.core.internal.module.ui.ErrorOverlay errorOverlay = this.a.a.j;
                    java.util.Objects.requireNonNull((Object)((Object)errorOverlay));
                    Intrinsics.checkNotNullParameter((Object)"", (String)"string");
                    errorOverlay.a.setText((java.lang.CharSequence)"");
                    this.a.a.j.setVisibility(4);
                    return;
                }
                com.scandit.datacapture.core.internal.module.ui.ErrorOverlay errorOverlay = this.a.a.j;
                ContextStatus contextStatus = this.b;
                java.util.Objects.requireNonNull((Object)((Object)errorOverlay));
                Intrinsics.checkNotNullParameter((Object)contextStatus, (String)"contextStatus");
                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder("Error ");
                stringBuilder.append(contextStatus.b);
                stringBuilder.append(": ");
                stringBuilder.append(contextStatus.a);
                String string = stringBuilder.toString();
                Intrinsics.checkNotNullParameter((Object)string, (String)"string");
                errorOverlay.a.setText((java.lang.CharSequence)string);
                this.a.a.j.setVisibility(0);
            }
        });
    }

    @Override
    public final void displayWarnings(ArrayList<NativeError> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, (String)"warnings");
        if (true ^ arrayList.isEmpty()) {
            this.a.post(new Runnable(this, arrayList){
                public /* synthetic */ DataCaptureView$contextStatusView$1 a;
                public /* synthetic */ ArrayList b;
                {
                    this.a = dataCaptureView$contextStatusView$1;
                    this.b = arrayList;
                }

                public final void run() {
                    String string = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default((java.lang.Iterable)this.b, (java.lang.CharSequence)"\n", null, null, (int)0, null, (kotlin.jvm.functions.Function1)com.scandit.datacapture.core.ui.DataCaptureView$contextStatusView$1$b$a.a, (int)30);
                    android.widget.Toast.makeText((Context)this.a.b, (java.lang.CharSequence)string, (int)1).show();
                }
            });
        }
    }
}


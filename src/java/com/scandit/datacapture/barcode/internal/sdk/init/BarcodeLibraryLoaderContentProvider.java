/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.internal.sdk.init;

import android.content.Context;
import com.scandit.datacapture.barcode.internal.sdk.init.BarcodeLibraryLoader;
import com.scandit.datacapture.core.internal.sdk.init.CoreLibraryLoader;
import com.scandit.datacapture.core.internal.sdk.init.EmptyContentProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lcom/scandit/datacapture/barcode/internal/sdk/init/BarcodeLibraryLoaderContentProvider;", "Lcom/scandit/datacapture/core/internal/sdk/init/EmptyContentProvider;", "", "onCreate", "()Z", "<init>", "()V", "scandit-barcode-capture"}, k=1, mv={1, 4, 0})
public final class BarcodeLibraryLoaderContentProvider
extends EmptyContentProvider {
    public final boolean onCreate() {
        Context context = this.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"it");
            Intrinsics.checkNotNullParameter((Object)context, (String)"context");
            CoreLibraryLoader.ensureInitialized(context);
            if (BarcodeLibraryLoader.a.compareAndSet(false, true)) {
                System.loadLibrary((String)"sdc-barcode");
            }
        }
        return true;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.init;

import android.content.Context;
import com.scandit.datacapture.core.internal.sdk.init.CoreLibraryLoader;
import com.scandit.datacapture.core.internal.sdk.init.EmptyContentProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2={"Lcom/scandit/datacapture/core/internal/sdk/init/CoreLibraryLoaderContentProvider;", "Lcom/scandit/datacapture/core/internal/sdk/init/EmptyContentProvider;", "", "onCreate", "()Z", "<init>", "()V", "scandit-capture-core"}, k=1, mv={1, 4, 0})
public final class CoreLibraryLoaderContentProvider
extends EmptyContentProvider {
    public final boolean onCreate() {
        Context context = this.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue((Object)context, (String)"it");
            CoreLibraryLoader.ensureInitialized(context);
        }
        return true;
    }
}


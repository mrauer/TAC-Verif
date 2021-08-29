/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module;

import android.content.Context;
import com.scandit.internal.sdk.bar.FilesystemInstance;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

public final class a
extends FilesystemInstance {
    public final Context a;

    public a(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Context context2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"context.applicationContext");
        this.a = context2;
    }

    @Override
    public final String getTemporaryDirectory() {
        File file = this.a.getCacheDir();
        Intrinsics.checkNotNullExpressionValue((Object)file, (String)"context.cacheDir");
        String string = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"context.cacheDir.absolutePath");
        return string;
    }
}


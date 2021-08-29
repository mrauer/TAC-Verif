/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  com.scandit.datacapture.core.internal.module.a
 *  com.scandit.datacapture.core.internal.module.data.a
 *  com.scandit.datacapture.core.internal.module.https.f
 *  com.scandit.datacapture.core.internal.sdk.ThreadCreatorImpl
 *  com.scandit.datacapture.core.internal.sdk.localization.AndroidLocalizer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicBoolean
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.init;

import android.content.Context;
import android.content.res.Resources;
import com.scandit.datacapture.core.internal.module.data.NativeDataDecoding;
import com.scandit.datacapture.core.internal.module.data.NativeDataDecodingFactory;
import com.scandit.datacapture.core.internal.module.data.a;
import com.scandit.datacapture.core.internal.module.https.NativeHttps;
import com.scandit.datacapture.core.internal.module.https.NativeHttpsSessionFactory;
import com.scandit.datacapture.core.internal.module.https.f;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.datacapture.core.internal.sdk.ThreadCreatorImpl;
import com.scandit.datacapture.core.internal.sdk.localization.AndroidLocalizer;
import com.scandit.internal.sdk.bar.Filesystem;
import com.scandit.internal.sdk.bar.FilesystemInstance;
import com.scandit.internal.sdk.bar.HandlerThreadCreator;
import com.scandit.internal.sdk.bar.Localizer;
import com.scandit.internal.sdk.bar.LocalizerHandler;
import com.scandit.internal.sdk.bar.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

public final class CoreLibraryLoader {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    public static final void ensureInitialized(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        if (a.compareAndSet(false, true)) {
            Context context2 = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue((Object)context2, (String)"context.applicationContext");
            Intrinsics.checkNotNullParameter((Object)context2, (String)"<set-?>");
            AppAndroidEnvironment.applicationContext = context2;
            System.loadLibrary((String)"bar");
            System.loadLibrary((String)"sdc-core");
            ThreadFactory.setFactory((HandlerThreadCreator)new ThreadCreatorImpl(context.getResources().getInteger(2131361818)));
            NativeDataDecodingFactory.setDataDecoding((NativeDataDecoding)new a());
            Filesystem.setInstance((FilesystemInstance)new com.scandit.datacapture.core.internal.module.a(context));
            LocalizerHandler.setDefaultLocalizer((Localizer)new AndroidLocalizer(context));
            NativeHttps.setFactory((NativeHttpsSessionFactory)new f());
        }
    }
}


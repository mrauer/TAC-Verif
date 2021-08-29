/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.SoundPool
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.extensions;

import android.content.Context;
import android.media.SoundPool;
import com.scandit.datacapture.core.common.feedback.Sound;
import kotlin.jvm.internal.Intrinsics;

public final class SoundPoolExtensionsKt {
    public static final int load(SoundPool soundPool, Context context, Sound sound) {
        Intrinsics.checkNotNullParameter((Object)soundPool, (String)"$this$load");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        int n2 = sound.a;
        if (n2 != 0) {
            return soundPool.load(context, n2, 1);
        }
        return 0;
    }
}


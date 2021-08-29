/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.SoundPool
 *  android.media.SoundPool$OnLoadCompleteListener
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.scandit.datacapture.core.common.feedback;

import android.media.SoundPool;
import com.scandit.datacapture.core.common.feedback.Feedback;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class Feedback$b
implements SoundPool.OnLoadCompleteListener {
    public /* synthetic */ Feedback a;

    public Feedback$b(Feedback feedback) {
        this.a = feedback;
    }

    public final void onLoadComplete(SoundPool soundPool, int n2, int n3) {
        this.a.a.set(true);
        AtomicInteger atomicInteger = this.a.b;
        int n4 = atomicInteger.getAndSet(0);
        for (int i2 = 0; i2 < n4; ++i2) {
            Feedback.access$emitInternal(this.a);
        }
    }
}


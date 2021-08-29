/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.media.SoundPool
 *  android.os.Handler
 *  android.os.HandlerThread
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.barcode.capture;

import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import com.scandit.datacapture.barcode.feedback.BarcodeCaptureFeedback;
import com.scandit.datacapture.core.common.feedback.Feedback;
import com.scandit.datacapture.core.internal.sdk.capture.NativeFeedback;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

public final class BarcodeCapture$setNativeFeedback$1
extends NativeFeedback {
    public /* synthetic */ BarcodeCaptureFeedback a;

    public BarcodeCapture$setNativeFeedback$1(BarcodeCaptureFeedback barcodeCaptureFeedback) {
        this.a = barcodeCaptureFeedback;
    }

    @Override
    public final void emit() {
        Feedback feedback = this.a.a;
        if (!feedback.a.get()) {
            feedback.b.incrementAndGet();
            return;
        }
        feedback.d.post(new Runnable(feedback){
            public /* synthetic */ Feedback a;
            {
                this.a = feedback;
            }

            public final void run() {
                Feedback.access$emitInternal(this.a);
            }
        });
    }

    @Override
    public final void onFreeResources() {
        Feedback feedback = this.a.a;
        feedback.j = 0;
        SoundPool soundPool = feedback.e;
        if (soundPool != null) {
            soundPool.release();
        }
        feedback.e = null;
        feedback.c.quitSafely();
    }

    @Override
    public final void onLoadResources() {
        Feedback feedback = this.a.a;
        Intrinsics.checkNotNullParameter((Object)feedback, (String)"$this$loadSoundResource");
        feedback.loadSoundResourceInternal$scandit_capture_core();
    }
}


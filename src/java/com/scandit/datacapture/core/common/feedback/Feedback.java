/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.AudioManager
 *  android.media.SoundPool
 *  android.media.SoundPool$Builder
 *  android.media.SoundPool$OnLoadCompleteListener
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.VibrationEffect
 *  android.os.Vibrator
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.common.feedback;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.scandit.datacapture.core.common.feedback.Feedback$b;
import com.scandit.datacapture.core.common.feedback.Sound;
import com.scandit.datacapture.core.common.feedback.Vibration;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.datacapture.core.internal.sdk.extensions.SoundPoolExtensionsKt;
import com.scandit.datacapture.core.time.TimeInterval;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

public final class Feedback {
    public final AtomicBoolean a;
    public final AtomicInteger b;
    public final HandlerThread c;
    public final Handler d;
    public SoundPool e;
    public final AudioManager f;
    public final Vibrator g;
    public final int h;
    public final long i;
    public int j;
    public final Vibration k;
    public final Sound l;

    public Feedback() {
        this(null, null);
    }

    public Feedback(Vibration vibration, Sound sound) {
        TimeInterval timeInterval;
        this.k = vibration;
        this.l = sound;
        this.a = new AtomicBoolean();
        this.b = new AtomicInteger();
        HandlerThread handlerThread = new HandlerThread("thread-feedback");
        handlerThread.start();
        this.c = handlerThread;
        this.d = new Handler(handlerThread.getLooper());
        long l2 = vibration != null && (timeInterval = vibration.a) != null ? (long)(1000.0f * timeInterval.a) : 0L;
        this.i = l2;
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Object object = context.getSystemService("audio");
            if (!(object instanceof AudioManager)) {
                object = null;
            }
            this.f = (AudioManager)object;
            Object object2 = context.getSystemService("vibrator");
            Object object3 = !(object2 instanceof Vibrator) ? null : object2;
            this.g = (Vibrator)object3;
            this.h = context.getPackageManager().checkPermission("android.permission.VIBRATE", context.getPackageName());
            this.loadSoundResourceInternal$scandit_capture_core();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }

    public static final /* synthetic */ void access$emitInternal(Feedback feedback) {
        AudioManager audioManager;
        SoundPool soundPool;
        boolean bl;
        AudioManager audioManager2;
        if (feedback.k != null && feedback.g != null && (bl = feedback.h == 0 && ((audioManager = feedback.f) == null || audioManager.getRingerMode() != 0))) {
            if (Build.VERSION.SDK_INT >= 26) {
                feedback.g.vibrate(VibrationEffect.createOneShot((long)feedback.i, (int)-1));
            } else {
                feedback.g.vibrate(feedback.i);
            }
        }
        if (feedback.e != null && feedback.j != 0 && (audioManager2 = feedback.f) != null && audioManager2.getRingerMode() == 2 && (soundPool = feedback.e) != null) {
            soundPool.play(feedback.j, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Feedback)) {
            return false;
        }
        Vibration vibration = this.k;
        Feedback feedback = (Feedback)object;
        return Intrinsics.areEqual((Object)vibration, (Object)feedback.k) && Intrinsics.areEqual((Object)this.l, (Object)feedback.l);
    }

    public final int hashCode() {
        Vibration vibration = this.k;
        int n2 = vibration != null ? vibration.hashCode() : 0;
        int n3 = n2 * 31;
        Sound sound = this.l;
        int n4 = sound != null ? sound.hashCode() : 0;
        int n5 = 31 * (31 * (31 * (31 * (31 * (n3 + n4) + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode());
        SoundPool soundPool = this.e;
        int n6 = soundPool != null ? soundPool.hashCode() : 0;
        int n7 = 31 * (n5 + n6);
        AudioManager audioManager = this.f;
        int n8 = audioManager != null ? audioManager.hashCode() : 0;
        int n9 = 31 * (n7 + n8);
        Vibrator vibrator = this.g;
        int n10 = 0;
        if (vibrator != null) {
            n10 = vibrator.hashCode();
        }
        return 31 * (31 * (31 * (n9 + n10) + this.h) + Long.valueOf((long)this.i).hashCode()) + this.j;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void loadSoundResourceInternal$scandit_capture_core() {
        int n2;
        block8 : {
            if (this.l != null && this.j == 0) {
                if (this.e == null) {
                    AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(14).setContentType(4).build();
                    SoundPool soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).setMaxStreams(2).build();
                    Intrinsics.checkNotNullExpressionValue((Object)soundPool, (String)"SoundPool.Builder().setA\u2026.setMaxStreams(2).build()");
                    soundPool.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener)new Feedback$b(this));
                    this.e = soundPool;
                }
                try {
                    SoundPool soundPool = this.e;
                    if (soundPool != null) {
                        Context context = AppAndroidEnvironment.applicationContext;
                        if (context == null) {
                            Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
                            throw null;
                        }
                        n2 = SoundPoolExtensionsKt.load(soundPool, context, this.l);
                    }
                    break block8;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    return;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                    return;
                }
                catch (Resources.NotFoundException notFoundException) {
                    notFoundException.printStackTrace();
                    return;
                }
            }
            this.a.set(true);
            return;
        }
        n2 = 0;
        this.j = n2;
    }

}


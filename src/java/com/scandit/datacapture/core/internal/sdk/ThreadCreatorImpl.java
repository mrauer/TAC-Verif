/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk;

import com.scandit.internal.sdk.bar.Callable;
import com.scandit.internal.sdk.bar.HandlerThread;
import com.scandit.internal.sdk.bar.HandlerThreadCreator;
import kotlin.jvm.internal.Intrinsics;

public final class ThreadCreatorImpl
extends HandlerThreadCreator {
    public final int a;

    public ThreadCreatorImpl(int n2) {
        this.a = n2;
    }

    @Override
    public final HandlerThread create(String string, Callable callable) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)callable, (String)"function");
        return new b(string, callable, this.a);
    }

    public static final class b
    extends HandlerThread {
        public final android.os.HandlerThread a;

        public b(String string, Callable callable, int n2) {
            android.os.HandlerThread handlerThread;
            Intrinsics.checkNotNullParameter((Object)string, (String)"name");
            Intrinsics.checkNotNullParameter((Object)callable, (String)"function");
            this.a = handlerThread = new android.os.HandlerThread(string, callable, n2){
                public final Callable a;
                {
                    Intrinsics.checkNotNullParameter((Object)string, (String)"name");
                    Intrinsics.checkNotNullParameter((Object)callable, (String)"function");
                    super(string, n2);
                    this.a = callable;
                }

                public final void onLooperPrepared() {
                    super.onLooperPrepared();
                    this.a.run();
                }
            };
            handlerThread.start();
        }

        @Override
        public final void quitSafely() {
            try {
                this.a.quitSafely();
                return;
            }
            catch (InterruptedException interruptedException) {
                com.scandit.datacapture.core.internal.module.e.a.a((Exception)((Object)interruptedException));
                return;
            }
        }
    }

}


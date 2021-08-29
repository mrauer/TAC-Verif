/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.OnLifecycleEvent
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.ingroupe.verify.anticovid.observer.BackgroundObserverListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2={"Lcom/ingroupe/verify/anticovid/observer/BackgroundObserver;", "Landroidx/lifecycle/LifecycleObserver;", "", "onMoveToForeground", "()V", "onMoveToBackground", "Lcom/ingroupe/verify/anticovid/observer/BackgroundObserverListener;", "listener", "Lcom/ingroupe/verify/anticovid/observer/BackgroundObserverListener;", "", "wasInBackground", "Z", "getWasInBackground", "()Z", "setWasInBackground", "(Z)V", "<init>", "(Lcom/ingroupe/verify/anticovid/observer/BackgroundObserverListener;)V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class BackgroundObserver
implements LifecycleObserver {
    public final BackgroundObserverListener listener;
    public boolean wasInBackground;

    public BackgroundObserver(BackgroundObserverListener backgroundObserverListener) {
        Intrinsics.checkNotNullParameter((Object)backgroundObserverListener, (String)"listener");
        this.listener = backgroundObserverListener;
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_STOP)
    public final void onMoveToBackground() {
        this.wasInBackground = true;
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_START)
    public final void onMoveToForeground() {
        if (this.wasInBackground) {
            this.wasInBackground = false;
            this.listener.hasComeBackFromBackground();
        }
    }
}


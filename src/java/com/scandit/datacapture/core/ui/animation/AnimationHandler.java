/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.ThreadLocal
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package com.scandit.datacapture.core.ui.animation;

import java.util.ArrayList;
import java.util.HashMap;

public final class AnimationHandler {
    public static ThreadLocal<AnimationHandler> a = new ThreadLocal();
    public final HashMap<b, Long> b = new HashMap();
    public final ArrayList<b> c = new ArrayList();
    public final a d = new a();
    public AnimationFrameCallbackProvider e;
    public long f = 0L;
    public boolean g = false;

    public static AnimationHandler a() {
        if (a.get() == null) {
            a.set((Object)new AnimationHandler());
        }
        return (AnimationHandler)a.get();
    }

    public static abstract class AnimationFrameCallbackProvider {
        public final a a;

        public AnimationFrameCallbackProvider(a a2) {
            this.a = a2;
        }
    }

    public final class a {
    }

    public static interface b {
        public boolean doAnimationFrame(long var1);
    }

}


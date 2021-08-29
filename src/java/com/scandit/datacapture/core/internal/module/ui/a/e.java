/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.concurrent.CopyOnWriteArrayList
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.a;

import android.os.Handler;
import android.os.Looper;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.scandit.datacapture.core.internal.module.ui.NativeHintPresenter;
import com.scandit.datacapture.core.internal.module.ui.a.c;
import com.scandit.datacapture.core.internal.module.ui.a.d;
import com.scandit.datacapture.core.internal.module.ui.a.e$c;
import com.scandit.datacapture.core.internal.module.ui.a.e$d;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

public final class e
extends NativeHintPresenter {
    public final List<a> a;
    public b b;
    public final c c;
    public final d d;
    public final Handler e;

    public e(c c2, d d2, Handler handler, int n2) {
        Handler handler2 = new Handler(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter((Object)c2, (String)"hintHolder");
        Intrinsics.checkNotNullParameter((Object)d2, (String)"operationsHandler");
        Intrinsics.checkNotNullParameter((Object)handler2, (String)"handler");
        this.c = c2;
        this.d = d2;
        this.e = handler2;
        this.a = new CopyOnWriteArrayList();
        this.b = b.a;
    }

    public static final void b(e e2) {
        e e3 = e2;
        synchronized (e3) {
            if (e2.d.b(e2.b, e2.a)) {
                e2.a(ArraysKt___ArraysJvmKt.removeFirst(e2.a));
                return;
            }
            e2.b = b.a;
            return;
        }
    }

    public final void a() {
        e e2 = this;
        synchronized (e2) {
            if (this.d.a(this.b, this.a)) {
                a a2 = ArraysKt___ArraysJvmKt.removeFirst(this.a);
                this.b = b.b;
                this.a(a2);
            }
            return;
        }
    }

    public final void a(a a2) {
        if (a2 instanceof b) {
            b b2 = a2;
            this.e.post((Runnable)new e$d(this, b2));
            return;
        }
        if (a2 instanceof a) {
            this.e.post((Runnable)new e$c(this));
        }
    }

    @Override
    public final void hideHint() {
        this.a.add((Object)a.a);
        this.a();
    }

    @Override
    public final void showHint(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hint");
        this.a.add((Object)new a(string){
            public final String a;
            {
                Intrinsics.checkNotNullParameter((Object)string, (String)"hint");
                super((byte)0);
                this.a = string;
            }

            public final boolean equals(Object object) {
                block2 : {
                    block3 : {
                        if (this == object) break block2;
                        if (!(object instanceof b)) break block3;
                        b b2 = object;
                        if (Intrinsics.areEqual((Object)this.a, (Object)b2.a)) break block2;
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                String string = this.a;
                if (string != null) {
                    return string.hashCode();
                }
                return 0;
            }

            public final String toString() {
                return GeneratedOutlineSupport.outline21((StringBuilder)new StringBuilder("Show(hint="), (String)this.a, (String)")");
            }
        });
        this.a();
    }

}


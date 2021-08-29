/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.datacapture.core.internal.sdk.data.DisposableResource$a
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.data;

import com.scandit.datacapture.core.internal.sdk.data.DisposableResource;
import com.scandit.datacapture.core.internal.sdk.data.Subscription;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis.
 */
public final class DisposableResource<T> {
    public int a;
    public T b;
    public final Object c;
    public final Function0<T> d;
    public final Function1<T, Unit> e;

    public DisposableResource(Function0<? extends T> function0, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, (String)"factory");
        Intrinsics.checkNotNullParameter(function1, (String)"tearDown");
        this.d = function0;
        this.e = function1;
        this.c = new Object();
    }

    public final Subscription<T> start() {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            block4 : {
                int n2;
                this.a = n2 = 1 + this.a;
                if (n2 != 1) break block4;
                this.b = this.d.invoke();
            }
            return new /* Unavailable Anonymous Inner Class!! */;
        }
    }
}


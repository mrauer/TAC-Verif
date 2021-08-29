/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.scandit.datacapture.core.internal.module.ui.a.e
 *  com.scandit.datacapture.core.internal.module.ui.a.e$c$1$1
 *  java.lang.Object
 *  java.lang.Runnable
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 */
package com.scandit.datacapture.core.internal.module.ui.a;

import android.view.View;
import com.scandit.datacapture.core.internal.module.ui.a.c;
import com.scandit.datacapture.core.internal.module.ui.a.e;
import com.scandit.datacapture.core.internal.module.ui.a.e$c;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class e$c
implements Runnable {
    public final /* synthetic */ e a;

    public e$c(e e2) {
        this.a = e2;
    }

    public final void run() {
        this.a.c.b().post(new Runnable(){

            public final void run() {
                this.a.c.a((Function0<Unit>)new 1(this));
            }
        });
    }

}


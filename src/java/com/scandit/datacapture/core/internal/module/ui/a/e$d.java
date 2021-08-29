/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.scandit.datacapture.core.internal.module.ui.a.e
 *  com.scandit.datacapture.core.internal.module.ui.a.e$a$b
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.scandit.datacapture.core.internal.module.ui.a;

import android.view.View;
import com.scandit.datacapture.core.internal.module.ui.a.c;
import com.scandit.datacapture.core.internal.module.ui.a.e;

public final class e$d
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ e.a.b b;

    public e$d(e e2, e.a.b b2) {
        this.a = e2;
        this.b = b2;
    }

    public final void run() {
        this.a.c.b().post(new Runnable(this){
            public /* synthetic */ e$d a;
            {
                this.a = e$d;
            }

            public final void run() {
                e$d e$d = this.a;
                e$d.a.c.a(e$d.b.a);
                this.a.a.c.c();
                e.b((e)this.a.a);
            }
        });
    }

}


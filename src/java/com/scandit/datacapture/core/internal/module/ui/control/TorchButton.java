/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Looper
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.scandit.datacapture.core.internal.module.ui.control.TorchButton$2
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.concurrent.CopyOnWriteArraySet
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.module.ui.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.scandit.datacapture.core.internal.module.ui.control.TorchButton;
import com.scandit.datacapture.core.source.Camera;
import com.scandit.datacapture.core.source.TorchListener;
import com.scandit.datacapture.core.source.TorchState;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@SuppressLint(value={"ViewConstructor"})
public final class TorchButton
extends com.scandit.datacapture.core.internal.module.ui.control.a
implements TorchListener {
    public Camera a;
    public final a b;

    public TorchButton(Context context, a a2) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)a2, (String)"torchImageProvider");
        super(context);
        this.b = a2;
        this.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.setBackground((Drawable)new ColorDrawable(0));
        this.setPadding(0, 0, 0, 0);
        this.setOnClickListener(new View.OnClickListener(this){
            public /* synthetic */ TorchButton a;
            {
                this.a = torchButton;
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final void onClick(View view) {
                TorchState torchState;
                Camera camera = this.a.a;
                if (camera == null) return;
                TorchState torchState2 = camera.d;
                int n2 = com.scandit.datacapture.core.internal.module.ui.control.b.a[torchState2.ordinal()];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) throw new kotlin.NoWhenBranchMatchedException();
                        torchState = TorchState.AUTO;
                    } else {
                        torchState = TorchState.ON;
                    }
                } else {
                    torchState = TorchState.OFF;
                }
                Intrinsics.checkNotNullParameter((Object)((Object)torchState), (String)"value");
                if (camera.d == torchState) return;
                camera.d = torchState;
                Intrinsics.checkNotNullParameter((Object)((Object)torchState), (String)"torchState");
                com.scandit.datacapture.core.source.AndroidCameraProxyAdapter androidCameraProxyAdapter = camera.f;
                java.util.Objects.requireNonNull((Object)androidCameraProxyAdapter);
                Intrinsics.checkNotNullParameter((Object)((Object)torchState), (String)"torchState");
                androidCameraProxyAdapter.b.applyTorchStateAsync(torchState);
                Iterator iterator = camera.b.iterator();
                while (iterator.hasNext()) {
                    ((TorchListener)iterator.next()).onTorchStateChanged(torchState);
                }
                Iterator iterator2 = camera.c.iterator();
                while (iterator2.hasNext()) {
                    TorchListener torchListener = (TorchListener)((WeakReference)iterator2.next()).get();
                    if (torchListener == null) continue;
                    torchListener.onTorchStateChanged(torchState);
                }
            }
        });
        2 var3_3 = new 2(this);
        Intrinsics.checkNotNullParameter((Object)var3_3, (String)"block");
        ((com.scandit.datacapture.core.internal.module.ui.control.a)this).b = var3_3;
    }

    public final void a(Camera camera) {
        Camera camera2 = this.a;
        if (camera2 != null) {
            Intrinsics.checkNotNullParameter((Object)this, (String)"listener");
            CopyOnWriteArraySet<WeakReference<TorchListener>> copyOnWriteArraySet = camera2.c;
            ArrayList arrayList = new ArrayList();
            for (Object object : copyOnWriteArraySet) {
                if (!Intrinsics.areEqual((Object)((TorchListener)((WeakReference)object).get()), (Object)this)) continue;
                arrayList.add(object);
            }
            for (WeakReference weakReference : arrayList) {
                camera2.c.remove((Object)weakReference);
            }
        }
        this.a = camera;
        this.b(camera);
        Camera camera3 = this.a;
        if (camera3 != null) {
            boolean bl;
            Intrinsics.checkNotNullParameter((Object)this, (String)"listener");
            CopyOnWriteArraySet<WeakReference<TorchListener>> copyOnWriteArraySet = camera3.c;
            if (!(copyOnWriteArraySet instanceof Collection) || !copyOnWriteArraySet.isEmpty()) {
                Iterator iterator = copyOnWriteArraySet.iterator();
                while (iterator.hasNext()) {
                    if (!Intrinsics.areEqual((Object)((TorchListener)((WeakReference)iterator.next()).get()), (Object)this)) continue;
                    bl = false;
                    break;
                }
            } else {
                bl = true;
            }
            if (bl) {
                camera3.c.add((Object)new WeakReference((Object)this));
            }
        }
    }

    public final void a(TorchState torchState) {
        if (Intrinsics.areEqual((Object)Looper.myLooper(), (Object)Looper.getMainLooper())) {
            this.setImageBitmap(this.b.imageForState(torchState, ((com.scandit.datacapture.core.internal.module.ui.control.a)this).a));
            return;
        }
        this.post(new Runnable(this, torchState){
            public /* synthetic */ TorchButton a;
            public /* synthetic */ TorchState b;
            {
                this.a = torchButton;
                this.b = torchState;
            }

            public final void run() {
                TorchButton torchButton = this.a;
                torchButton.setImageBitmap(torchButton.b.imageForState(this.b, ((com.scandit.datacapture.core.internal.module.ui.control.a)torchButton).a));
            }
        });
    }

    public final void b(Camera camera) {
        if (camera != null) {
            this.a(camera.d);
        }
    }

    @Override
    public final void onTorchStateChanged(TorchState torchState) {
        Intrinsics.checkNotNullParameter((Object)((Object)torchState), (String)"state");
        this.a(torchState);
    }

}


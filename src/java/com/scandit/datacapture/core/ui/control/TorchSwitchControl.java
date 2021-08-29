/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.scandit.datacapture.core.internal.module.ui.control.TorchButton
 *  com.scandit.datacapture.core.ui.control.TorchSwitchControl$torchImageButtonImageProvider
 *  com.scandit.datacapture.core.ui.control.TorchSwitchControl$torchImageButtonImageProvider$1
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.ui.control;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.scandit.datacapture.core.internal.module.ui.control.TorchButton;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.datacapture.core.ui.control.TorchSwitchControl;
import kotlin.jvm.internal.Intrinsics;

public final class TorchSwitchControl {
    public final torchImageButtonImageProvider.1 a;
    public final TorchButton b;
    public Bitmap c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;

    public TorchSwitchControl(Context context) {
        torchImageButtonImageProvider.1 var2_2;
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.a = var2_2 = new torchImageButtonImageProvider.1(this);
        this.b = new TorchButton(context, (TorchButton.a)var2_2);
        this.c = TorchSwitchControl.a(2131165320);
        this.d = TorchSwitchControl.a(2131165321);
        this.e = TorchSwitchControl.a(2131165318);
        this.f = TorchSwitchControl.a(2131165319);
    }

    public static Bitmap a(int n2) {
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Intrinsics.checkNotNullParameter((Object)context, (String)"$this$getBitmap");
            Intrinsics.checkNotNullParameter((Object)context, (String)"$this$getDrawableCompat");
            Drawable drawable = context.getDrawable(n2);
            if (drawable != null) {
                Intrinsics.checkNotNullParameter((Object)drawable, (String)"$this$toBitmap");
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                    Intrinsics.checkNotNullExpressionValue((Object)bitmap, (String)"bitmap");
                    return bitmap;
                }
                Bitmap bitmap = drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0 ? Bitmap.createBitmap((int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888) : Bitmap.createBitmap((int)1, (int)1, (Bitmap.Config)Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                Intrinsics.checkNotNullExpressionValue((Object)bitmap, (String)"bitmap");
                return bitmap;
            }
            StringBuilder stringBuilder = new StringBuilder("Cannot retrieve drawable for resource ");
            stringBuilder.append(n2);
            throw new IllegalStateException(stringBuilder.toString().toString());
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }
}


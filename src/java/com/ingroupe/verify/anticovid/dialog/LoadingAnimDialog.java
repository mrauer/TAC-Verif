/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.Point
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.Display
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.dialog;

import android.app.Dialog;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\rJ-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2={"Lcom/ingroupe/verify/anticovid/dialog/LoadingAnimDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "", "onResume", "()V", "<init>", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class LoadingAnimDialog
extends DialogFragment {
    public static LoadingAnimDialog inst;

    public static final LoadingAnimDialog getInstance() {
        if (inst == null) {
            inst = new LoadingAnimDialog();
        }
        return inst;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter((Object)layoutInflater, (String)"inflater");
        Log.d((String)"LoadingAnimDialog", (String)"on create view");
        return layoutInflater.inflate(2131492913, viewGroup, false);
    }

    public void onResume() {
        WindowManager windowManager;
        Log.d((String)"LoadingAnimDialog", (String)Intrinsics.stringPlus((String)"on resume ", (Object)((Object)this)));
        ((Fragment)this).mCalled = true;
        Dialog dialog = this.mDialog;
        Window window = dialog == null ? null : dialog.getWindow();
        this.mCancelable = false;
        Dialog dialog2 = this.mDialog;
        if (dialog2 != null) {
            dialog2.setCancelable(false);
        }
        if (window != null) {
            window.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
        Point point = new Point();
        Display display = window == null ? null : ((windowManager = window.getWindowManager()) == null ? null : windowManager.getDefaultDisplay());
        if (display != null) {
            display.getSize(point);
        }
        int n2 = point.x;
        int n3 = point.y;
        if (window == null) {
            return;
        }
        window.setLayout((int)(1.0 * (double)n2), (int)(1.0 * (double)n3));
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  java.lang.Object
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.dialog;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$CameraRequestDialog$_EsBglOMR2lw-v74rIo4Wm_ndrc
implements DialogInterface.OnClickListener {
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ -$$Lambda$CameraRequestDialog$_EsBglOMR2lw-v74rIo4Wm_ndrc(Fragment fragment) {
        this.f$0 = fragment;
    }

    public final void onClick(DialogInterface dialogInterface, int n3) {
        Fragment fragment = this.f$0;
        Intrinsics.checkNotNull((Object)fragment);
        FragmentActivity fragmentActivity = fragment.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        fragmentActivity.finish();
    }
}


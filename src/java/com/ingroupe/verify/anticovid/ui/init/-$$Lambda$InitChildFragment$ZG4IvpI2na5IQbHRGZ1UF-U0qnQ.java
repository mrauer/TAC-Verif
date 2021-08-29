/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.core.app.ActivityOptionsCompat
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  com.ingroupe.verify.anticovid.dialog.CameraDeniedDialog
 *  com.ingroupe.verify.anticovid.dialog.CameraRequestDialog
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.dialog.CameraDeniedDialog;
import com.ingroupe.verify.anticovid.dialog.CameraRequestDialog;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$ZG4IvpI2na5IQbHRGZ1UF-U0qnQ
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ InitChildFragment f$0;

    public /* synthetic */ -$$Lambda$InitChildFragment$ZG4IvpI2na5IQbHRGZ1UF-U0qnQ(InitChildFragment initChildFragment) {
        this.f$0 = initChildFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        InitChildFragment initChildFragment = this.f$0;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        FragmentActivity fragmentActivity = initChildFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue((Object)fragmentActivity, (String)"requireActivity()");
        FragmentManager fragmentManager = initChildFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue((Object)fragmentManager, (String)"childFragmentManager");
        ActivityResultLauncher activityResultLauncher = initChildFragment.requestPermissionLauncher;
        Intrinsics.checkNotNullParameter((Object)fragmentActivity, (String)"activity");
        Intrinsics.checkNotNullParameter((Object)fragmentManager, (String)"childFragmentManager");
        Intrinsics.checkNotNullParameter((Object)"dialogInit", (String)"fragmentDialog");
        Intrinsics.checkNotNullParameter((Object)activityResultLauncher, (String)"requestPermissionLauncher");
        if (fragmentActivity.shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
            new CameraRequestDialog(activityResultLauncher).show(fragmentManager, "dialogInit");
            return;
        }
        if (Utils.UserAskedCameraPermissionBefore) {
            new CameraDeniedDialog().show(fragmentManager, "dialogInit");
            return;
        }
        Utils.UserAskedCameraPermissionBefore = true;
        activityResultLauncher.launch((Object)"android.permission.CAMERA", null);
    }
}


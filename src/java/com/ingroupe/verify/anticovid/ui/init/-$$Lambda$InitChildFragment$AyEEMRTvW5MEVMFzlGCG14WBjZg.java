/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.core.app.ActivityOptionsCompat
 *  androidx.fragment.app.FragmentActivity
 *  androidx.fragment.app.FragmentManager
 *  com.ingroupe.verify.anticovid.dialog.CameraDeniedDialog
 *  com.ingroupe.verify.anticovid.dialog.CameraRequestDialog
 *  com.ingroupe.verify.anticovid.ui.init.InitChildFragment
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.init;

import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.ingroupe.verify.anticovid.common.Utils;
import com.ingroupe.verify.anticovid.dialog.CameraDeniedDialog;
import com.ingroupe.verify.anticovid.dialog.CameraRequestDialog;
import com.ingroupe.verify.anticovid.ui.init.-$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE;
import com.ingroupe.verify.anticovid.ui.init.InitChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg
implements ActivityResultCallback {
    public final /* synthetic */ InitChildFragment f$0;

    public /* synthetic */ -$$Lambda$InitChildFragment$AyEEMRTvW5MEVMFzlGCG14WBjZg(InitChildFragment initChildFragment) {
        this.f$0 = initChildFragment;
    }

    public final void onActivityResult(Object object) {
        InitChildFragment initChildFragment = this.f$0;
        boolean bl = (Boolean)object;
        Intrinsics.checkNotNullParameter((Object)initChildFragment, (String)"this$0");
        if (bl) {
            new Handler(Looper.getMainLooper()).postDelayed((Runnable)new -$$Lambda$InitChildFragment$H7uhMOapRqMqwiyOWXrxhYuBauE(initChildFragment), 500L);
            return;
        }
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


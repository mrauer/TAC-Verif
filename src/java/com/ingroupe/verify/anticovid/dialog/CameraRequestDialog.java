/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.dialog.-$$Lambda$CameraRequestDialog$_EsBglOMR2lw-v74rIo4Wm_ndrc;
import com.ingroupe.verify.anticovid.dialog.-$$Lambda$CameraRequestDialog$uXFVUDVXKeqT1DUd1Og7vVud0fI;
import kotlin.jvm.internal.Intrinsics;

public final class CameraRequestDialog
extends DialogFragment {
    public final ActivityResultLauncher<String> requestPermissionLauncher;

    public CameraRequestDialog(ActivityResultLauncher<String> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, (String)"requestPermissionLauncher");
        this.requestPermissionLauncher = activityResultLauncher;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Fragment fragment = ((Fragment)this).mParentFragment;
        AlertDialog alertDialog = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this.getActivity(), 2131886082)).setMessage(2131820751).setPositiveButton(17039370, (DialogInterface.OnClickListener)new -$$Lambda$CameraRequestDialog$uXFVUDVXKeqT1DUd1Og7vVud0fI(this)).setNegativeButton(17039360, (DialogInterface.OnClickListener)new -$$Lambda$CameraRequestDialog$_EsBglOMR2lw-v74rIo4Wm_ndrc(fragment)).create();
        Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(ContextThemeWrapper(activity, R.style.AlertDialogCustom))\n            .setMessage(R.string.request_permission_camera)\n            .setPositiveButton(android.R.string.ok) { _, _ ->\n                requestPermissionLauncher.launch(Manifest.permission.CAMERA)\n            }\n            .setNegativeButton(\n                android.R.string.cancel\n            ) { _, _ ->\n                val activity = parent!!.activity\n                activity?.finish()\n            }\n            .create()");
        return alertDialog;
    }
}


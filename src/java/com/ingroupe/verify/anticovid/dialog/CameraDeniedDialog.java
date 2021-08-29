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
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.fragment.app.DialogFragment
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentActivity
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ingroupe.verify.anticovid.dialog.-$$Lambda$CameraDeniedDialog$3MPvzvE5MAlve0FDMi4-ILFI6U4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2={"Lcom/ingroupe/verify/anticovid/dialog/CameraDeniedDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "<init>", "()V", "app_prodRelease"}, k=1, mv={1, 5, 1})
public final class CameraDeniedDialog
extends DialogFragment {
    public static final /* synthetic */ int $r8$clinit;

    public Dialog onCreateDialog(Bundle bundle) {
        Fragment fragment = ((Fragment)this).mParentFragment;
        AlertDialog alertDialog = new AlertDialog.Builder((Context)new ContextThemeWrapper((Context)this.getActivity(), 2131886082)).setMessage(2131820752).setPositiveButton(17039370, (DialogInterface.OnClickListener)new -$$Lambda$CameraDeniedDialog$3MPvzvE5MAlve0FDMi4-ILFI6U4(fragment)).create();
        Intrinsics.checkNotNullExpressionValue((Object)alertDialog, (String)"Builder(ContextThemeWrapper(activity, R.style.AlertDialogCustom))\n            .setMessage(R.string.request_permission_camera_refused)\n            .setPositiveButton(android.R.string.ok) { _, _ ->\n                val activity = parent!!.activity\n                activity?.finish()\n            }\n            .create()");
        return alertDialog;
    }
}


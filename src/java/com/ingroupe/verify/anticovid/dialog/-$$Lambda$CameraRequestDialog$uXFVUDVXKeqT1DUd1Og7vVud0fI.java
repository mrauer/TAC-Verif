/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.core.app.ActivityOptionsCompat
 *  com.ingroupe.verify.anticovid.dialog.CameraRequestDialog
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.dialog;

import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityOptionsCompat;
import com.ingroupe.verify.anticovid.dialog.CameraRequestDialog;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$CameraRequestDialog$uXFVUDVXKeqT1DUd1Og7vVud0fI
implements DialogInterface.OnClickListener {
    public final /* synthetic */ CameraRequestDialog f$0;

    public /* synthetic */ -$$Lambda$CameraRequestDialog$uXFVUDVXKeqT1DUd1Og7vVud0fI(CameraRequestDialog cameraRequestDialog) {
        this.f$0 = cameraRequestDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int n3) {
        CameraRequestDialog cameraRequestDialog = this.f$0;
        Intrinsics.checkNotNullParameter((Object)cameraRequestDialog, (String)"this$0");
        cameraRequestDialog.requestPermissionLauncher.launch((Object)"android.permission.CAMERA", null);
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.drawerlayout.widget.DrawerLayout
 *  com.ingroupe.verify.anticovid.MainActivity
 *  com.ingroupe.verify.anticovid.databinding.ActivityMainBinding
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.ingroupe.verify.anticovid.MainActivity;
import com.ingroupe.verify.anticovid.databinding.ActivityMainBinding;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$MainActivity$S4_CKgSrjUkU_DTH_ECDvK6DnIk
implements View.OnClickListener {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ -$$Lambda$MainActivity$S4_CKgSrjUkU_DTH_ECDvK6DnIk(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    public final void onClick(View view) {
        MainActivity mainActivity = this.f$0;
        Intrinsics.checkNotNullParameter((Object)mainActivity, (String)"this$0");
        ActivityMainBinding activityMainBinding = mainActivity.binding;
        if (activityMainBinding != null) {
            if (activityMainBinding.drawerLayout.isDrawerOpen(8388611)) {
                ActivityMainBinding activityMainBinding2 = mainActivity.binding;
                if (activityMainBinding2 != null) {
                    activityMainBinding2.drawerLayout.closeDrawer(8388611);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
                throw null;
            }
            ActivityMainBinding activityMainBinding3 = mainActivity.binding;
            if (activityMainBinding3 != null) {
                activityMainBinding3.drawerLayout.openDrawer(8388611);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"binding");
        throw null;
    }
}


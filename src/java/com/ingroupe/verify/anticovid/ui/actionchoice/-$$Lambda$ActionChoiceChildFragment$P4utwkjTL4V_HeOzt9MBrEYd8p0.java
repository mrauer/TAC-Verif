/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceChildFragment
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.actionchoice;

import android.content.Context;
import android.view.View;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceChildFragment;
import kotlin.jvm.internal.Intrinsics;

public final class -$$Lambda$ActionChoiceChildFragment$P4utwkjTL4V_HeOzt9MBrEYd8p0
implements View.OnClickListener {
    public final /* synthetic */ ActionChoiceChildFragment f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ -$$Lambda$ActionChoiceChildFragment$P4utwkjTL4V_HeOzt9MBrEYd8p0(ActionChoiceChildFragment actionChoiceChildFragment, Context context) {
        this.f$0 = actionChoiceChildFragment;
        this.f$1 = context;
    }

    public final void onClick(View view) {
        ActionChoiceChildFragment actionChoiceChildFragment = this.f$0;
        Context context = this.f$1;
        Intrinsics.checkNotNullParameter((Object)actionChoiceChildFragment, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)context, (String)"$context");
        actionChoiceChildFragment.showUpdateAppDialog(context, true);
    }
}


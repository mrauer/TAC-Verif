/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.ui.actionchoice;

import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoicePresenter;
import com.ingroupe.verify.anticovid.ui.actionchoice.ActionChoiceView;
import kotlin.jvm.internal.Intrinsics;

public final class ActionChoicePresenterImpl
implements ActionChoicePresenter {
    public final ActionChoiceView view;

    public ActionChoicePresenterImpl(ActionChoiceView actionChoiceView) {
        Intrinsics.checkNotNullParameter((Object)actionChoiceView, (String)"view");
        this.view = actionChoiceView;
    }
}


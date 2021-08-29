/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.common;

import android.app.Activity;

public final class ShowLoadingAnimEvent {
    public final Activity activity;
    public final boolean show;

    public ShowLoadingAnimEvent(Activity activity, boolean bl) {
        this.activity = activity;
        this.show = bl;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 */
package com.ingroupe.verify.anticovid.synchronization.elements;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class Analytics$deleteOldStats$1
extends Lambda
implements Function0<Unit> {
    public final /* synthetic */ Context $context;

    public Analytics$deleteOldStats$1(Context context) {
        this.$context = context;
        super(0);
    }

    public Object invoke() {
        File file = new File(new File(this.$context.getFilesDir(), "TacVerifAnalytics"), "verif_events");
        File file2 = new File(GeneratedOutlineSupport.outline9((File)file, (StringBuilder)new StringBuilder(), (String)".new"));
        File file3 = new File(GeneratedOutlineSupport.outline9((File)file, (StringBuilder)new StringBuilder(), (String)".bak"));
        file.delete();
        file2.delete();
        file3.delete();
        return Unit.INSTANCE;
    }
}


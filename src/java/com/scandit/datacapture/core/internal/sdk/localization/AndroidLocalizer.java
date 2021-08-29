/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.scandit.datacapture.core.internal.sdk.localization;

import android.content.Context;
import android.content.res.Resources;
import com.scandit.datacapture.core.internal.sdk.AppAndroidEnvironment;
import com.scandit.internal.sdk.bar.Localizer;
import kotlin.jvm.internal.Intrinsics;

public final class AndroidLocalizer
extends Localizer {
    public final Resources a;

    public AndroidLocalizer(Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        this.a = context.getResources();
    }

    @Override
    public final String getLocalizedString(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"key");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"defaultLocalizer");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)"string", (String)"type");
        Context context = AppAndroidEnvironment.applicationContext;
        if (context != null) {
            Resources resources = context.getResources();
            Context context2 = AppAndroidEnvironment.applicationContext;
            if (context2 != null) {
                int n2 = resources.getIdentifier(string, "string", context2.getPackageName());
                if (n2 == 0) {
                    return string2;
                }
                String string3 = this.a.getString(n2);
                Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"resources.getString(resId)");
                return string3;
            }
            Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"applicationContext");
        throw null;
    }
}


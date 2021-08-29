/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.scandit.internal.sdk.bar.LocalizerHandler$CppProxy
 *  java.lang.Object
 */
package com.scandit.internal.sdk.bar;

import com.scandit.datacapture.internal.sdk.annotations.DjinniGenerated;
import com.scandit.internal.sdk.bar.Localizer;
import com.scandit.internal.sdk.bar.LocalizerHandler;

/*
 * Exception performing whole class analysis ignored.
 */
@DjinniGenerated
public abstract class LocalizerHandler {
    public LocalizerHandler() {
    }

    public static Localizer getDefaultLocalizer() {
        return CppProxy.getDefaultLocalizer();
    }

    public static void setDefaultLocalizer(Localizer localizer) {
        CppProxy.setDefaultLocalizer((Localizer)localizer);
    }
}


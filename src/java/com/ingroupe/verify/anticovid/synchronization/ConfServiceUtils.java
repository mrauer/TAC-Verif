/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  kotlin.jvm.internal.DefaultConstructorMarker
 */
package com.ingroupe.verify.anticovid.synchronization;

import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncResult;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class ConfServiceUtils {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static interface ConfServiceListener {
        public void saveResult(SyncResult var1);

        public void showErrorMessage(int var1, int var2);

        public void showLoading(boolean var1);
    }

}


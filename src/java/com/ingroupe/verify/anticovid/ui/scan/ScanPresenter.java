/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ingroupe.verify.anticovid.common.SharedViewModel
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 */
package com.ingroupe.verify.anticovid.ui.scan;

import android.content.Context;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public interface ScanPresenter {
    public DocumentResult checkDcc(String var1, Context var2);

    public void checkExpirationAndDo(SharedViewModel var1, Context var2, Function0<Unit> var3);

    public boolean checkQrCode(String var1, Context var2, SharedViewModel var3);

    public void on2dDocDetected(Context var1, String var2);
}


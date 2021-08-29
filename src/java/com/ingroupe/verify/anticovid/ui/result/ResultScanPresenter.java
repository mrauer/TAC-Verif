/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.ingroupe.verify.anticovid.common.SharedViewModel
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ingroupe.verify.anticovid.ui.result;

import android.content.Context;
import com.ingroupe.verify.anticovid.common.SharedViewModel;
import com.ingroupe.verify.anticovid.common.model.ResultScan;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import java.util.ArrayList;

public interface ResultScanPresenter {
    public void prepareErrorResult(ResultScan var1, ArrayList<DocumentErrorsResult> var2, Context var3);

    public void prepareResult(ResultScan var1, String var2, DocumentDataResult var3, ConfResult var4, Context var5, boolean var6);

    public void reloadConf(SharedViewModel var1, Context var2);
}


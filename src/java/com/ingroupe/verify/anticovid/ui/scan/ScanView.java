/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.ui.scan;

import com.ingroupe.verify.anticovid.service.document.model.DocumentResult;

public interface ScanView {
    public void showErrorMessage(int var1, int var2);

    public void showResult(DocumentResult var1);
}


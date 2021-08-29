/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.document.model.DocumentSignatureResult;
import java.io.Serializable;

public abstract class DocumentStaticResult
implements Serializable {
    public boolean hasValidSignature;
    @SerializedName(value="signature")
    private DocumentSignatureResult signature;

    public DocumentStaticResult() {
        this.signature = null;
    }

    public DocumentStaticResult(DocumentSignatureResult documentSignatureResult) {
        this.signature = documentSignatureResult;
    }

    public final DocumentSignatureResult getSignature() {
        return this.signature;
    }

    public final void setSignature(DocumentSignatureResult documentSignatureResult) {
        this.signature = documentSignatureResult;
    }
}


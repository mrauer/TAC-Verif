/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.document.model.DocumentSignatureResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticFieldsResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;

public final class DocumentStatic2ddocResult
extends DocumentStaticResult {
    @SerializedName(value="annexe")
    private DocumentStaticFieldsResult annexe;
    @SerializedName(value="header")
    private DocumentStaticFieldsResult header;
    @SerializedName(value="message")
    private DocumentStaticFieldsResult message;

    public DocumentStatic2ddocResult() {
        this(null, null, null, null, 15);
    }

    public DocumentStatic2ddocResult(DocumentStaticFieldsResult documentStaticFieldsResult, DocumentStaticFieldsResult documentStaticFieldsResult2, DocumentStaticFieldsResult documentStaticFieldsResult3, DocumentSignatureResult documentSignatureResult, int n2) {
        n2 & 1;
        n2 & 2;
        n2 & 4;
        n2 & 8;
        super(null);
        this.header = null;
        this.message = null;
        this.annexe = null;
    }

    public final DocumentStaticFieldsResult getAnnexe() {
        return this.annexe;
    }

    public final DocumentStaticFieldsResult getHeader() {
        return this.header;
    }

    public final DocumentStaticFieldsResult getMessage() {
        return this.message;
    }

    public final void setAnnexe(DocumentStaticFieldsResult documentStaticFieldsResult) {
        this.annexe = documentStaticFieldsResult;
    }

    public final void setHeader(DocumentStaticFieldsResult documentStaticFieldsResult) {
        this.header = documentStaticFieldsResult;
    }

    public final void setMessage(DocumentStaticFieldsResult documentStaticFieldsResult) {
        this.message = documentStaticFieldsResult;
    }
}


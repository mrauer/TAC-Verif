/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.ingroupe.verify.anticovid.service.document.model.DocumentSignatureResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import dgca.verifier.app.decoder.model.GreenCertificate;

public final class DocumentStaticDccResult
extends DocumentStaticResult {
    public GreenCertificate dcc;

    public DocumentStaticDccResult() {
        super(null);
        this.dcc = null;
    }

    public DocumentStaticDccResult(GreenCertificate greenCertificate, DocumentSignatureResult documentSignatureResult) {
        super(documentSignatureResult);
        this.dcc = greenCertificate;
    }

}


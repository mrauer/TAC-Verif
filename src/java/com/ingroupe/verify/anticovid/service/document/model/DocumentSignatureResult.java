/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

public final class DocumentSignatureResult
implements Serializable {
    @SerializedName(value="isValid")
    private Boolean isValid;
    @SerializedName(value="status")
    private String status;

    public DocumentSignatureResult() {
        this(null, null, 3);
    }

    public DocumentSignatureResult(Boolean bl, String string, int n2) {
        n2 & 1;
        n2 & 2;
        this.isValid = null;
        this.status = null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentSignatureResult)) {
            return false;
        }
        DocumentSignatureResult documentSignatureResult = (DocumentSignatureResult)object;
        if (!Intrinsics.areEqual((Object)this.isValid, (Object)documentSignatureResult.isValid)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.status, (Object)documentSignatureResult.status);
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        Boolean bl = this.isValid;
        int n2 = bl == null ? 0 : bl.hashCode();
        int n3 = n2 * 31;
        String string = this.status;
        int n4 = string == null ? 0 : string.hashCode();
        return n3 + n4;
    }

    public final Boolean isValid() {
        return this.isValid;
    }

    public final void setStatus(String string) {
        this.status = string;
    }

    public final void setValid(Boolean bl) {
        this.isValid = bl;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentSignatureResult(isValid=");
        stringBuilder.append((Object)this.isValid);
        stringBuilder.append(", status=");
        stringBuilder.append((Object)this.status);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


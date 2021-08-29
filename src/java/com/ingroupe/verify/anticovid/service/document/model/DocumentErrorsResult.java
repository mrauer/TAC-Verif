/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
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

public final class DocumentErrorsResult
implements Serializable {
    @SerializedName(value="documentNumber")
    private String documentNumber = null;
    @SerializedName(value="error")
    private String error = null;
    @SerializedName(value="message")
    private String message = null;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentErrorsResult)) {
            return false;
        }
        DocumentErrorsResult documentErrorsResult = (DocumentErrorsResult)object;
        if (!Intrinsics.areEqual((Object)this.documentNumber, (Object)documentErrorsResult.documentNumber)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.error, (Object)documentErrorsResult.error)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.message, (Object)documentErrorsResult.message);
    }

    public final String getDocumentNumber() {
        return this.documentNumber;
    }

    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String string = this.documentNumber;
        int n2 = string == null ? 0 : string.hashCode();
        int n3 = n2 * 31;
        String string2 = this.error;
        int n4 = string2 == null ? 0 : string2.hashCode();
        int n5 = 31 * (n3 + n4);
        String string3 = this.message;
        int n6 = string3 == null ? 0 : string3.hashCode();
        return n5 + n6;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentErrorsResult(documentNumber=");
        stringBuilder.append((Object)this.documentNumber);
        stringBuilder.append(", error=");
        stringBuilder.append((Object)this.error);
        stringBuilder.append(", message=");
        stringBuilder.append((Object)this.message);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


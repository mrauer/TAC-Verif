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
 *  java.util.ArrayList
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.document.model.DocumentDataResult;
import com.ingroupe.verify.anticovid.service.document.model.DocumentErrorsResult;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class DocumentResult
implements Serializable {
    @SerializedName(value="data")
    private DocumentDataResult data;
    @SerializedName(value="errors")
    private ArrayList<DocumentErrorsResult> errors;
    @SerializedName(value="resourceType")
    private String resourceType;

    public DocumentResult() {
        this(null, null, null);
    }

    public DocumentResult(DocumentDataResult documentDataResult, ArrayList<DocumentErrorsResult> arrayList, String string) {
        this.data = documentDataResult;
        this.errors = arrayList;
        this.resourceType = string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentResult)) {
            return false;
        }
        DocumentResult documentResult = (DocumentResult)object;
        if (!Intrinsics.areEqual((Object)this.data, (Object)documentResult.data)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.errors, documentResult.errors)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.resourceType, (Object)documentResult.resourceType);
    }

    public final DocumentDataResult getData() {
        return this.data;
    }

    public final ArrayList<DocumentErrorsResult> getErrors() {
        return this.errors;
    }

    public final String getResourceType() {
        return this.resourceType;
    }

    public int hashCode() {
        DocumentDataResult documentDataResult = this.data;
        int n2 = documentDataResult == null ? 0 : documentDataResult.hashCode();
        int n3 = n2 * 31;
        ArrayList<DocumentErrorsResult> arrayList = this.errors;
        int n4 = arrayList == null ? 0 : arrayList.hashCode();
        int n5 = 31 * (n3 + n4);
        String string = this.resourceType;
        int n6 = string == null ? 0 : string.hashCode();
        return n5 + n6;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentResult(data=");
        stringBuilder.append((Object)this.data);
        stringBuilder.append(", errors=");
        stringBuilder.append(this.errors);
        stringBuilder.append(", resourceType=");
        stringBuilder.append((Object)this.resourceType);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


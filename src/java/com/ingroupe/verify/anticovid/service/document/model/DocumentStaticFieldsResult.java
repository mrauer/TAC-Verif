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
import com.ingroupe.verify.anticovid.service.document.model.DocumentFieldResult;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public final class DocumentStaticFieldsResult
implements Serializable {
    @SerializedName(value="error")
    private String error;
    @SerializedName(value="fields")
    private ArrayList<DocumentFieldResult> fields;
    public String label;
    public String type;

    public DocumentStaticFieldsResult() {
        this(null, null, 3);
    }

    public DocumentStaticFieldsResult(ArrayList arrayList, String string, int n2) {
        n2 & 1;
        n2 & 2;
        this.fields = null;
        this.error = null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentStaticFieldsResult)) {
            return false;
        }
        DocumentStaticFieldsResult documentStaticFieldsResult = (DocumentStaticFieldsResult)object;
        if (!Intrinsics.areEqual(this.fields, documentStaticFieldsResult.fields)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.error, (Object)documentStaticFieldsResult.error);
    }

    public final ArrayList<DocumentFieldResult> getFields() {
        return this.fields;
    }

    public int hashCode() {
        ArrayList<DocumentFieldResult> arrayList = this.fields;
        int n2 = arrayList == null ? 0 : arrayList.hashCode();
        int n3 = n2 * 31;
        String string = this.error;
        int n4 = string == null ? 0 : string.hashCode();
        return n3 + n4;
    }

    public final void setError(String string) {
        this.error = string;
    }

    public final void setFields(ArrayList<DocumentFieldResult> arrayList) {
        this.fields = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentStaticFieldsResult(fields=");
        stringBuilder.append(this.fields);
        stringBuilder.append(", error=");
        stringBuilder.append((Object)this.error);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


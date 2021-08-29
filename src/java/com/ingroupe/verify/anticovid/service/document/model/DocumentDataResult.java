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
 *  java.util.Map
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.document.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.document.model.DocumentStaticResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class DocumentDataResult
implements Serializable {
    @SerializedName(value="dynamic")
    private ArrayList<Map<String, String>> dynamic;
    @SerializedName(value="static")
    private DocumentStaticResult static;

    public DocumentDataResult() {
        this(null, null);
    }

    public DocumentDataResult(DocumentStaticResult documentStaticResult, ArrayList<Map<String, String>> arrayList) {
        this.static = documentStaticResult;
        this.dynamic = arrayList;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentDataResult)) {
            return false;
        }
        DocumentDataResult documentDataResult = (DocumentDataResult)object;
        if (!Intrinsics.areEqual((Object)this.static, (Object)documentDataResult.static)) {
            return false;
        }
        return Intrinsics.areEqual(this.dynamic, documentDataResult.dynamic);
    }

    public final ArrayList<Map<String, String>> getDynamic() {
        return this.dynamic;
    }

    public final DocumentStaticResult getStatic() {
        return this.static;
    }

    public int hashCode() {
        DocumentStaticResult documentStaticResult = this.static;
        int n2 = documentStaticResult == null ? 0 : documentStaticResult.hashCode();
        int n3 = n2 * 31;
        ArrayList<Map<String, String>> arrayList = this.dynamic;
        int n4 = arrayList == null ? 0 : arrayList.hashCode();
        return n3 + n4;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentDataResult(static=");
        stringBuilder.append((Object)this.static);
        stringBuilder.append(", dynamic=");
        stringBuilder.append(this.dynamic);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


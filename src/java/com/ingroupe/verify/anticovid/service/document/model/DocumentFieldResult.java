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

public final class DocumentFieldResult
implements Serializable {
    @SerializedName(value="label")
    private String label;
    @SerializedName(value="name")
    private String name;
    @SerializedName(value="value")
    private String value;

    public DocumentFieldResult() {
        this(null, null, null, 7);
    }

    public DocumentFieldResult(String string, String string2, String string3) {
        this.name = string;
        this.label = string2;
        this.value = string3;
    }

    public DocumentFieldResult(String string, String string2, String string3, int n2) {
        n2 & 1;
        n2 & 2;
        n2 & 4;
        this.name = null;
        this.label = null;
        this.value = null;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DocumentFieldResult)) {
            return false;
        }
        DocumentFieldResult documentFieldResult = (DocumentFieldResult)object;
        if (!Intrinsics.areEqual((Object)this.name, (Object)documentFieldResult.name)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.label, (Object)documentFieldResult.label)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.value, (Object)documentFieldResult.value);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String string = this.name;
        int n2 = string == null ? 0 : string.hashCode();
        int n3 = n2 * 31;
        String string2 = this.label;
        int n4 = string2 == null ? 0 : string2.hashCode();
        int n5 = 31 * (n3 + n4);
        String string3 = this.value;
        int n6 = string3 == null ? 0 : string3.hashCode();
        return n5 + n6;
    }

    public final void setLabel(String string) {
        this.label = string;
    }

    public final void setName(String string) {
        this.name = string;
    }

    public final void setValue(String string) {
        this.value = string;
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"DocumentFieldResult(name=");
        stringBuilder.append((Object)this.name);
        stringBuilder.append(", label=");
        stringBuilder.append((Object)this.label);
        stringBuilder.append(", value=");
        stringBuilder.append((Object)this.value);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


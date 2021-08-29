/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.android.tools.r8.GeneratedOutlineSupport
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  kotlin.collections.ArraysKt___ArraysJvmKt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.service.barcode.database.entity;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

public final class Header {
    @SerializedName(value="fields")
    private final List<String> fields;
    @SerializedName(value="version")
    private final String version;

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Header)) {
            return false;
        }
        Header header = (Header)object;
        if (!Intrinsics.areEqual((Object)this.version, (Object)header.version)) {
            return false;
        }
        return Intrinsics.areEqual(this.fields, header.fields);
    }

    public final List<String> getFields() {
        return this.fields;
    }

    public final List<String> getSortedFields() {
        return ArraysKt___ArraysJvmKt.sorted(this.fields);
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return 31 * this.version.hashCode() + this.fields.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = GeneratedOutlineSupport.outline24((String)"Header(version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", fields=");
        stringBuilder.append(this.fields);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}


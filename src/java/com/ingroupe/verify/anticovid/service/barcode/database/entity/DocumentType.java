/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.ingroupe.verify.anticovid.service.barcode.database.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class DocumentType {
    @SerializedName(value="fields")
    private final List<String> fields = null;
    @SerializedName(value="label")
    private final String label = null;
    @SerializedName(value="type")
    private final String type = null;

    public final List<String> getFields() {
        return this.fields;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getType() {
        return this.type;
    }
}


/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.document.database.entity;

import com.google.gson.annotations.SerializedName;

public final class ConfigBarcode2DDoc {
    @SerializedName(value="documentTypeCode")
    private final String documentTypeCode;
    @SerializedName(value="resourceType")
    private final String resourceType;

    public final String getDocumentTypeCode() {
        return this.documentTypeCode;
    }

    public final String getResourceType() {
        return this.resourceType;
    }
}


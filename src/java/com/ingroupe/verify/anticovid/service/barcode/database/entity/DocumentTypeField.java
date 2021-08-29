/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Integer
 */
package com.ingroupe.verify.anticovid.service.barcode.database.entity;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.barcode.database.entity.Field;

public final class DocumentTypeField
extends Field {
    @SerializedName(value="max")
    private final Integer max;
    @SerializedName(value="min")
    private final Integer min;

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }
}


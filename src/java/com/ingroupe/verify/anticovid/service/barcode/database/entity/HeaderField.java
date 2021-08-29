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

public final class HeaderField
extends Field {
    @SerializedName(value="begin")
    private final Integer begin;
    @SerializedName(value="end")
    private final Integer end;

    public final Integer getBegin() {
        return this.begin;
    }

    public final Integer getEnd() {
        return this.end;
    }
}


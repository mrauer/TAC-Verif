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
import com.ingroupe.verify.anticovid.service.barcode.enums.OperationEnum;
import java.util.List;

public abstract class Field {
    @SerializedName(value="label")
    private final String label;
    @SerializedName(value="name")
    private final String name;
    @SerializedName(value="operations")
    private final List<OperationEnum> operations;
    @SerializedName(value="regex")
    private final String regex;

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final List<OperationEnum> getOperations() {
        return this.operations;
    }

    public final String getRegex() {
        return this.regex;
    }
}


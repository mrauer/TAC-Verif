/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public final class ConfField
implements Serializable {
    @SerializedName(value="defaultFormat")
    private String defaultFormat = null;
    @SerializedName(value="label")
    private String label = null;
    @SerializedName(value="name")
    private String name = null;
    @SerializedName(value="order")
    private Integer order = null;
    @SerializedName(value="valuesFormat")
    private Map<String, String> valuesFormat = null;

    public final String getDefaultFormat() {
        return this.defaultFormat;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOrder() {
        return this.order;
    }

    public final Map<String, String> getValuesFormat() {
        return this.valuesFormat;
    }
}


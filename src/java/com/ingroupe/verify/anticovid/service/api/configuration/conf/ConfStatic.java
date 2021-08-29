/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public final class ConfStatic
implements Serializable {
    @SerializedName(value="label")
    private String label = null;
    @SerializedName(value="name")
    private String name = null;
    @SerializedName(value="order")
    private Integer order = null;

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getOrder() {
        return this.order;
    }
}


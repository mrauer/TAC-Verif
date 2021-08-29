/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfField;
import java.io.Serializable;
import java.util.ArrayList;

public final class ConfGroup
implements Serializable {
    @SerializedName(value="fields")
    private ArrayList<ConfField> fields = null;
    @SerializedName(value="label")
    private String labelGroup = null;
    @SerializedName(value="order")
    private Integer orderGroup = null;
    @SerializedName(value="showGroupName")
    private Boolean showGroupName = null;

    public final ArrayList<ConfField> getFields() {
        return this.fields;
    }

    public final String getLabelGroup() {
        return this.labelGroup;
    }

    public final Integer getOrderGroup() {
        return this.orderGroup;
    }

    public final Boolean getShowGroupName() {
        return this.showGroupName;
    }
}


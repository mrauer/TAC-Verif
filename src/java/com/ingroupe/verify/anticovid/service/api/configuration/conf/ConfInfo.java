/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

public final class ConfInfo
implements Serializable {
    @SerializedName(value="validityValuesFormat")
    private Map<String, String> validityValuesFormat = null;

    public final Map<String, String> getValidityValuesFormat() {
        return this.validityValuesFormat;
    }
}


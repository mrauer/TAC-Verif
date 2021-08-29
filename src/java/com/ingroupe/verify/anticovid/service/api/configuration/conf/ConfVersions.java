/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public final class ConfVersions
implements Serializable {
    @SerializedName(value="lastMajorVersion")
    private String lastMajorVersion;
    @SerializedName(value="lastMinorVersion")
    private String lastMinorVersion;

    public final String getLastMajorVersion() {
        return this.lastMajorVersion;
    }

    public final String getLastMinorVersion() {
        return this.lastMinorVersion;
    }
}


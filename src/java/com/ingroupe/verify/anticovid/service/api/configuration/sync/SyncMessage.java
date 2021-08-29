/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 *  java.lang.String
 */
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;

public final class SyncMessage {
    @SerializedName(value="detailEN")
    private String detailEN = null;
    @SerializedName(value="detailFR")
    private String detailFR = null;
    @SerializedName(value="titleEN")
    private String titleEN = null;
    @SerializedName(value="titleFR")
    private String titleFR = null;

    public final String getDetailEN() {
        return this.detailEN;
    }

    public final String getDetailFR() {
        return this.detailFR;
    }

    public final String getTitleEN() {
        return this.titleEN;
    }

    public final String getTitleFR() {
        return this.titleFR;
    }
}


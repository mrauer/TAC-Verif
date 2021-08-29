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

public final class SyncTutorial {
    @SerializedName(value="liteEN")
    private String liteEN = null;
    @SerializedName(value="liteFR")
    private String liteFR = null;

    public final String getLiteEN() {
        return this.liteEN;
    }

    public final String getLiteFR() {
        return this.liteFR;
    }
}


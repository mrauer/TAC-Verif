/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Long
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public final class SyncPeriod
implements Serializable {
    @SerializedName(value="frequency")
    private Long frequency = null;
    @SerializedName(value="step1")
    private Long step1 = null;
    @SerializedName(value="step2")
    private Long step2 = null;
    @SerializedName(value="step3")
    private Long step3 = null;

    public final Long getFrequency() {
        return this.frequency;
    }

    public final Long getStep1() {
        return this.step1;
    }

    public final Long getStep2() {
        return this.step2;
    }

    public final Long getStep3() {
        return this.step3;
    }
}


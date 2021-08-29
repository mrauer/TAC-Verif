/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Integer
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;

public final class SyncValidity {
    @SerializedName(value="recoveryEndDay")
    private Integer recoveryEndDay = null;
    @SerializedName(value="recoveryStartDay")
    private Integer recoveryStartDay = null;
    @SerializedName(value="testNegativeAntigenicEndHour")
    private Integer testNegativeAntigenicEndHour = null;
    @SerializedName(value="testNegativePcrEndHour")
    private Integer testNegativePcrEndHour = null;
    @SerializedName(value="testNegativePrimoAntigenicEndHour")
    private Integer testNegativePrimoAntigenicEndHour = null;
    @SerializedName(value="testNegativePrimoPcrEndHour")
    private Integer testNegativePrimoPcrEndHour = null;
    @SerializedName(value="testPositiveAntigenicEndDay")
    private Integer testPositiveAntigenicEndDay = null;
    @SerializedName(value="testPositiveAntigenicStartDay")
    private Integer testPositiveAntigenicStartDay = null;
    @SerializedName(value="testPositivePcrEndDay")
    private Integer testPositivePcrEndDay = null;
    @SerializedName(value="testPositivePcrStartDay")
    private Integer testPositivePcrStartDay = null;
    @SerializedName(value="vaccineDelay")
    private Integer vaccineDelay = null;
    @SerializedName(value="vaccineDelayJanssen")
    private Integer vaccineDelayJanssen = null;

    public final Integer getRecoveryEndDay() {
        return this.recoveryEndDay;
    }

    public final Integer getRecoveryStartDay() {
        return this.recoveryStartDay;
    }

    public final Integer getTestNegativeAntigenicEndHour() {
        return this.testNegativeAntigenicEndHour;
    }

    public final Integer getTestNegativePcrEndHour() {
        return this.testNegativePcrEndHour;
    }

    public final Integer getTestNegativePrimoAntigenicEndHour() {
        return this.testNegativePrimoAntigenicEndHour;
    }

    public final Integer getTestNegativePrimoPcrEndHour() {
        return this.testNegativePrimoPcrEndHour;
    }

    public final Integer getTestPositiveAntigenicEndDay() {
        return this.testPositiveAntigenicEndDay;
    }

    public final Integer getTestPositiveAntigenicStartDay() {
        return this.testPositiveAntigenicStartDay;
    }

    public final Integer getTestPositivePcrEndDay() {
        return this.testPositivePcrEndDay;
    }

    public final Integer getTestPositivePcrStartDay() {
        return this.testPositivePcrStartDay;
    }

    public final Integer getVaccineDelay() {
        return this.vaccineDelay;
    }

    public final Integer getVaccineDelayJanssen() {
        return this.vaccineDelayJanssen;
    }
}


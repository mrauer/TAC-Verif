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
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncBlacklist;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncTutorial;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncValidity;
import java.io.Serializable;
import java.util.Map;

public final class SyncSpecificValues
implements Serializable {
    @SerializedName(value="blacklist")
    private SyncBlacklist blacklist = null;
    @SerializedName(value="testAntigenicList")
    private Map<String, String> testAntigenicList = null;
    @SerializedName(value="testManufacturerList")
    private Map<String, String> testManufacturerList = null;
    @SerializedName(value="testPcrList")
    private Map<String, String> testPcrList = null;
    @SerializedName(value="tutorial")
    private SyncTutorial tutorial = null;
    @SerializedName(value="vaccineManufacturerList")
    private Map<String, String> vaccineManufacturerList = null;
    @SerializedName(value="vaccineMedicalProductList")
    private Map<String, String> vaccineMedicalProductList = null;
    @SerializedName(value="vaccineProphylaxisList")
    private Map<String, String> vaccineProphylaxisList = null;
    @SerializedName(value="validity")
    private SyncValidity validity = null;

    public final SyncBlacklist getBlacklist() {
        return this.blacklist;
    }

    public final Map<String, String> getTestAntigenicList() {
        return this.testAntigenicList;
    }

    public final Map<String, String> getTestManufacturerList() {
        return this.testManufacturerList;
    }

    public final Map<String, String> getTestPcrList() {
        return this.testPcrList;
    }

    public final SyncTutorial getTutorial() {
        return this.tutorial;
    }

    public final Map<String, String> getVaccineManufacturerList() {
        return this.vaccineManufacturerList;
    }

    public final Map<String, String> getVaccineMedicalProductList() {
        return this.vaccineMedicalProductList;
    }

    public final Map<String, String> getVaccineProphylaxisList() {
        return this.vaccineProphylaxisList;
    }

    public final SyncValidity getValidity() {
        return this.validity;
    }
}


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
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncPeriod;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncSpecificValues;
import java.io.Serializable;
import java.util.Map;

public final class SyncResult
implements Serializable {
    @SerializedName(value="certificates2DDoc")
    private Map<String, String> certificates2DDoc = null;
    @SerializedName(value="certificatesDCC")
    private Map<String, String> certificatesDCC = null;
    @SerializedName(value="period")
    private SyncPeriod period = null;
    @SerializedName(value="specificValues")
    private SyncSpecificValues specificValues = null;

    public final Map<String, String> getCertificates2DDoc() {
        return this.certificates2DDoc;
    }

    public final Map<String, String> getCertificatesDCC() {
        return this.certificatesDCC;
    }

    public final SyncPeriod getPeriod() {
        return this.period;
    }

    public final SyncSpecificValues getSpecificValues() {
        return this.specificValues;
    }
}


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
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfVersions;
import java.io.Serializable;

public final class ConfAbout
implements Serializable {
    @SerializedName(value="androidConfiguration")
    private ConfVersions androidConfiguration = null;
    @SerializedName(value="cgu")
    private String cgu = null;
    @SerializedName(value="lastCGUVersion")
    private String lastCGUVersion = null;
    @SerializedName(value="lastPrivacyPolicyVersion")
    private String lastPrivacyPolicyVersion = null;
    @SerializedName(value="privacyPolicy")
    private String privacyPolicy = null;
    @SerializedName(value="url")
    private String url = null;

    public final ConfVersions getAndroidConfiguration() {
        return this.androidConfiguration;
    }

    public final String getCgu() {
        return this.cgu;
    }

    public final String getLastCGUVersion() {
        return this.lastCGUVersion;
    }

    public final String getLastPrivacyPolicyVersion() {
        return this.lastPrivacyPolicyVersion;
    }

    public final String getPrivacyPolicy() {
        return this.privacyPolicy;
    }

    public final String getUrl() {
        return this.url;
    }
}


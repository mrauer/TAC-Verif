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

public final class ConfContact
implements Serializable {
    @SerializedName(value="details")
    private String details = null;
    @SerializedName(value="mail")
    private String mail = null;
    @SerializedName(value="name")
    private String name = null;
    @SerializedName(value="tel")
    private String tel = null;

    public final String getDetails() {
        return this.details;
    }

    public final String getMail() {
        return this.mail;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTel() {
        return this.tel;
    }
}


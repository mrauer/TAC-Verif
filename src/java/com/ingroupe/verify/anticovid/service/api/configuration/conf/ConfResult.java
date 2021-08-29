/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Object
 *  java.util.ArrayList
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfAbout;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfContact;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfStatic;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfType;
import java.io.Serializable;
import java.util.ArrayList;

public final class ConfResult
implements Serializable {
    @SerializedName(value="about")
    private ConfAbout confAbout = null;
    @SerializedName(value="statics")
    private ArrayList<ConfStatic> confStatic = null;
    @SerializedName(value="contacts")
    private ArrayList<ConfContact> contacts = null;
    @SerializedName(value="types")
    private ArrayList<ConfType> types = null;

    public final ConfAbout getConfAbout() {
        return this.confAbout;
    }

    public final ArrayList<ConfStatic> getConfStatic() {
        return this.confStatic;
    }

    public final ArrayList<ConfContact> getContacts() {
        return this.contacts;
    }

    public final ArrayList<ConfType> getTypes() {
        return this.types;
    }

    public final void setTypes(ArrayList<ConfType> arrayList) {
        this.types = arrayList;
    }
}


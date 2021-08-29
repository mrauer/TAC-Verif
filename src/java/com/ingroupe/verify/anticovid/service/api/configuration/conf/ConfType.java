/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.io.Serializable
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.ingroupe.verify.anticovid.service.api.configuration.conf;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfGroup;
import com.ingroupe.verify.anticovid.service.api.configuration.conf.ConfInfo;
import java.io.Serializable;
import java.util.ArrayList;

public final class ConfType
implements Serializable {
    @SerializedName(value="groups")
    private ArrayList<ConfGroup> groups = null;
    @SerializedName(value="information")
    private ConfInfo information = null;
    @SerializedName(value="resourceType")
    private String resourceType = null;

    public final ArrayList<ConfGroup> getGroups() {
        return this.groups;
    }

    public final ConfInfo getInformation() {
        return this.information;
    }

    public final String getResourceType() {
        return this.resourceType;
    }
}


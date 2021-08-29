/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Boolean
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncBlacklistMessage;
import java.util.List;

public final class SyncBlacklist {
    @SerializedName(value="blacklist2DDOC")
    private List<String> blacklist2DDOC = null;
    @SerializedName(value="blacklistDCC")
    private List<String> blacklistDCC = null;
    @SerializedName(value="duplicateActivate")
    private Boolean duplicateActivate = null;
    @SerializedName(value="duplicateRetentionPeriod")
    private Long duplicateRetentionPeriod = null;
    @SerializedName(value="messages")
    private SyncBlacklistMessage messages = null;

    public final List<String> getBlacklist2DDOC() {
        return this.blacklist2DDOC;
    }

    public final List<String> getBlacklistDCC() {
        return this.blacklistDCC;
    }

    public final Boolean getDuplicateActivate() {
        return this.duplicateActivate;
    }

    public final Long getDuplicateRetentionPeriod() {
        return this.duplicateRetentionPeriod;
    }

    public final SyncBlacklistMessage getMessages() {
        return this.messages;
    }
}


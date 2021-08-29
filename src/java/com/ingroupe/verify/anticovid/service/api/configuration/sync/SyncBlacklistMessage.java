/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.google.gson.annotations.SerializedName
 *  java.lang.Object
 */
package com.ingroupe.verify.anticovid.service.api.configuration.sync;

import com.google.gson.annotations.SerializedName;
import com.ingroupe.verify.anticovid.service.api.configuration.sync.SyncMessage;

public final class SyncBlacklistMessage {
    @SerializedName(value="blacklistLite")
    private SyncMessage blacklistLite = null;
    @SerializedName(value="blacklistOT")
    private SyncMessage blacklistOT = null;
    @SerializedName(value="duplicate")
    private SyncMessage duplicate = null;

    public final SyncMessage getBlacklistLite() {
        return this.blacklistLite;
    }

    public final SyncMessage getBlacklistOT() {
        return this.blacklistOT;
    }

    public final SyncMessage getDuplicate() {
        return this.duplicate;
    }
}


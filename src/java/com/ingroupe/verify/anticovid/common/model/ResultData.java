/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  kotlin.jvm.internal.Intrinsics
 */
package com.ingroupe.verify.anticovid.common.model;

import kotlin.jvm.internal.Intrinsics;

public final class ResultData {
    public String format = "";
    public boolean isGroupHeader;
    public Boolean isSignatureValid;
    public boolean isStatic;
    public String label = "";
    public String name = "";
    public int position;
    public String value = "";
    public boolean withBackground;

    public final void setFormat(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.format = string;
    }

    public final void setLabel(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.label = string;
    }

    public final void setName(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.name = string;
    }

    public final void setValue(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.value = string;
    }
}


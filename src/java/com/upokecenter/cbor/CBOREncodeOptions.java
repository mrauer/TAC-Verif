/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.upokecenter.cbor;

public final class CBOREncodeOptions {
    public static final CBOREncodeOptions Default = new CBOREncodeOptions(false, false);

    public CBOREncodeOptions(boolean bl, boolean bl2) {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("allowduplicatekeys=");
        stringBuilder.append("false");
        stringBuilder.append(";useindeflengthstrings=");
        stringBuilder.append("false");
        stringBuilder.append(";ctap2canonical=");
        stringBuilder.append("false");
        stringBuilder.append(";resolvereferences=");
        stringBuilder.append("false");
        stringBuilder.append(";allowempty=");
        stringBuilder.append("false");
        return stringBuilder.toString();
    }
}


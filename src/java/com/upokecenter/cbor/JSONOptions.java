/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.upokecenter.cbor;

public final class JSONOptions {
    public static final JSONOptions Default = new JSONOptions();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("base64padding=");
        stringBuilder.append("false");
        stringBuilder.append(";replacesurrogates=");
        stringBuilder.append("false");
        return stringBuilder.toString();
    }
}


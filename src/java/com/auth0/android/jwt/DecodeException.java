/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.auth0.android.jwt;

public class DecodeException
extends RuntimeException {
    public DecodeException(String string) {
        super(string);
    }

    public DecodeException(String string, Throwable throwable) {
        super(string, throwable);
    }
}


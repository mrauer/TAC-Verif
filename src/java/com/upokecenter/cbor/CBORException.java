/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.upokecenter.cbor;

public final class CBORException
extends RuntimeException {
    public CBORException(String string) {
        super(string);
    }

    public CBORException(String string, Throwable throwable) {
        super(string, throwable);
    }
}


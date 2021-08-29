/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.auth0.android.jwt;

import com.auth0.android.jwt.DecodeException;

public interface Claim {
    public <T> T asObject(Class<T> var1) throws DecodeException;

    public String asString();
}


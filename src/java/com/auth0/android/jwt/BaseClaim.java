/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.auth0.android.jwt;

import com.auth0.android.jwt.Claim;
import com.auth0.android.jwt.DecodeException;

public class BaseClaim
implements Claim {
    @Override
    public <T> T asObject(Class<T> class_) throws DecodeException {
        return null;
    }

    @Override
    public String asString() {
        return null;
    }
}

